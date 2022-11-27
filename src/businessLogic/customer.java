package businessLogic;

import java.lang.reflect.Field;

import db.db_handler;

public class customer extends user{
   
    
    
    public boolean bookAppointment(bookings bkObj, db_handler db)
    {
        try
        {
            db.insert(bkObj); 
            return true; 
        }
        catch (Exception e)
        {
            return false; 
        }

    }

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
