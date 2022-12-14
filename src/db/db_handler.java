package db;

import businessLogic.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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

    public boolean delete(String table, String[] conditions) throws SQLException {
        String query = "delete from " + table + " where ";
        String temp = "";
        for (int i = 0; i < conditions.length; i++) {
            temp += conditions[i];
            if (i < conditions.length - 1) {
                temp += " and ";
            }

        }
        query += temp;
        System.out.println(query);
        try (Statement tmt = conn.createStatement()) {
            tmt.executeUpdate(query);
            return true;
        } catch (SQLException sqlex) {
            return false;
        }

    }

    public billing getBillingObj(customer custObj) {
        Vector<Object> billingObj = getAll("businessLogic.billing");
        for (var i : billingObj) {
            if (((billing) i).getCustomer_id().getId() == (custObj.getId())) {
                return ((billing) i);
            }
        }
        System.out.println("nothing found");
        return null;
    }

    public bookings getBookings(customer custObj) {
        Vector<Object> bookingObj = getAll("businessLogic.bookings");
        for (var i : bookingObj) {
            if (((bookings) i).getCustomer_id().getId() == (custObj.getId())) {
                return ((bookings) i);
            }
        }
        return null;
    }

    public boolean remove(Object obj) throws SQLException {
        if (obj.getClass().getName() == "businessLogic.customer") {
            String id = Integer.toString(((customer) obj).getId());
            String condition = "id = " + id;
            String[] conditions = { condition };

            billing bill = getBillingObj(((customer) obj));
            if (bill != null) {
                remove(bill);
            }
            bookings booking = getBookings(((customer) obj));
            if (booking != null) {
                remove(booking);
            }
            delete("customer", conditions);

        } else if (obj.getClass().getName() == "businessLogic.admin") {
            String id = Integer.toString(((admin) obj).getId());
            String condition = "id = " + id;
            String[] conditions = { condition };

            delete("admin", conditions);
        } else if (obj.getClass().getName() == "businessLogic.superAdmin") {

            String id = Integer.toString(((superAdmin) obj).getId());
            String condition = "id = " + id;
            String[] conditions = { condition };

            delete("superAdmin", conditions);
        } else if (obj.getClass().getName() == "businessLogic.bookings") {
            String id = Integer.toString(((bookings) obj).getId());
            String condition = "bk_id = " + id;
            String[] conditions = { condition };

            delete("bookings", conditions);

        } else if (obj.getClass().getName() == "businessLogic.vehicles") {
            String id = ((vehicles) obj).getRegNo();
            String condition = "regNo = '" + id + "'";
            String[] conditions = { condition };

            delete("vehicles", conditions);
        } else if (obj.getClass().getName() == "businessLogic.inventory") {
            String name = ((inventory) obj).getName();
            String condition = "name = '" + name + "'";
            String[] conditions = { condition };
            delete("inventory", conditions);

        } else if (obj.getClass().getName() == "businessLogic.billing") {
            String id = Integer.toString(((billing) obj).getBill_id());
            String condition = "bill_id = " + id;
            String[] conditions = { condition };

            delete("billing", conditions);
        }

        else {
            System.out.println("Classname not found");
        }
        return true;
    }

    public boolean updateTable(String table, String column, String value, String[] conditions) throws SQLException {
        String query = "update " + table + " set " + column + " = '" + value + "' where ";
        String temp = "";
        for (int i = 0; i < conditions.length; i++) {
            temp += conditions[i];
            if (i < conditions.length - 1) {
                temp += " and ";
            }

        }
        query += temp;
        System.out.println(query);
        try (Statement tmt = conn.createStatement()) {
            tmt.executeUpdate(query);
            return true;
        } catch (SQLException sqlex) {
            return false;
        }

    }

    public boolean insert(Object clobj) {
        String query = "";
        String query1 = "";
        int ifCustomerWasCreated = 0;
        if (clobj.getClass().getName() == "businessLogic.customer") {
            query = ((user) clobj).jdbc_insertString_maker("customer");

            // associating a billing class with every customer
            billing bill = new billing(((customer) clobj));
            bill.setAmount(0);
            bill.setBill_id(((customer) clobj).getId());
            query1 = bill.jdbc_insertString_maker();
            System.out.println(query1);
            System.out.println(query);

        } else if (clobj.getClass().getName() == "businessLogic.admin") {
            query = ((user) clobj).jdbc_insertString_maker("admin");
            System.out.println(query);
        } else if (clobj.getClass().getName() == "businessLogic.superAdmin") {
            query = ((user) clobj).jdbc_insertString_maker("superAdmin");
            System.out.println(query);
        } else if (clobj.getClass().getName() == "businessLogic.bookings") {
            query = ((bookings) clobj).jdbc_insertString_maker();
        } else if (clobj.getClass().getName() == "businessLogic.vehicles") {
            query = ((vehicles) clobj).jdbc_insertString_maker();
        } else if (clobj.getClass().getName() == "businessLogic.inventory") {
            query = ((inventory) clobj).jdbc_insertString_maker();
            System.out.println(query);
        } else if (clobj.getClass().getName() == "businessLogic.billing") {
            query = ((billing) clobj).jdbc_insertString_maker();
        } else if (clobj.getClass().getName() == "businessLogic.serviceRequest") {
            query = ((serviceReqeust) clobj).jdbc_insertString_maker();
        } else {
            System.out.println("ClassName not found");
        }

        try (Statement tmt = conn.createStatement()) {
            tmt.executeUpdate(query);
            tmt.executeUpdate(query1);
            return true;
        } catch (SQLException sqlex) {
            return false;
        }
    }

    public Vector<Object> getAll(String className) {
        Vector<Object> clobj = new Vector<Object>();
        if (className.equals("businessLogic.customer")) {
            String query = "select * from customer";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new customer();
                    ((customer) obj).setId(rs.getInt("id"));
                    ((customer) obj).setUsername(rs.getString("username"));
                    ((customer) obj).setPassword(rs.getString("password"));
                    ((customer) obj).setName(rs.getString("name"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }

        } else if (className.equals("businessLogic.admin")) {
            String query = "select * from admin";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new admin();
                    ((admin) obj).setId(rs.getInt("id"));
                    ((admin) obj).setUsername(rs.getString("username"));
                    ((admin) obj).setPassword(rs.getString("password"));
                    ((admin) obj).setName(rs.getString("name"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }
        } else if (className.equals("businessLogic.superAdmin")) {
            String query = "select * from superAdmin";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new superAdmin();
                    ((superAdmin) obj).setId(rs.getInt("id"));
                    ((superAdmin) obj).setUsername(rs.getString("username"));
                    ((superAdmin) obj).setPassword(rs.getString("password"));
                    ((superAdmin) obj).setName(rs.getString("name"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }

        } else if (className.equals("businessLogic.bookings")) {
            String query = "select * from bookings";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("customer", strs);
                    Object obj = new bookings(((customer) returned_cust_obj.firstElement()));
                    ((bookings) obj).setDate(rs.getString("date"));
                    ((bookings) obj).setTime(rs.getString("time"));
                    ((bookings) obj).setId(rs.getInt("id"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }

        } else if (className.equals("businessLogic.vehicles")) {
            String query = "select * from vehicles";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("customer", strs);
                    Object obj = new vehicles(((customer) returned_cust_obj.firstElement()));
                    ((vehicles) obj).setColor((rs.getString("color")));
                    ((vehicles) obj).setRegNo((rs.getString("regNo")));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }

        } else if (className.equals("businessLogic.inventory")) {
            String query = "select * from inventory";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new Object();
                    ((inventory) obj).setName((rs.getString("name")));
                    ((inventory) obj).setQuantity((rs.getInt("quantity")));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }

        } else if (className.equals("businessLogic.billing")) {
            String query = "select * from billing";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("businessLogic.customer", strs);
                    Object obj = new billing(((customer) returned_cust_obj.firstElement()));
                    ((billing) obj).setAmount(rs.getInt("amount"));
                    ((billing) obj).setBill_id(rs.getInt("bill_id"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("caught sql exception");
            }
        } else if (className.equals("businessLogic.serviceRequest")) {
            String query = "select * from serviceRequest";
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("businessLogic.customer", strs);
                    Object obj = new serviceReqeust(((customer) returned_cust_obj.firstElement()));
                    ((serviceReqeust) obj).setRegNo(rs.getString("RegNo"));
                    ((serviceReqeust) obj).setSr_id(rs.getInt("sr_id"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
            }
        } else {
            System.out.println("Class Name not found");
        }
        return clobj;
    }

    public Vector<Object> conditional_get(String className, String[] conditions) {
        Vector<Object> clobj = new Vector<Object>();
        // conditional get for CUSTOMER
        if (className.equals("businessLogic.customer")) {
            String query = "select * from customer where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new customer();
                    ((customer) obj).setId(rs.getInt("id"));
                    ((customer) obj).setUsername(rs.getString("username"));
                    ((customer) obj).setPassword(rs.getString("password"));
                    ((customer) obj).setName(rs.getString("name"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");
            }

        }
        // Conditional get for ADMIN
        else if (className.equals("businessLogic.admin")) {
            String query = "select * from admin where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new admin();
                    ((admin) obj).setId(rs.getInt("id"));
                    ((admin) obj).setUsername(rs.getString("username"));
                    ((admin) obj).setPassword(rs.getString("password"));
                    ((admin) obj).setName(rs.getString("name"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else if (className.equals("businessLogic.superAdmin")) {
            String query = "select * from superAdmin where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new superAdmin();
                    ((superAdmin) obj).setId(rs.getInt("id"));
                    ((superAdmin) obj).setUsername(rs.getString("username"));
                    ((superAdmin) obj).setPassword(rs.getString("password"));
                    ((superAdmin) obj).setName(rs.getString("name"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else if (className.equals("businessLogic.bookings")) {
            String query = "select * from bookings where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("businessLogic.customer", strs);
                    Object obj = new bookings(((customer) returned_cust_obj.firstElement()));
                    ((bookings) obj).setDate(rs.getString("date"));
                    ((bookings) obj).setTime(rs.getString("time"));
                    ((bookings) obj).setId(rs.getInt("id"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else if (className.equals("businessLogic.vehicles")) {
            String query = "select * from vehicles where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("businessLogic.customer", strs);
                    Object obj = new vehicles(((customer) returned_cust_obj.firstElement()));
                    ((vehicles) obj).setColor((rs.getString("color")));
                    ((vehicles) obj).setRegNo((rs.getString("regNo")));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else if (className.equals("businessLogic.inventory")) {
            String query = "select * from inventory where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;
            System.out.println(query);
            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    Object obj = new inventory();
                    ((inventory) obj).setName((rs.getString("name")));
                    ((inventory) obj).setQuantity((rs.getInt("quantity")));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else if (className.equals("businessLogic.billing")) {
            String query = "select * from billing where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("businessLogic.customer", strs);
                    Object obj = new billing(((customer) returned_cust_obj.firstElement()));
                    ((billing) obj).setAmount((rs.getInt("amount")));
                    ((billing) obj).setBill_id((rs.getInt("bill_id")));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else if (className.equals("businessLogic.serviceRequest")) {
            String query = "select * from serviceRequest where ";
            String temp = "";
            for (int i = 0; i < conditions.length; i++) {
                temp += conditions[i];
                if (i < conditions.length - 1) {
                    temp += " and ";
                }

            }
            query += temp;

            try (Statement tmt = conn.createStatement()) {
                ResultSet rs = tmt.executeQuery(query);
                while (rs.next()) {
                    int cust_id = rs.getInt("customer_id");
                    String str = "id = " + cust_id;
                    String[] strs = { str };
                    Vector<Object> returned_cust_obj = conditional_get("businessLogic.customer", strs);
                    Object obj = new serviceReqeust(((customer) returned_cust_obj.firstElement()));
                    ((serviceReqeust) obj).setRegNo(rs.getString("RegNo"));
                    ((serviceReqeust) obj).setSr_id(rs.getInt("sr_id"));
                    clobj.add(obj);
                }
            } catch (SQLException sqlex) {
                System.out.println("SQL exception thrown");

            }
        } else {
            System.out.println("Class name not found");
        }

        return clobj;
    }
}
