package ui;

import javax.security.auth.login.LoginContext;

import db.db_handler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogIn_controller {

    private db_handler db; 
    public LogIn_controller()
    {
        db = new db_handler(); 
    }

    @FXML
    private TextField LogIn_username;

    @FXML
    private PasswordField LogIn_password;

    @FXML
    private Button Login_btn;

    @FXML
    private Hyperlink move_SignUp;

    @FXML
    void Login_btn_Clicked(ActionEvent event) {
    	
	    String UserName = "";
	    UserName = LogIn_username.getText();
	    String password = LogIn_password.getText();
	    
        
    }

    @FXML
    void move_SignUp_Clicked(ActionEvent event) {

    }

}
