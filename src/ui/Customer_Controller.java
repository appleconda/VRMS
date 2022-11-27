package ui;

import businessLogic.*;
import db.db_handler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Customer_Controller {

	public customer custObj; 
	private db_handler db; 
		

	public db_handler getDb() {
		return db;
	}


	public void setDb(db_handler db) {
		this.db = db;
	}


	public customer getCustObj() {
		return custObj;
	}


	public void setCustObj(customer custObj) {
		this.custObj = custObj;
	}



	public Integer TotalCost;
	
    @FXML
    private Button Billing_btn;

    @FXML
    private Button Service_Request_btn;

    @FXML
    private Button Update_profile_btn;

    @FXML
    private Button Booking;

    @FXML
    private AnchorPane Main_pane;

    @FXML
    private AnchorPane Billing_pane;

    @FXML
    private Button checkout_btn;

    @FXML
    private TableView<?> Invoice_List;

    @FXML
    private AnchorPane info_pane;

    @FXML
    private AnchorPane Checkout_pane;

    @FXML
    private TextField Payers_name;

    @FXML
    private TextField Card_num;

    @FXML
    private Button Pay_apply_btn;

    @FXML
    private TextField Invoice_num;

    @FXML
    private TextField Invoice_Date;

    @FXML
    private TextField Amount;

    @FXML
    private AnchorPane Service_Request_Pane;

    @FXML
    private TableView<?> Service_list;

    @FXML
    private Button add_booking_btn;

    @FXML
    private Button remove_booking_btn;

    @FXML
    private AnchorPane Update_profile_pane;

    @FXML
    private TextField New_name;

    @FXML
    private TextField New_username;

    @FXML
    private TextField New_pass;

    @FXML
    private Button Update_prof_btn;

    @FXML
    private AnchorPane Booking_Pane;

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
    private AnchorPane add_booking_pane;

    @FXML
    private TextField Reg_num1;

    @FXML
    private Button booking_apply_add;

    @FXML
    private RadioButton Modify_btn;

    @FXML
    private RadioButton Denting_btn;

    @FXML
    private RadioButton Painting_btn;

    @FXML
    private RadioButton oil_change_btn;

    @FXML
    private RadioButton wrap_btn;

    @FXML
    private TextField cust_id_service;

    @FXML
    private TextField Service_ID;

    @FXML
    void Booking_btn_clicked(ActionEvent event) {
    	Billing_pane.setVisible(false);
    	Booking_Pane.setVisible(true);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);

    }

    

    @FXML
    void new_booking_apply(ActionEvent event) {
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
    	

		bookings bk = new bookings(custObj); 
		db.insert(bk);

    	
    	
    	
    	
    	Billing_pane.setVisible(false);
    	Booking_Pane.setVisible(true);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	
    

    	

    }

    
    @FXML
    void Billing_click(ActionEvent event) {
    	Billing_pane.setVisible(true);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    }

    @FXML
    boolean Denting_clicked(ActionEvent event) {
    	return true;
    	
    }

    @FXML
    boolean Modify_clicked(ActionEvent event) {
    	return true;
    }

    @FXML
    boolean Painting_clicked(ActionEvent event) {
    	return true;
    }

    @FXML
    void Pay_apply_clicked(ActionEvent event) {
    	String Name = "";
    	String CardNum = "";
    	String InvoiceNum = "";
    	String InvoiceDate = "";
    	String Amount1 = "";
    	Integer Amount_int ;
    	
    	Name = Payers_name.getText();
    	CardNum = Card_num.getText();
    	InvoiceNum = Invoice_num.getText();
    	InvoiceDate = Invoice_Date.getText();
    	Amount1 = Amount.getText();
    	Amount_int = Integer.valueOf(Amount1);
    	
    	
    	Billing_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(true);
    	info_pane.setVisible(false);

    }

    @FXML
    void Service_btn_clicked(ActionEvent event) {
    	Billing_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(true);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	Booking_Pane.setVisible(false);

    }

    @FXML
    void Update_apply_clicked(ActionEvent event) {
    	String Name = "";
    	String UserName = "";
    	String Password = "";
    	
    	Name = New_name.getText();
    	UserName = New_username.getText();
    	Password = New_pass.getText();
    	
    	
    	
    	Billing_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(true);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	
    	

    }

    @FXML
    void Update_profile_clicked(ActionEvent event) {
    	Billing_pane.setVisible(false);
    	//remove_booking_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(true);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    }

    @FXML
    boolean  Wrap_btn_clicked(ActionEvent event) {
    	return true;
    }
    @FXML
    boolean oil_change_clicked(ActionEvent event) {
    		return true;
    }

    @FXML
    void add_booking_clicked(ActionEvent event) {
    	Billing_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    	add_booking_pane.setVisible(true);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    }

    @FXML
    void booking_apply_add_clicked(ActionEvent event) {
    	String Reg_Num = "";
    	String C_ID_1 = "";
    	Integer Cust_ID ;
    	String S_ID_1 = "";
    	Integer Serv_ID ;
    	Reg_Num = Reg_num1.getText();
    	C_ID_1 = cust_id_service.getText();
    	Cust_ID = Integer.valueOf(C_ID_1);
     	S_ID_1 = Service_ID.getText();
    	Serv_ID = Integer.valueOf(S_ID_1);
    	
    	if(oil_change_clicked(event)== true )
    	{
    		TotalCost = TotalCost +100;
    	}
    	if(Wrap_btn_clicked(event)== true )
    	{
    		TotalCost = TotalCost +200;
    	}
    	if(Painting_clicked(event)== true )
    	{
    		TotalCost = TotalCost +150;
    	}
    	if(Modify_clicked(event)== true )
    	{
    		TotalCost = TotalCost +300;
    	}
    	if(Denting_clicked(event)== true )
    	{
    		TotalCost = TotalCost +400;
    	}
    	
    	
    	
    	
    	Billing_pane.setVisible(false);
    	add_booking_pane.setVisible(true);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    }

    @FXML
    void booking_apply_remove_clicked(ActionEvent event) {
    	
    	
    	Billing_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    }

    @FXML
    void checkout_clicked(ActionEvent event) {
    	Billing_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(true);
    	info_pane.setVisible(false);
    	Booking_Pane.setVisible(false);

    }

    

    @FXML
    void remove_booking_clicked(ActionEvent event) {
    	Billing_pane.setVisible(false);
    	add_booking_pane.setVisible(false);
    	Update_profile_pane.setVisible(false);
    	Service_Request_Pane.setVisible(false);
    	Checkout_pane.setVisible(false);
    	info_pane.setVisible(false);
    	Booking_Pane.setVisible(false);
    }

}
