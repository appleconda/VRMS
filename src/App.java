import db.*;
import businessLogic.*;
public class App  {
   
    public static void main(String[] args) throws Exception {
        db_handler db = new db_handler(); 
        user userCust = new customer(); 

        userCust.setId(0);
        userCust.setName("Abdullah");
        userCust.setPassword("password");
        userCust.setUsername("username");

        db.insert_a_user_instance("customer", userCust);
        
        String x = userCust.jdbc_insertString_maker("user"); 
        System.out.println(x);
    }
}
