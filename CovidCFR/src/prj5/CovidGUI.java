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

// Java Doc ................................................................
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
    private TextShape title;
    private boolean cfrMode;
    private boolean alphaMode;

    // Constructor .............................................................
    /**
     * This constructor will create the window and give functionality to the
     * buttons.
     * 
     * @apiNote Removed hardcoded segments, added commits to remove
     * @param states1
     *            States data to be visualized within the window
     */
    public CovidGUI(State[] states1) {

        // TODO Remove these // comments and apiNote
        // Initial setup
        states = states1;
        window = new Window();

        // Window, alpha, cfr button created
        window.setTitle("Covid Fatality by Race");
        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        window.addButton(sortAlpha, WindowSide.NORTH);
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        // State buttons
        window.addButton(quit, WindowSide.NORTH);
        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSortCFR");
        window.addButton(sortCFR, WindowSide.NORTH);
        state1 = new Button("Represent " + states[0].getStateName());
        state1.onClick(this, "clickedState");
        window.addButton(state1, WindowSide.SOUTH);
        state2 = new Button("Represent " + states[1].getStateName());
        state2.onClick(this, "clickedState");
        window.addButton(state2, WindowSide.SOUTH);
        state3 = new Button("Represent " + states[2].getStateName());
        state3.onClick(this, "clickedState");
        window.addButton(state3, WindowSide.SOUTH);
        state4 = new Button("Represent " + states[3].getStateName());
        state4.onClick(this, "clickedState");
        window.addButton(state4, WindowSide.SOUTH);
        state5 = new Button("Represent " + states[4].getStateName());
        state5.onClick(this, "clickedState");
        window.addButton(state5, WindowSide.SOUTH);
        state6 = new Button("Represent " + states[5].getStateName());
        state6.onClick(this, "clickedState");
        window.addButton(state6, WindowSide.SOUTH);

        // State buttons registered
        stateButtons = new Button[] { state1, state2, state3, state4, state5,
            state6 };
        
        cfrMode = false;
        alphaMode = false;
        
    }

    // Methods .................................................................


    /**
     * This method will be used when the quit button is pressed and
     * will close the window
     * 
     * @param button
     *            The quit button that was clicked.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This method will sort the bar graphs by the names
     * of the races' in alphabetical order from left to right
     */
    public void clickedSortAlpha(Button button) {
        
        cfrMode = false;
        alphaMode = true;
        
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

        state.sortAlpha();
        
        for (Button stateButton : stateButtons) {
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
        
        cfrMode = true;
        alphaMode = false;
        
        // Checks if no state is selected
        if (title == null) {
            return;
        }
        
        // Grabs the state
        String stateName = title.getText().substring(0, 2);
        State state = null;
        for (State state1 : states) {
            if (state1.getStateName().equals(stateName)) {
                state = state1;
                break;
            }
        }
        
        // This sorts the state, it returns an iterator but not needed 
        state.sortCFR();

        // Calls clickedState on the correct button.
        for (Button stateButton : stateButtons) {
            if (stateButton.getTitle().substring(10).equals(stateName)) {
                clickedState(stateButton);
                break;
            }
        }
    }


    /**
     * Mapped to buttons correlating to states. Display COVID data onto the GUI.
     * 
     * @param button
     *              Button which is associated with a specific state
     * @apiNote Edited to use an iterator to improve efficiency
     * @apiNote Edited to save alpha or cfr preference.
     */
    public void clickedState(Button button) {
        //TODO remove // comments and apiNote
        
        // Removes and refreshes constant shapes
        window.removeAllShapes();
        String stateName = button.getTitle().substring(10);
        title = new TextShape(0, 0, stateName + " Case Fatality Ratio by Race");
        title.moveTo(window.getGraphPanelWidth() / 2 - title.getWidth() / 2,
            15);
        window.addShape(title);

        // Finds the correct state
        State state = null;
        for (State state1 : states) {
            if (state1.getStateName().equals(stateName)) {
                state = state1;
                break;
            }
        }

        // Puts the COVID Race bars onto the GUI 1 by 1 with an iterator
        
        Iterator<Race> iter;
        if(cfrMode) {
            iter = state.sortCFR();
        }
        else if(alphaMode) {
            iter = state.sortAlpha();
        }
        else {
            iter = state.getIterator();
        }
        
        for (int i = 0; i < 5; i++) {
            
            // Pulls CFR data without removing
            Race race = iter.next();
            TextShape raceName = new TextShape(0, 0, race.getName());
            raceName.moveTo(i * 125 + 90, 220);
            window.addShape(raceName);
            double cfr = race.getCFR();
            
            TextShape cfrText;
            
            // Sets CFR to N/A if needed
            if (cfr == -1) {
                cfrText = new TextShape(0, 0, "N/A");
                cfrText.moveTo(i * 125 + 88, 240);
                window.addShape(cfrText);
                continue;
            }
            
            // Creates and displays the cfr bar and data on the GUI
            DecimalFormat df = new DecimalFormat("#.#");
            cfrText = new TextShape(0, 0, df.format(cfr).toString() + "%");
            cfrText.moveTo(i * 125 + 88, 240);
            window.addShape(cfrText);
            int barHeight = (int)(cfr * 2);
            Shape bar = new Shape(0, 0, 12, barHeight, Color.BLUE);
            bar.moveTo(i * 125 + 100, 215 - barHeight);
            window.addShape(bar);
        }
    }
}
