package sample;

import java.io.IOException;
import java.sql.*;

public class AccountsDb {
    //class that manages login

    private Connection connection;
    private PreparedStatement statement;



    AccountsDb()
    {

        try
        {
            //connection
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:accounts.db");
            System.out.println("database accounts opend");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }

    public boolean login(String name,String password) {

        int count = -1;
        try
        {
            //select all rows that match login ans password
            String sql = "SELECT COUNT(*) FROM ACCOUNTS WHERE LOGIN=? AND PASSWORD=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            count = resultSet.getInt(1);
            System.out.println(count);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        if (count == 1)
        {
            return true;
        }
        else if (count >= 2)
        {
            try
            {
                throw new java.io.IOException("Returned more than one account");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(count==0)
        {
            return false;
        }

        return false;
    }



}
