/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - 
 */

package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

//Java Doc ................................................................
/**
* Creates and manages the data visualization tool for the COVID
* data on race mortality rates
* 
* @author 
* @version 11.30.2020
*/
public class CovidGUI {
    
    // Fields ..................................................................
    private Window window;
    private Button state1;
    private Button state2;
    private Button state3;
    private Button state4;
    private Button state5;
    private Button state6;
    private Button sortCFR;
    private Button sortAlpha;
    private Button quit;
    private Shape[] barShapes;
    private Shape[] barShapeLabels;
    private State[] states;
    private boolean modeCFR;
    private boolean modeAlpha;
    
    // Constructor .............................................................
    /**
     * This constructor will create the window and give functionality to the buttons
     * @param states1 States data to be visualized within the window
     */
    public CovidGUI(State[] states1) {
        states = states1;
        window = new Window();
        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        window.addButton(sortAlpha, WindowSide.NORTH);
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);
        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSortCFR");
        window.addButton(sortCFR, WindowSide.NORTH);
        
    }
    
    // Methods .................................................................
    
    /**
     * This method will be used when the quit button is pressed and
     * will close the window
     * @param button The quit button that was clicked.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    
    /**
     * This method will sort the bar graphs by the names
     * of the races' in alphabetical order from left to right
     */
    public void clickedSortAlpha(Button button) {
        
    }
    
    
    /**
     * This method will sort the bar graphs by CFR
     * in descending order from left to right
     */
    public void clickedSortCFR(Button button) {
        
    }
    
    
    /**
     * This method will run when a state's button is pressed
     * and will represent the COVID data in the state
     */
    public void clickedState(Button button) {
        
    }
}
