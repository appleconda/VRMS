package ui;

import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import businessLogic.*;
import javax.security.auth.login.LoginContext;

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

public class LogIn_controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private db_handler db;

    public db_handler getDb() {
        return db;
    }

    public void setDb(db_handler db) {
        this.db = db;
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
        System.out.println(UserName);
        System.out.println(password);

        Vector<Object> custObj = db.getAll("businessLogic.customer");
        Vector<Object> supAdminObj = db.getAll("businessLogic.superAdmin");

        for (var i : custObj)
        {
            if (((customer)i).getUsername().equals(UserName) && ((customer)i).getPassword().equals(password))
            {

            }
        }

        for (var j : supAdminObj)
        {
            if (((superAdmin)j).getUsername().equals(UserName) && ((superAdmin)j).getPassword().equals(password))
            {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home_Admin.fxml"));
                    root = fxmlLoader.load();
                    Home_Admin_Controller controller = (Home_Admin_Controller) fxmlLoader.getController();
                    controller.setDb(db);
                    controller.setSupAdmin(((superAdmin)j));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML
    void move_SignUp_Clicked(ActionEvent event) {

    }

}
