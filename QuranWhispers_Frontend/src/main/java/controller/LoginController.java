package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import util.GlobalState;

import java.io.IOException;

public class LoginController extends BaseController{
    @FXML TextField usernameField;
    @FXML TextField passwordField;

    public void handleSignupBtn(MouseEvent e) throws IOException {
        System.out.println("SignUp Button pressed");
        sceneController.switchTo(GlobalState.SIGNUP_FILE);
        playClickSound();
    }

    public void handleContinueBtn(MouseEvent e) throws IOException {
        System.out.println("Continue button pressed");
        sceneController.switchTo(GlobalState.HOME_PAGE_FILE);
        playClickSound();
    }



}
