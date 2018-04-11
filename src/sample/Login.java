package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Login{
    @FXML
    Button confirm;

    public TextField getLogin() {
        return login;
    }

    public PasswordField getPassword() {
        return password;
    }

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    public boolean isFlag() {
        return flag;
    }

    private Stage primaryStage;
    boolean flag=false;
    private Stage loginStage;
    Login(Stage primaryStage)
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        loader.setController(this);
        loginStage = new Stage();
        this.primaryStage=primaryStage;
        try {
            AnchorPane anchorPane=loader.load();
            Scene scene = new Scene(anchorPane);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean login(ActionEvent actionEvent)
    {
            loginStage.hide();
            this.flag=true;
            this.primaryStage.show();
            return true;
    }
}
