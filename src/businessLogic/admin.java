package businessLogic;

import db.db_handler;

public class admin extends user{
   
    public admin(String username, String password, String name, int id)
    {
        super(username, password, name, id);
    }

    public admin()
    {
        
    }
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
