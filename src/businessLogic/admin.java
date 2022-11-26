package businessLogic;

import db.db_handler;

public class admin extends user{
    
    public boolean addCustomer(customer custObj, db_handler db)
    {
        try 
        {
            db.insert(custObj); 
            return true; 
        }catch (Exception e)
        {
            return false; 
        }
    }

    public boolean rmCustomer(customer custObj, db_handler db)
    {
        try
        {
            db.remove(custObj); 
            return true; 
        }
        catch (Exception e)
        {
            return false; 
        }
    }

    public boolean updateProfile()
    {

        return false; 
    }
}
