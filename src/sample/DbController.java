package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import javax.sql.*;

public class DbController {
    private Connection connection=null;
    private Statement statement=null;

    public LinkedList<String> getTrackList() {
        return TrackList;
    }


    private LinkedList<String> TrackList;

    public LinkedList<String> getSongs() {
        return songs;
    }

    private LinkedList<String> songs;


    DbController()
    {
        TrackList=new LinkedList<String>();
        songs=new LinkedList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chinook.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void printallTracks()
    {
        try
        {
            statement=connection.createStatement();
            String sql="SELECT Name FROM tracks; ";

            ResultSet set=statement.executeQuery(sql);

            while (set.next())
            {
                String  name = set.getString("Name");
                this.TrackList.add(name);
                System.out.println(name);
            }
        }
        catch (java.sql.SQLException ex)
        {
            System.out.println(ex.getErrorCode());
        }


    }

    public void getSongs(int value)
    {


        try{
            String sql="SELECT * FROM tracks WHERE Milliseconds > ?";
            PreparedStatement statment=connection.prepareStatement(sql);

            statment.setInt(1,value);;
            ResultSet resultSet=statment.executeQuery();

            while(resultSet.next())
            {
                String name=resultSet.getString(2);
                songs.add(name);
            }
        }
        catch (java.sql.SQLException ex)
        {
            ex.getErrorCode();
        }
    }

}
