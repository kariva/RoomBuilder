/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import static java.lang.System.gc;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Kari Vass
 */
public class Controller {
    //Model
    private MainModel model;
    
    private boolean wallInProcess;
    
    public Controller(MainModel myModel){
        this.model = myModel;
        wallInProcess = false;
    }
    
    public boolean handleMousePressed(MouseEvent e) {
        for(Button b : model.getToolList()) {
            if(b.isFocused()) {
                if(b.getId().equals("Wall")){
                    //Draw the wall
                    drawWall(e);
                }
            }
        }
        return true;
    }
    
    public boolean handleMouseMoved(MouseEvent e){
        if(wallInProcess){
            model.updateDrawnLine(e.getX(), e.getY());
        }
        return true;
    }
    
    public boolean drawWall(MouseEvent e){
        if(!wallInProcess) { //If we are starting a new edge
            model.startDrawnLine(e.getX(), e.getY());
            wallInProcess = true;
            return true;
        }
        else{ //If we are finishing an edge
            model.endDrawnLine(e.getX(), e.getY());
            wallInProcess = false; //Edge is finished
            return true;
        }
    }
}
