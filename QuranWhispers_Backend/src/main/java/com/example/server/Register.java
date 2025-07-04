package com.example.server;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Register {
    private static final String DB_URL = "jdbc:h2:file:./data/usersdb;INIT=RUNSCRIPT FROM 'classpath:users.sql'";

    public String GET(String email, String username, String password) {
        HashMap<String, String> data = new HashMap<>();
        Gson gson = new Gson();
        data.put("email", email);
        data.put("username", username);

        try (Connection connection = DriverManager.getConnection(DB_URL)) {


            PreparedStatement check = connection.prepareStatement("SELECT 1 FROM USERS WHERE email = ?");
            check.setString(1, email);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                data.put("status", "Email already exists");
                return gson.toJson(data);
            }


            HashingFunction hashFunction = new HashingFunction();
            int hashValue = hashFunction.getHash(password);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS (username, email, password) VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setInt(3, hashValue);
            ps.executeUpdate();

            data.put("status", "Successfully Registered!");
            return gson.toJson(data);

        } catch (Exception e) {
            e.printStackTrace();
            data.put("status", "Server Error");
            return gson.toJson(data);
        }
    }
}
