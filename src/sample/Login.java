package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    Login(GUIController controller)
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        loader.setController(controller);
        Stage login = new Stage();
        try {
            AnchorPane anchorPane=loader.load();
            Scene scene = new Scene(anchorPane);
            login.setScene(scene);
            login.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
