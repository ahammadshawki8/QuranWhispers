package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.GlobalState;

import java.io.File;
import java.io.IOException;

public class ShareController extends SearchController{

    @FXML TextField receiverUsername;
    @FXML ImageView versePosterView;
    @FXML Label categoryField;

    public void setupPoster(String posterPath, String categoryName) {
        File posterFile = new File(posterPath);
        if (posterFile.exists()) {
            Image poster = new Image(posterFile.toURI().toString());
            versePosterView.setImage(poster);
        } else {
            System.out.println("Poster file not found: " + posterFile.getAbsolutePath());
        }
        categoryField.setText(categoryName);
    }


    public void handleCloseBtn(MouseEvent e) throws IOException {
        System.out.println("Close Button Pressed");
        playClickSound();
        sceneController.switchTo(GlobalState.SEARCH_FILE);
    }

    public void handleSendBtn(MouseEvent e) throws IOException {
        System.out.println("Send Button Pressed");
        playClickSound();
    }
}
