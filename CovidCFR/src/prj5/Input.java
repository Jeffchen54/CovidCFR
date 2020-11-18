/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - ARA
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author Andrew Albro aalbro
 * @version 2020.11.18
 *
 */
public class Input
{
    public Input()
    {
        //nothing needed here               
    }
    
    /**
     * This method reads the file and correctly
     * outputs the files information.
     * @param fileName the fileName of the input file.
     * @throws FileNotFoundException if the file isn't found.
     */
    public static void main(String[] fileName) throws FileNotFoundException
    {
        CovidReader read = new CovidReader("filename"); 
        State[] states = read.getAllStates();
        states[0].sortAlpha();
        System.out.println("=====\n");
        states[0].sortCFR();
        System.out.println("=====\n");
        states[1].sortAlpha();
        System.out.println("=====\n");
        states[1].sortCFR();
        System.out.println("=====\n");
        states[2].sortAlpha();
        System.out.println("=====\n");
        states[2].sortCFR();
        System.out.println("=====\n");
        states[3].sortAlpha();
        System.out.println("=====\n");
        states[3].sortCFR();
        System.out.println("=====\n");
        states[4].sortAlpha();
        System.out.println("=====\n");
        states[4].sortCFR();
        System.out.println("=====\n");
        states[5].sortAlpha();
        System.out.println("=====\n");
        states[5].sortCFR();
        System.out.println("=====\n");
        
    }
}
