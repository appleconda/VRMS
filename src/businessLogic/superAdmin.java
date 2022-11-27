package businessLogic;



import java.security.spec.ECPrivateKeySpec;

import db.db_handler;
import javafx.util.converter.IntegerStringConverter;

public class superAdmin extends user {
    public superAdmin(String username, String password, String name, int id) {
        super(username, password, name, id);
        
    }

    public superAdmin()
    {
        
    }

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
            db.remove(bkObj); 
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
    
    //managing vehicles in the shop
    public boolean addVehicle(vehicles veh,db_handler db)
    {
        try
        {
            db.insert(veh); 
            return true; 
        }
        catch(Exception e)
        {
            return false; 
        }
    }

    public boolean rmVehicle(vehicles veh, db_handler db)
    {
        try
        {
            db.remove(veh); 
            return true; 
        }
        catch(Exception e)
        {
            return false; 
        }
    }


    //managing inventory 
    public boolean addInventory(inventory inv, db_handler db )
    {
        try
        {
            db.insert(inv); 
            return true; 
        }
        catch (Exception e)
        {
            return false; 
        }
    }
    public boolean rmInventory(inventory inv, int quantity, db_handler db)
    {
        try 
        {
            if (inv.getQuantity() == quantity)
            {
                System.out.println("came here");
                db.remove(inv); 
            }
            else 
            {
                int val = inv.getQuantity() - quantity; 
                String value = Integer.toString(val); 
                String temp = "name = '" + inv.getName() + "'"; 
                String[] conditions = {temp}; 
                db.updateTable("inventory", "quantity", value, conditions); 
            }
            return true; 
        }
        catch(Exception e)
        {
            return false; 
        }
    }

    public boolean updateProfile()
    {

        return false; 
    }
}
