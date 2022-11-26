package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp_Controller {

    @FXML
    private TextField SignUp_Name;

    @FXML
    private TextField SignUp_email;

    @FXML
    private PasswordField SignUp_passwords;

    @FXML
    private Button SignUp_btn;

    
    private String Name = SignUp_Name.getText();
    private String email = SignUp_email.getText();
    private String password = SignUp_passwords.getText();
    
    
}
