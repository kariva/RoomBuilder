/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
/**
 *
 * @author Kari Vass
 */

//Layout variables

public class MainView implements ModelListener {
    //Model
    private MainModel model;
    //Controller
    private Controller controller;
    //Layout variables
    private BorderPane mainView;
    private HBox topMenu;
    private GridPane toolBar;
    private Pane workSpace;
    private Stage primaryStage;
    

    
    public MainView(MainModel myModel, Controller myController, Stage myPrimaryStage){
        this.model = myModel;
        this.controller = myController;
        this.primaryStage = myPrimaryStage;

        //Initialize layout variables
        //Top menu
        topMenu = new HBox();
        topMenu.setStyle("-fx-background-color: #383838;");
        topMenu.setPadding(new Insets(20, 20, 20, 20));
        topMenu.setSpacing(25);
        Button top1 = new Button("Save");
        Button top2 = new Button("New Room");
        Button top3 = new Button("Clear All");
        Popup popup = new Popup();
        popup.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - popup.getWidth() / 2);
        popup.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - popup.getHeight() / 2);
        VBox paneBox1 = new VBox();
        paneBox1.setAlignment(Pos.TOP_CENTER);
        paneBox1.setMinSize(400, 200);
        paneBox1.setPadding(new Insets(20, 20, 20, 20));
        Label warning = new Label("Are you sure?");
        Text warning2 = new Text("This will clear all elements in the current room.");
        warning2.setFill(Color.web("#fff"));
        HBox buttonOptions = new HBox();
        buttonOptions.setPadding(new Insets(30, 0, 0, 0));
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setStyle("-fx-background-color: #ed4425");
        Button confirmBtn = new Button("Confirm");
        confirmBtn.setStyle("-fx-background-color: #15a90d");
        buttonOptions.setAlignment(Pos.CENTER);
        buttonOptions.setSpacing(20);
        buttonOptions.getChildren().addAll(cancelBtn, confirmBtn);
        paneBox1.getChildren().addAll(warning, warning2, buttonOptions);
        popup.getContent().addAll(paneBox1);
        top3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.show(primaryStage);
            }
        });
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.hide();
            }
        });
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.show(primaryStage);
                workSpace.getChildren().clear(); //Clears the canvas on each draw //Clears the canvas
                model.clearAll();
                popup.hide();
            }
        });
        Button top4 = new Button("...");
        topMenu.getChildren().addAll(top1, top2, top3, top4);
        
        //Toolbar
        toolBar = new GridPane();
        toolBar.setStyle("-fx-background-color: #383838;");
        toolBar.setPadding(new Insets(0, 20, 20, 20));
        toolBar.setHgap(20);
        toolBar.setVgap(20);
        Button tool2 = new Button(); // More descriptive names later
        tool2.setId("Wall");
        tool2.setMinSize(50, 50);
        String filename = "wallIcon.png";
	String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = "";
        absoluteFilePath = workingDirectory + File.separator + filename;
        File f = new File(absoluteFilePath);
        Image wallIcon = new Image("file:///" + f.getAbsolutePath().replace("\\", "/"));
        ImageView wallIconView = new ImageView(wallIcon);
        tool2.setGraphic(wallIconView);
        model.addTool(tool2);
        
        Button tool1 = new Button();
        tool1.setId("Cursor");
        tool1.setMinSize(50, 50);
        filename = "cursorIcon.png";
        absoluteFilePath = "";
        absoluteFilePath = workingDirectory + File.separator + filename;
        File e = new File(absoluteFilePath);
        Image cursorIcon = new Image("file:///" + e.getAbsolutePath().replace("\\", "/"));
        ImageView cursorIconView = new ImageView(cursorIcon);
        tool1.setGraphic(cursorIconView);
        model.addTool(tool1);
        
        Button tool3 = new Button();
        tool3.setId("Door");
        tool3.setMinSize(50, 50);
        filename = "doorIcon.png";
        absoluteFilePath = "";
        absoluteFilePath = workingDirectory + File.separator + filename;
        File g = new File(absoluteFilePath);
        Image doorIcon = new Image("file:///" + g.getAbsolutePath().replace("\\", "/"));
        ImageView doorIconView = new ImageView(doorIcon);
        tool3.setGraphic(doorIconView);
        model.addTool(tool3);
        
        Button tool4 = new Button("");
        tool4.setMinSize(50, 50);
        tool4.setId("Window");
        filename = "windowIcon.png";
        absoluteFilePath = "";
        absoluteFilePath = workingDirectory + File.separator + filename;
        File h = new File(absoluteFilePath);
        Image windowIcon = new Image("file:///" + h.getAbsolutePath().replace("\\", "/"));
        ImageView windowIconView = new ImageView(windowIcon);
        tool4.setGraphic(windowIconView);
        model.addTool(tool4);
        
        Button tool5 = new Button("...");
        tool5.setMinSize(50, 50);
        Button tool6 = new Button("...");
        tool6.setMinSize(50, 50);
        Button tool7 = new Button("...");
        tool7.setMinSize(50, 50);
        Button tool8 = new Button("...");
        tool8.setMinSize(50, 50);
        
        toolBar.add(tool1, 0, 0);
        toolBar.add(tool2, 1, 0);
        toolBar.add(tool3, 0, 1);
        toolBar.add(tool4, 1, 1);
        toolBar.add(tool5, 0, 2);
        toolBar.add(tool6, 1, 2);
        toolBar.add(tool7, 0, 3);
        toolBar.add(tool8, 1, 3);
 
        
        workSpace = new Pane();
        

        workSpace.setStyle("-fx-background-color: #fff;");
        //Initialize canvas, graphics context and add it to the workspace
        
        //Link the controller
        workSpace.addEventHandler(MouseEvent.MOUSE_PRESSED, controller::handleMousePressed);
        workSpace.addEventHandler(MouseEvent.MOUSE_MOVED, controller::handleMouseMoved);

        mainView = new BorderPane();
        mainView.setTop(topMenu);
        mainView.setLeft(toolBar);
        mainView.setCenter(workSpace);
    }
    
    public BorderPane getScene(){
        return this.mainView;
    }
    
    @Override
    public void modelChanged(){
        //Redraw
        workSpace.getChildren().clear(); //Clears the canvas on each draw //Clears the canvas
        //Iterate through vertex list and draw them
        for(Wall e : model.getWallList()) {
            Line l = new Line(e.getX1(), e.getY1(), e.getX2(), e.getY2());
            l.setStroke(Color.web("#383838"));
            l.setStrokeWidth(10.0);
            workSpace.getChildren().addAll(l);
        }
        if(model.getLineBeingDrawn().getX1() != 0.0 && model.getLineBeingDrawn().getY1() != 0.0) {
            Wall temp = model.getLineBeingDrawn();
            Line l = new Line(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2());
            l.setStroke(Color.web("C0C0C0"));
            l.setStrokeWidth(10.0);
            workSpace.getChildren().addAll(l);
        }
    }
}
