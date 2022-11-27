package ui;

import java.net.Inet4Address;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import businessLogic.*; 
import db.*; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;

public class Home_Admin_Controller {

	private db_handler db; 
	private superAdmin supAdmin; 

	

	public db_handler getDb() {
		return db;
	}

	public void setDb(db_handler db) {
		this.db = db;
	}

	public superAdmin getSupAdmin() {
		return supAdmin;
	}

	public void setSupAdmin(superAdmin supAdmin) {
		this.supAdmin = supAdmin;
	}


	public Integer TotalCost;
	
    @FXML
    private Button Log_out;

    @FXML
    private Button Inventory_btn;

    @FXML
    private Button Customers_btn;

    @FXML
    private Button Service_Request_btn;

    @FXML
    private Button System_Admin_btn;

    @FXML
    private Button Car_List_btn;

    @FXML
    private AnchorPane Main_pane;

    @FXML
    private AnchorPane Inventory_pane;

    @FXML
    private Button add_inv_btn;

    @FXML
    private Button remove_inv_btn;

    @FXML
    private ListView<?> Inventory_List;

    @FXML
    private AnchorPane info_pane;

    @FXML
    private AnchorPane Customers_pane;

    @FXML
    private Button add_cust_btn;

    @FXML
    private Button remove_cust_btn;

    @FXML
    private ListView<?> Customer_List;

    @FXML
    private AnchorPane Cust_add_pane;

    @FXML
    private TextField cust_name;

    @FXML
    private TextField cust_username;

    @FXML
    private TextField cust_password;

    @FXML
    private Button cust_apply_add;

    @FXML
    private TextField cust_ID;

    @FXML
    private AnchorPane cust_remove_pane;

    @FXML
    private TextField cust_ID_R;

    @FXML
    private TextField cust_username_R;

    @FXML
    private TextField cust_name_R;

    @FXML
    private Button cust_apply_remove;

    @FXML
    private AnchorPane add_item_pane;

    @FXML
    private TextField inventory_name;

    @FXML
    private TextField inventory_quantity;

    @FXML
    private Button Inventory_apply_add;

    @FXML
    private AnchorPane remove_item_pane;

    @FXML
    private TextField inventory_name_R;

    @FXML
    private TextField inventory_quantity_R;

    @FXML
    private Button Inventory_apply_remove;

    @FXML
    private AnchorPane Service_Request_Pane;

    @FXML
    private Button add_booking_btn;

    @FXML
    private Button remove_booking_btn;

    @FXML
    private ListView<?> Service_list;

    @FXML
    private AnchorPane System_Admin_pane;

    @FXML
    private ListView<?> System_Admin_list;

    @FXML
    private AnchorPane remove_booking_pane;

    @FXML
    private TextField Reg_num_R;

    @FXML
    private Button booking_apply_remove;

    @FXML
    private TextField Service_ID_R;

    @FXML
    private AnchorPane Cars_pane;

    @FXML
    private Button add_cars_btn;

    @FXML
    private Button remove_cars_btn;

    @FXML
    private ListView<?> Cars_List;

    @FXML
    private AnchorPane add_car_pane;

    @FXML
    private TextField Cust_ID_Car;

    @FXML
    private TextField Reg_Num_Car;

    @FXML
    private Button Car_apply_add;

    @FXML
    private TextField Color;

    @FXML
    private AnchorPane Remove_Car_Pane;

    @FXML
    private TextField Cust_ID_Car_R;

    @FXML
    private TextField Reg_Num_Car_R;

    @FXML
    private Button Car_apply_remove;

    @FXML
    private TextField Color_R;

    @FXML
    private AnchorPane add_booking_pane;

    @FXML
    private Button New_booking;

    @FXML
    private TextField Cust_ID;

    @FXML
    private TextField Date;

    @FXML
    private TextField Time;

    @FXML
    private TextField Booking_ID;

    @FXML
    void Car_List_Clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(true);
    	
    	
    	
    	

    }

    @FXML
    void Car_apply_add_clicked(ActionEvent event) {
    	String customerID = "";
    	String Vehicle_reg_num = "";
    	String color = "";
    	customerID = Cust_ID_Car.getText(); 
    	Vehicle_reg_num = Reg_Num_Car.getText();
    	color = Color.getText();
		

		int int_custid = Integer.parseInt(customerID); 
		String condition = "id = " + int_custid; 
		String conditions[] = {condition}; 
		Vector<Object> getCust = db.conditional_get("businessLogic.customer", conditions); 

		vehicles veh = new vehicles(((customer)getCust.firstElement())); 
		veh.setColor(color);
		veh.setRegNo(Vehicle_reg_num);

		supAdmin.addVehicle(veh, db); 

    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(true);
    	Cars_pane.setVisible(false);
    	
    	
    	
    	
    	

    }
    @FXML
    boolean Wrap_btn_clicked(ActionEvent event) {
    	return true;
    }
    @FXML
    boolean Painting_clicked(ActionEvent event) {
    	return true;
    }
    @FXML
    boolean Modify_clicked(ActionEvent event) {
    	return true;
    }   
    @FXML
    boolean Denting_clicked(ActionEvent event) {
    	return true;
    }

    @FXML
    void Car_apply_remove_clicked(ActionEvent event) {
    	String customerID = "";
    	String Vehicle_reg_num = "";
    	String color = "";

    	customerID = Cust_ID_Car_R.getText();
    	Vehicle_reg_num = Reg_Num_Car_R.getText();
    	color = Color_R.getText();
    	
		int int_custid = Integer.parseInt(customerID); 
		String condition = "id = " + int_custid; 
		String conditions[] = {condition}; 
		Vector<Object> getCust = db.conditional_get("businessLogic.customer", conditions); 

		vehicles veh = new vehicles(((customer)getCust.firstElement())); 
		veh.setColor(color);
		veh.setRegNo(Vehicle_reg_num);
		supAdmin.rmVehicle(veh, db); 


    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(true);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    	
    }

    @FXML
    void remove_cars_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(true);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }   
    @FXML
    void add_cars_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(true);
    	Cars_pane.setVisible(false);

    }
    @FXML
    void Log_out_clicked(ActionEvent event) {

    }

    
    

    @FXML
    void Customers_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(true);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    	
    	
    	
    }

    @FXML
    void Inv_apply_add_clicked(ActionEvent event) {
    	String Item_Name = "";
    	String Quantity = "";
    	
    	Item_Name = inventory_name.getText();
    	Quantity = inventory_quantity.getText();
    	
		inventory inv = new inventory(); 

		inv.setName(Item_Name);
		inv.setQuantity(Integer.parseInt(Quantity));
    	
		supAdmin.addInventory(inv, db);
		
    	
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(true);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

    @FXML
    void Inv_apply_remove_clicked(ActionEvent event) {
    	String Item_Name = "";
    	String Quantity = "";
    	
    	Item_Name = inventory_name_R.getText();
    	Quantity = inventory_quantity_R.getText();
    	
		System.out.println(Quantity);

		 
		
		String temp = "name = '" +Item_Name + "'"; 
		String[] conditions = {temp};  
		Vector<Object> obj =db.conditional_get("businessLogic.inventory", conditions); 
		inventory inv = ((inventory)obj.firstElement());
		supAdmin.rmInventory(inv, Integer.parseInt(Quantity), db); 


    	
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(true);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    	
    }

    @FXML
    void Inventory_click(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(true);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    }

    @FXML
    void Service_btn_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(true);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    }

    @FXML
    void add_cust_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(true);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    }

    @FXML
    void cust_apply_add_clicked(ActionEvent event) {
    	String Name = "";
    	String UserName = "";
    	String password = "";
    	String ID_1 = "";
    	Integer ID ;
    	
    	Name = cust_name.getText();
    	UserName = cust_username.getText();
    	password = cust_password.getText();
    	ID_1 = cust_ID.getText();
    	ID = Integer.valueOf(ID_1);

		user custObj = new customer(UserName, password, Name, ID); 			
		supAdmin.addCustomer((customer)custObj, db); 
		
    	
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(true);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    	

    }

    @FXML
    void cust_apply_remove_clicked(ActionEvent event) {
      	String Name = "";
    	String UserName = "";
    	String ID_1 = "";
    	Integer ID ;
    	
    	Name = cust_name_R.getText();
    	UserName = cust_username_R.getText();
    	ID_1 = cust_ID_R.getText();
    	ID = Integer.valueOf(ID_1);
    	
		customer  rmCust = new customer(); 
		rmCust.setId(ID); 
		supAdmin.rmCustomer(rmCust, db);
		
    	
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(true);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    
    }

    @FXML
    void remove_cust_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(true);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }
    
   
    @FXML
    void remove_inv_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(true);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }
    
    @FXML
    void add_inv_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(true);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }
    @FXML
    void remove_booking_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(true);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }
    @FXML
    boolean oil_change_clicked(ActionEvent event) {
    	return true ;

    }
    @FXML
    void booking_apply_remove_clicked(ActionEvent event) {
    	
       	String Reg_Num = "";
    	String S_ID_1 = "";
    	Integer Serv_ID ;
    	Reg_Num = Reg_num_R.getText();
    	S_ID_1 = Service_ID_R.getText();
    	Serv_ID = Integer.valueOf(S_ID_1);
  
		String condition = "bk_id = " + Serv_ID; 
		String[] conditions = {condition}; 
		try {
			db.delete("bookings", conditions);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(true);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
 
    	
    	

    }
    @FXML
    void add_booking_clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(true);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }

    @FXML
    void booking_apply_add_clicked(ActionEvent event) {
    	
		String C_ID = "";
    	Integer CustID ;
    	String Dates = "";
    	String Times = "";
    	String B_ID = "";
    	Integer BookID ;
    	
    	
    	C_ID = Cust_ID.getText();
    	CustID = Integer.valueOf(C_ID);
    	B_ID = Booking_ID.getText();
    	BookID = Integer.valueOf(B_ID);
    	Dates = Date.getText();
    	Times = Time.getText();
    	
    	
    	Vector<Object> custObjs = db.getAll("businessLogic.customer"); 
		bookings bkObj = null; 
		for (var i : custObjs)
		{
			if (((customer)i).getId() == CustID)
			{
				bkObj = new bookings(((customer)i)); 
			}
			
		}
		if (bkObj.equals(null))
		{
			System.out.println("no such customer exits");
		}

		bkObj.setDate(Dates);
		bkObj.setTime(Times);
		bkObj.setId(BookID);
		
		db.insert(bkObj); 

    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(true);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);
    	
    	
    	
   
    	
    	
    	

    }

   
    
    @FXML
    void System_Admin_Clicked(ActionEvent event) {
    	info_pane.setVisible(false);
    	System_Admin_pane.setVisible(true);
    	Service_Request_Pane.setVisible(false);
    	remove_item_pane.setVisible(false);
    	add_item_pane.setVisible(false);
    	cust_remove_pane.setVisible(false);
    	Cust_add_pane.setVisible(false);
    	Customers_pane.setVisible(false);
    	Inventory_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	remove_booking_pane.setVisible(false);
    	Remove_Car_Pane.setVisible(false);
    	add_car_pane.setVisible(false);
    	Cars_pane.setVisible(false);

    }


}
