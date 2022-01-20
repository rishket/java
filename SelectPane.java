// Assignment #: 6
// Arizona State University - CSE205
//  Description: SelectPane displays a list of available department
//  from which a user can select and compute total number of faculties in multiple departments.

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.layout.BorderPane;

/**
* SelectPane displays a list of available departments from which a user
* can select and compute total number of faculties for selected departments.
*/
public class SelectPane extends BorderPane {

    //declare instance varibales
    private ArrayList<Department> departList;



    public SelectPane(ArrayList<Department> list) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */

        this.departList = list;


        // Wrap checkboxContainer in ScrollPane so formatting is
        // correct when many departments are added



        // Setup layout

        //create an empty pane where you can add check boxes later


        //SelectPane is a BorderPane - add the components here



    } // end of SelectPane constructor

    // This method uses the newly added parameter Department object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateDepartList(Department newdep) {
        // Create checkbox for new department with appropriate text

        // Bind checkbox toggle action to event handler
        // Passes the number of faculties in each department to the handler. When the checkbox is
        // toggled,this number will be added/subtracted from the total number of selected faculties


        // Add new checkbox to checkbox container

    } // end of updateDepartList method

    /**
     * SelectionHandler This class handles a checkbox toggle event. When the
     * checkbox is toggled, this number will be added/subtracted from the total
     * number of selected faculties.
     */
    private class SelectionHandler implements EventHandler<ActionEvent> {
        // Instance variable for number of faculties associated with a given department/checkbox
        private int faculties;


        public SelectionHandler(int members) {
            this.faculties = members; // Set instance variable
        } // end of SelectionHandler constructor

        //over-ride the abstarct method handle
        public void handle(ActionEvent event) {
            // Get the object that triggered the event, and cast it to a checkbox, since
            // only a department checkbox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method


            // Update the selected Faculties label with the new number of selected faculties

        } // end handle method
    } // end of SelectHandler class
} // end of SelectPane class
