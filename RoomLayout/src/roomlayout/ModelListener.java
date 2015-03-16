/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

/**
 *
 * @author Kari Vass
 */
public interface ModelListener {
    //To implement this interface, must implement the modelChanged() method
    //This is for the implementation of the publish-subscribe method of communication within this project
    public void modelChanged();
}
