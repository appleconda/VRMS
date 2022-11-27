import javafx.*;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.*;

import javax.security.auth.login.LoginContext;
import javax.sound.midi.ControllerEventListener;

import businessLogic.superAdmin;
import db.db_handler;
import javafx.stage.Stage;
import ui.Home_Admin_Controller;
import ui.LogIn_controller; 

public class App extends Application {
    private static Stage stg; 
    
    @Override
    public void start(Stage primaryStage)
    {
        try 
        {
            stg = primaryStage; 

            superAdmin supAdmin = new superAdmin(); 

            db_handler db = new db_handler(); 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Customers.fxml")); 
            Parent root = loader.load(); 
           
            // LogIn_controller controller = (LogIn_controller)loader.getController(); 
            // controller.setDb(db);
            

            Scene scene = new Scene(root,600, 600); 
            scene.getStylesheets().add(getClass().getResource("/ui/application.css").toExternalForm()); 
            primaryStage.setScene(scene);
            primaryStage.show(); 

            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
