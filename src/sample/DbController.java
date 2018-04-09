package sample;

import java.sql.*;
import javax.sql.*;

public class DbController {
    private Connection connection=null;
    private Statement statement=null;

    DbController()
    {

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
                System.out.println(name);
            }
        }
        catch (java.sql.SQLException ex)
        {
            System.out.println(ex.getErrorCode());
        }


    }

}
