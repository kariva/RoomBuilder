/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 *
 * @author EyZi Nakagami
 */
public class RoomLayout extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        //Menu Bar
        HBox menubar = new HBox(10);
        menubar.setPadding(new Insets(10,10,10,10));
        Button menu1 = new Button("File");
        Button menu2 = new Button("Room");
        Button menu3 = new Button("Selection");
        Button menu4 = new Button("Object");
        //TODO: FUNCTIONALITY
        menubar.getChildren().addAll(menu1,menu2,menu3,menu4);
        
        //Toolbar
        HBox toolbar = new HBox();
            HBox tooltab = new HBox();
            Button ttab1 = new Button("Tab1");
            Button ttab2 = new Button("Tab2");
            Button ttab3 = new Button("Tab3");
            HBox.setHgrow(ttab1,Priority.ALWAYS);
            HBox.setHgrow(ttab2,Priority.ALWAYS);
            HBox.setHgrow(ttab3,Priority.ALWAYS);
            ttab1.setMaxWidth(Double.MAX_VALUE);
            ttab2.setMaxWidth(Double.MAX_VALUE);
            ttab3.setMaxWidth(Double.MAX_VALUE);
            tooltab.getChildren().addAll(ttab1,ttab2,ttab3);
            
            FlowPane tools = new FlowPane();
            //TODO: ADD TOOLS
            tools.setPrefWrapLength(Control.USE_PREF_SIZE);
            tools.getChildren().addAll();
        toolbar.setPrefWidth(280);
        toolbar.setStyle("-fx-background-color: aliceblue;");
        toolbar.getChildren().addAll(tooltab,tools);
        
        //Canvas
        HBox workspace = new HBox();
            HBox roomtab = new HBox();
            Button rtab1 = new Button("Room1");
            Button rtab2 = new Button("Room2");
            Button rtab3 = new Button("Room3");
            HBox.setHgrow(rtab1,Priority.ALWAYS);
            HBox.setHgrow(rtab2,Priority.ALWAYS);
            HBox.setHgrow(rtab3,Priority.ALWAYS);
            rtab1.setMaxWidth(Double.MAX_VALUE);
            rtab2.setMaxWidth(Double.MAX_VALUE);
            rtab3.setMaxWidth(Double.MAX_VALUE);
            roomtab.getChildren().addAll(rtab1,rtab2,rtab3);
            
            Canvas canvas = new Canvas();
            //TODO: CANVAS
        workspace.setPrefWidth(1000);
        workspace.getChildren().addAll(roomtab,canvas);
        
        //Status Bar
        HBox statusbar = new HBox();
        Label status = new Label("Working...");
        statusbar.setPadding(new Insets(2,2,2,5));
        statusbar.setStyle("-fx-background-color: cornsilk;");
        statusbar.getChildren().addAll(status);
                
        root.setTop(menubar);
        root.setLeft(toolbar);
        root.setCenter(workspace);
        root.setBottom(statusbar);
        Scene scene = new Scene(root, 1280, 720);
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