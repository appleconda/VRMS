package businessLogic;

import java.security.spec.ECPublicKeySpec;

import db.db_handler;

public class superAdmin extends user {
    //bookings management 
    public boolean addBookings(bookings bkObj, db_handler db) 
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

    public boolean rmBookings(bookings bkObj, db_handler db)    
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
    

    //manage users of the applications 
    public boolean addAdmin(admin adminObj, db_handler db)
    {
        try
        {
            db.insert(adminObj); 
            return true; 
        }
        catch (Exception e)
        {
            return false; 
        }
    }

    public boolean addCustomer(customer custObj, db_handler db)
    {
        try
        {
            db.insert(custObj); 
            return true; 
        }
        catch (Exception e)
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

    public boolean rmAdmin(admin adminObj, db_handler db)
    {
        try
        {
            db.remove(adminObj); 
            return true; 
        }
        catch (Exception e)
        {
            return false; 
        }
    }
    // public boolean manage_repair_cars()
    // {

    // }

    public boolean updateProfile()
    {

        return false; 
    }
}
