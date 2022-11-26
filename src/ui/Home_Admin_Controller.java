package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Home_Admin_Controller {

    @FXML
    private Button Inventory_btn;

    @FXML
    private Button Customers_btn;

    @FXML
    private Button Service_Request_btn;

    @FXML
    private Button System_Admin_btn;

    @FXML
    private AnchorPane info_pane;

    @FXML
    private AnchorPane Inventory_pane;

    @FXML
    private Button add_inv_btn;

    @FXML
    private TableView<?> Inventory_List;

    @FXML
    private Button remove_inv_btn;

    @FXML
    private AnchorPane Inventory_pane1;

    @FXML
    private Button add_cust_btn;

    @FXML
    private TableView<?> Customer_List;

    @FXML
    private Button remove_cust_btn;

    @FXML
    private AnchorPane Cust_add_pane;

    @FXML
    private TextField cust_name;

    @FXML
    private TextField cust_phone;

    @FXML
    private TextField cust_email;

    @FXML
    private Button cust_apply_add;

    @FXML
    private AnchorPane cust_remove_pane;

    @FXML
    private TextField cust_ID_R;

    @FXML
    private TextField cust_phone_R;

    @FXML
    private TextField cust_email_R;

    @FXML
    private Button cust_apply_remove;

    @FXML
    private AnchorPane remove_item_pane;

    @FXML
    private TextField inventory_name;

    @FXML
    private TextField inventory_quantity;

    @FXML
    private Button Inventory_apply_add;

    @FXML
    private AnchorPane add_item_pane;

    @FXML
    private TextField inventory_name_R;

    @FXML
    private TextField inventory_quantity_R;

    @FXML
    private Button Inventory_apply_remove;

    @FXML
    private AnchorPane Inventory_pane11;

    @FXML
    private TableView<?> Service_list;

    @FXML
    private AnchorPane Inventory_pane111;

    @FXML
    private TableView<?> System_Admin_list;

    @FXML
    void Customers_clicked(ActionEvent event) {

    }

    @FXML
    void Inv_apply_add_clicked(ActionEvent event) {

    }

    @FXML
    void Inv_apply_remove_clicked(ActionEvent event) {

    }

    @FXML
    void Inventory_click(ActionEvent event) {

    }

    @FXML
    void Service_btn_clicked(ActionEvent event) {

    }

    @FXML
    void System_Admin_clicked(ActionEvent event) {

    }

    @FXML
    void add_cust_clicked(ActionEvent event) {

    }

    @FXML
    void cust_apply_add_clicked(ActionEvent event) {

    }

    @FXML
    void cust_apply_remove_clicked(ActionEvent event) {

    }

    @FXML
    void remove_cust_clicked(ActionEvent event) {

    }

}
