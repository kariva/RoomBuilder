/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author EyZi Nakagami
 */
public class RoomLayout extends Application {
    //MVC Variables
    private MainView view;
    private MainModel model;
    private Controller controller;
    
    @Override
    public void start(Stage primaryStage) {
        //MVC
        model = new MainModel();
        controller = new Controller(model);
        view = new MainView(model, controller, primaryStage);
        
         //Add subscribers
        model.addModelListener(view);
        
        Scene scene = new Scene(view.getScene(), 1280, 720);
        String filename = "flatterfx.css";
	String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = "";
        absoluteFilePath = workingDirectory + File.separator + filename;
        File f = new File(absoluteFilePath);
        scene.getStylesheets().clear();
        System.out.println(f.toString());
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Roboto+Condensed:700");
        primaryStage.setTitle("Room Layout Designer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}