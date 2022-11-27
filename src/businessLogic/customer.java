package businessLogic;

import java.lang.reflect.Field;

import db.db_handler;

public class customer extends user{
   
    
    
    //Use cases of customers 
    // public boolean bookAppointment()
    // {

    // }

    // public boolean updateProfile()
    // {

    // }

    // public boolean payment()
    // {

    // }

    // public boolean serviceRequest()
    // {

    // }

   
    public customer ()
    {
        
    }

    public customer(String username, String password, String name, int id) {
        super(username, password, name, id);
        
    }

    public boolean updateProfile()
    {

        return false; 
    }

    

}
