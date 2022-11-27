package businessLogic;

import java.lang.reflect.Field;

public class vehicles {
    private customer customer_id;
    private String regNo;
    private String color;

    public vehicles(user customer_id) {this.customer_id = (customer)customer_id;}

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


    public vehicles(customer owner) {
        this.customer_id = owner;
    }

    public customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(customer owner) {
        this.customer_id = owner;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
