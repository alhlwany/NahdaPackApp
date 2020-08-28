package com.sbm.nahdapack.Class;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    String ip,db,DBUserNameStr,DBPasswordStr;

    @SuppressLint("NewApi")
    public static Connection connectionclasss(ConnectionHelper connectionHelper)
    {
        // Declaring Server ip, username, database name and password
        connectionHelper.ip = "192.168.1.19";//192.168.1.19  100.100.100.203  SQL5033.site4now.net
        connectionHelper.db = "heroes";//acc_office_db DB_A5E07D_acc
        connectionHelper.DBUserNameStr = "sa";// sa  DB_A5E07D_acc_admin
        connectionHelper.DBPasswordStr = "sa_itm04";
        // Declaring Server ip, username, database name and password


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        String ConnectionURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + connectionHelper.ip +";databaseName="+ connectionHelper.db + ";user=" + connectionHelper.DBUserNameStr + ";password=" + connectionHelper.DBPasswordStr + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }

}
