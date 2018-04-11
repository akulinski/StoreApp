package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Main window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        DbController db=new DbController();
        GUIController controller=new GUIController(db);

        loader.setController(controller);
        GridPane grid=loader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(grid, 1000, 1000));
        primaryStage.hide();
        Login login=new Login(primaryStage);



    }


    public static void main(String[] args)
    {
        launch(args);

    }
}
