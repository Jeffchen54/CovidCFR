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
     * @param states1
     *            States data to be visualized within the window
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
     * of the races' in alphabetical order from left to right. Does nothing
     * if no state has been selected yet.
     * 
     * @param button
     *            button used to signal the sorting of races into alpha order.
     */
    public void clickedSortAlpha(Button button) {

        if (title == null) {
            return;
        }

        cfrMode = false;
        alphaMode = true;

        String stateName = title.getText().substring(0, 2);

        for (Button stateButton : stateButtons) {
            if (stateButton.getTitle().substring(10).equals(stateName)) {
                clickedState(stateButton);
                break;
            }
        }
    }


    /**
     * This method will sort the bar graphs by CFR
     * in descending order from left to right. Does nothing if no state is
     * currently selected.
     * 
     * @param button
     *            button used to signal sorting into CFR order.
     */
    public void clickedSortCFR(Button button) {
        if (title == null) {
            return;
        }

        cfrMode = true;
        alphaMode = false;

        String stateName = title.getText().substring(0, 2);

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
     *            Button which is associated with a specific state
     */
    public void clickedState(Button button) {
        window.removeAllShapes();
        String stateName = button.getTitle().substring(10);
        title = new TextShape(0, 0, stateName + " Case Fatality Ratio by Race");
        title.moveTo(window.getGraphPanelWidth() / 2 - title.getWidth() / 2,
            15);
        window.addShape(title);

        State state = stateSearch(stateName);

        Iterator<Race> iter;
        if (cfrMode) {
            iter = state.sortCFR();
        }
        else if (alphaMode) {
            iter = state.sortAlpha();
        }
        else {
            iter = state.getIterator();
        }

        for (int i = 0; i < 5; i++) {

            Race race = iter.next();
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
        }
    }


    /**
     * Searches and returns the state whose name matches the String input.
     * Throws an IllegalArgumentException if the input does not match a
     * any state.
     * 
     * @param stateName
     *            Name of the State to return.
     * @return State which corresponds to the inputed stateName
     * @throws IllgalArgumentException
     */
    private State stateSearch(String stateName) {
        for (State search : states) {
            if (search.getStateName().equals(stateName)) {
                return search;
            }
        }
        throw new IllegalArgumentException();
    }
}
