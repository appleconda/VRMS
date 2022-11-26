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
        
        


    }
}
