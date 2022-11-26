import db.*;

import java.util.Vector;

import businessLogic.*;
public class App  {
   
    public static void main(String[] args) throws Exception {
        db_handler db = new db_handler(); 
        user userCust = new customer(); 

        userCust.setId(3);
        userCust.setName("Abdullah");
        userCust.setPassword("password");
        userCust.setUsername("username");

        Object obj = new customer();
        obj = userCust;
        Vector<Object> objs = db.getAll("businessLogic.customer"); 
        System.out.println(((customer)objs.get(0)).getName());
        //db.insert(obj);
        String[] str = {"id = 1"};
        db.updateTable("customer", "name", "hammad2.0", str);
    }
}
