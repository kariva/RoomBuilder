/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Kari Vass
 */

//Layout variables

public class MainView {
    //Layout variables
    private BorderPane mainView;
    private HBox topMenu;
    private GridPane toolBar;
    private Pane workSpace;
    
    //Canvas
    private Canvas drawCanvas;
    private GraphicsContext gc;
    
    public MainView(){
        //Initialize layout variables
        //Top menu
        topMenu = new HBox();
        topMenu.setStyle("-fx-background-color: #f1f1f1;");
        topMenu.setPadding(new Insets(20, 20, 20, 20));
        topMenu.setSpacing(25);
        Button top1 = new Button("Save");
        top1.setMinSize(75, 50);
        Button top2 = new Button("New Room");
        top2.setMinSize(75, 50);
        Button top3 = new Button("...");
        top3.setMinSize(75, 50);
        Button top4 = new Button("...");
        top4.setMinSize(75, 50);
        topMenu.getChildren().addAll(top1, top2, top3, top4);
        
        //Toolbar
        toolBar = new GridPane();
        toolBar.setStyle("-fx-background-color: #f1f1f1;");
        toolBar.setPadding(new Insets(0, 20, 20, 20));
        toolBar.setHgap(20);
        toolBar.setVgap(20);
        Button tool1 = new Button("..."); // More descriptive names later
        tool1.setMinSize(50, 50);
        Button tool2 = new Button("...");
        tool2.setMinSize(50, 50);
        Button tool3 = new Button("...");
        tool3.setMinSize(50, 50);
        Button tool4 = new Button("...");
        tool4.setMinSize(50, 50);
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
        workSpace.setStyle("-fx-background-color: #FFFFFF;");
        //Initialize canvas, graphics context and add it to the workspace
        drawCanvas = new Canvas(workSpace.getWidth(), workSpace.getHeight());
        gc = drawCanvas.getGraphicsContext2D();
        workSpace.getChildren().add(drawCanvas);

        mainView = new BorderPane();
        mainView.setTop(topMenu);
        mainView.setLeft(toolBar);
        mainView.setCenter(workSpace);
    }
    
    public BorderPane getScene(){
        return this.mainView;
    }
}
