package sample;

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

    DbController()
    {
        TrackList=new LinkedList<String>();
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

}
