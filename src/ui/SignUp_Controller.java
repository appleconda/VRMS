package ui;

import java.io.IOException;

import javax.security.auth.login.LoginContext;
import javax.sound.midi.Soundbank;

import businessLogic.customer;
import javafx.*;
import db.db_handler;
import javafx.scene.*;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp_Controller {
    private db_handler db; 
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    public void setDb(db_handler db)
    {
        this.db = db; 
    }
	@FXML
    private TextField SignUp_Name;

    @FXML
    private TextField SignUp_email;

    @FXML
    private PasswordField SignUp_passwords;

    @FXML
    private Button SignUp_btn;

    @FXML
    private Hyperlink Move_login_btn;

    @FXML
    private TextField SignUp_ID;

    @FXML
    private TextField Entery_Type;

    @FXML
    void Move_login_clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = fxmlLoader.load();
            LogIn_controller controller = (LogIn_controller)fxmlLoader.getController(); 
            controller.setDb(db);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

  
    @FXML
    void SignUp_Clicked(ActionEvent event) {
        String Name ="";
	    Name = SignUp_Name.getText();
	    String UserName = "";
	    UserName = SignUp_email.getText();
	    String password = SignUp_passwords.getText();
	    String ID1 = "";
	    Integer ID;
	    ID1 = SignUp_ID.getText();
	    ID = Integer.valueOf(ID1);
	    String Entery_type = "";
	    Entery_type = Entery_Type.getText();

        if (Entery_type.equals("customer"))
        {
            customer custobj = new customer(); 
            custobj.setId(ID);
            custobj.setName(Name);
            custobj.setUsername(UserName);
            custobj.setPassword(password);
            db.insert(custobj); 
        }

    }

}
