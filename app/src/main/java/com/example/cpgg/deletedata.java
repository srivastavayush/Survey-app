package com.example.cpgg;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class deletedata extends AsyncTask<String,String,String> {
    String msg,id;
    final String table = "SURVEY";
    private final String database = "sql12345672";
    private final String url = "jdbc:mysql://sql12.freemysqlhosting.net/" + database;
    private final String username = "sql12345672";
    private final String password = "jN7jsHQ13q";
    deletedata(String id)
    {
        this.id =id;
    }

    protected String doInBackground(String... strings) {
        msg = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection == null) {
                msg = "Connection failed! Retry";
            } else {
                Statement statement = connection.createStatement();

                String query = "DELETE FROM "+table+" WHERE Start_Time = '"+id+"'";
                statement.executeUpdate(query);

            }
            connection.close();

        } catch (Exception e) {
            msg = "" + e;
            //msg = "Access Denied by Server! Retry";
        }
        return msg;
    }


    @Override
    protected void onPostExecute(String s) {
        //Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

}
