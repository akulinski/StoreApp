package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javax.swing.text.html.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class GUIController implements Initializable {
    @FXML
    private javafx.scene.control.ListView<String> listView;
    private DbController controller=null;

    public GUIController(DbController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }

    public void PrintAllTRacks(ActionEvent actionEvent) {

            controller.printallTracks();

            ObservableList<String> items = listView.getItems();
            Iterator<String> it=controller.getTrackList().listIterator();

            while(it.hasNext())
            {
                String name=it.next();
                items.add(name);
                listView.getItems().add(name);
            }





    }
}
