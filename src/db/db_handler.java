package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import businessLogic.user;

public class db_handler {

    private Connection conn;

    // Constructor
    public db_handler() {
        try {
            String url = "jdbc:sqlserver://APPLECONDA\\SQLEXPRESS;databaseName=test;integratedSecurity=true;encrypt=false";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection not successful -- terminating the program");
            System.exit(0);
            e.printStackTrace();
        }
    }

    public void updateTable(String table, String column, String value, String[] conditions) throws SQLException {
        PreparedStatement prepStatement = null;
        String query = "UPDATE ? SET ? = ? WHERE ";
        String[] condSplits;
        HashMap<String, String> map = new HashMap<String, String>();
        Integer i = 1;

        for (String parameter : conditions) {
            condSplits = parameter.split(" ");
            map.put(condSplits[0], condSplits[2]);
            query += "? " + condSplits[1] + "?";

            if (i == conditions.length) {
                query += " AND ";
            }
            i++;
        }

        prepStatement = this.conn.prepareStatement(query);

        prepStatement.setString(1, table);
        prepStatement.setString(2, column);

        i = 2;
        for (Map.Entry<String, String> condition : map.entrySet()) {
            prepStatement.setString(++i, condition.getKey());
            prepStatement.setString(++i, condition.getKey());
        }

        prepStatement.executeQuery();
        this.conn.commit();
    }

    public boolean insert_a_user_instance(String table, user obj) {
        String query = obj.jdbc_insertString_maker(table);

        try (Statement tmt = conn.createStatement()) {
            tmt.executeUpdate(query);
            return true;
        } catch (SQLException sqlex) {
            return false;
        }
    }
}
