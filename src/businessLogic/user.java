package businessLogic;

import db.*; 
import java.lang.reflect.Field;
import java.lang.Class;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class user {
    private String username;
    private String password;
    private String name;
    private int id;
    

    public user(){}

    abstract boolean updateProfile();

   

    public String jdbc_insertString_maker(String table) {


        Class<?> clobj = this.getClass();
        Field[] fields = clobj.getSuperclass().getDeclaredFields();

        // Class<?> cl = this.getClass();
        // List<Field> fields = getAllFields(this.getClass());

        String names = "";
        String values = "";

        for (int i = 0; i < fields.length; i++) {
            try {
                String name1 = fields[i].getName();
                String value = fields[i].get(this).toString();
                if (i != 0) {
                    names = names + ", ";
                    values = values + ", ";

                }
                if (fields[i].get(this) instanceof String) {
                    values = values + "'" + value + "'";
                } else {
                    values = values + value;
                }
                names = names + name1;
            } catch (IllegalAccessException ex) {
                System.out.println(
                        "--jdbc_insertString_maker caught IllegalAccessException\n on " + this.getClass().getName());
            } catch (NullPointerException npex) {
                System.out.println(
                        "--jdbc_insertString_maker caught nullPointerException\nPlease make sure no attributes of "
                                + this.getClass().getName() + " are null--");
                System.exit(0);
            }

        }
        String sql = "insert into " + table + "(" + names + ")values(" + values + ");";
        return sql;
    }
    
    
    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "user [username=" + username + ", password=" + password + ", name=" + name + ", id=" + id + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
