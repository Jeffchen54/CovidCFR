/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - AA
 */

package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

//Java Doc ................................................................
/**
* Creates and manages the data visualization tool for the COVID
* data on race mortality rates
* 
* @author Aziz Abousam (az1zabousam)
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
    private Button[] stateButtons;
    private Button sortCFR;
    private Button sortAlpha;
    private Button quit;
    private State[] states;
    TextShape title;
    
    // Constructor .............................................................
    /**
     * This constructor will create the window and give functionality to the buttons
     * @param states1 States data to be visualized within the window
     */
    public CovidGUI(State[] states1) {
        states = states1;
        window = new Window();
        window.setTitle("Covid Fatality by Race");
        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        window.addButton(sortAlpha, WindowSide.NORTH);
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);
        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSortCFR");
        window.addButton(sortCFR, WindowSide.NORTH);
        state1 = new Button("Represent DC");
        state1.onClick(this, "clickedState");
        window.addButton(state1, WindowSide.SOUTH);
        state2 = new Button("Represent GA");
        state2.onClick(this, "clickedState");
        window.addButton(state2, WindowSide.SOUTH);
        state3 = new Button("Represent MD");
        state3.onClick(this, "clickedState");
        window.addButton(state3, WindowSide.SOUTH);
        state4 = new Button("Represent NC");
        state4.onClick(this, "clickedState");
        window.addButton(state4, WindowSide.SOUTH);
        state5 = new Button("Represent TN");
        state5.onClick(this, "clickedState");
        window.addButton(state5, WindowSide.SOUTH);
        state6 = new Button("Represent VA");
        state6.onClick(this, "clickedState");
        window.addButton(state6, WindowSide.SOUTH);
        stateButtons = new Button[] 
            {state1, state2, state3, state4, state5, state6};
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
        if (title == null) {
            return;
        }
        String stateName = title.getText().substring(0, 2);
        State state = null;
        for (State state1 : states) {
            if (state1.getStateName().equals(stateName)) {
                state = state1;
                break;
            }
        }
        Iterator<Race> it = state.sortAlpha();
        for (int i = 0; i < 5; i++) {
            state.remove(0);
            state.add(it.next());
        }
        
        for (Button stateButton: stateButtons) {
            if (stateButton.getTitle().substring(10).equals(stateName)) {
                clickedState(stateButton);
                break;
            }
        }
    }
    
    
    /**
     * This method will sort the bar graphs by CFR
     * in descending order from left to right
     */
    public void clickedSortCFR(Button button) {
        if (title == null) {
            return;
        }
        String stateName = title.getText().substring(0, 2);
        State state = null;
        for (State state1 : states) {
            if (state1.getStateName().equals(stateName)) {
                state = state1;
                break;
            }
        }
        Iterator<Race> it = state.sortCFR();
        for (int i = 0; i < 5; i++) {
            state.remove(0);
            state.add(it.next());
        }
        
        for (Button stateButton: stateButtons) {
            if (stateButton.getTitle().substring(10).equals(stateName)) {
                clickedState(stateButton);
                break;
            }
        }
    }
    
    
    /**
     * This method will run when a state's button is pressed
     * and will represent the COVID data in the state
     */
    public void clickedState(Button button) {
        window.removeAllShapes();
        String stateName = button.getTitle().substring(10);
        title = new TextShape(
            0, 0, stateName + " Case Fatality Ratio by Race");
        title.moveTo(
            window.getGraphPanelWidth() / 2 - title.getWidth() / 2, 15);
        window.addShape(title);
        
        State state = null;
        for (State state1 : states) {
            if (state1.getStateName().equals(stateName)) {
                state = state1;
                break;
            }
        }
        for (int i = 0; i < 5; i++) {
            DLNode<Race> node = state.getFront();
            state.remove(0);
            Race race = node.getData();
            TextShape raceName = new TextShape(0, 0, race.getName());
            raceName.moveTo(i * 125 + 90, 220);
            window.addShape(raceName);
            double cfr = race.getCFR();
            TextShape cfrText;
            if (cfr == -1) {
                cfrText = new TextShape(0, 0, "N/A");
                cfrText.moveTo(i * 125 + 88, 240);
                window.addShape(cfrText);
                continue;
            }
            DecimalFormat df = new DecimalFormat("#.#");
            cfrText = new TextShape(0, 0, df.format(cfr).toString() + "%");
            cfrText.moveTo(i * 125 + 88, 240);
            window.addShape(cfrText);
            int barHeight = (int)(cfr * 2);
            Shape bar = new Shape(0, 0, 12, barHeight, Color.BLUE);
            bar.moveTo(i * 125 + 100, 215 - barHeight);
            window.addShape(bar);
            state.add(race);
        }
    }
}
