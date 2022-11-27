package businessLogic;

import java.lang.reflect.Field;

public class inventory {
    private String name; 
    private int quantity; 

    public inventory()
    {
        name = ""; 
        quantity = 0; 
    }

   
    public String jdbc_insertString_maker() {
        String table = "inventory";

        
        Field[] fields = this.getClass().getDeclaredFields();

        // Class<?> cl = this.getClass();
        // List<Field> fields = getAllFields(this.getClass());

        String names = "";
        String values = "";

        for (int i = 0; i < fields.length; i++) {
            try {
                String name1 = ""; 
                String value = ""; 
                
                if (fields[i].get(this) instanceof String || fields[i].get(this) instanceof Integer)
                {
                    name1 = fields[i].getName(); 
                    value = fields[i].get(this).toString();
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
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
