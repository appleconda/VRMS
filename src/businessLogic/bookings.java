package businessLogic;

import java.lang.reflect.Field;

public class bookings {
    private String date;
    private String time;
    private int bk_id;
    customer customer_id; 
    
    public bookings(user customer_id) {this.customer_id = (customer)customer_id;}

    public String jdbc_insertString_maker() {
        String table = "bookings"; 
        
        Field[] fields = this.getClass().getDeclaredFields();

        // Class<?> cl = this.getClass();
        // List<Field> fields = getAllFields(this.getClass());

        String names = "";
        String values = "";

        for (int i = 0; i < fields.length; i++) {
            try {
                String name1 = "";
                String value = "";

                if (fields[i].get(this) instanceof String || fields[i].get(this) instanceof Integer) {
                    name1 = fields[i].getName();
                    value = fields[i].get(this).toString();
                }
                if (fields[i].get(this) instanceof customer)
                {
                    name1=fields[i].getName(); 
                    value = Integer.toString(((customer)fields[i].get(this)).getId());
                }
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
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return bk_id;
    }

    public void setId(int id) {
        this.bk_id = id;
    }

    public customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(customer customer_id) {
        this.customer_id = customer_id;
    }

}
