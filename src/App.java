import javafx.*;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.*;

import javax.sound.midi.ControllerEventListener;

import businessLogic.superAdmin;
import db.db_handler;
import javafx.stage.Stage;
import ui.Home_Admin_Controller; 

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Home_Admin.fxml")); 
            Parent root = loader.load(); 
            Home_Admin_Controller controller = (Home_Admin_Controller)loader.getController(); 
            controller.setDb(db);
            controller.setSupAdmin(supAdmin);
            
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
