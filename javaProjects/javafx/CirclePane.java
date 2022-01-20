import javafx.geometry.Insets;
import javafx.scene.layout.*;

public class CirclePane extends BorderPane
{
    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> bgColorCombo;
    private ComboBox<String> widthCombo;
    private Circle[][] circleArray;

    private final int NUM_COL =6, NUM_ROW = 6, RADIUS = 40;
    private GridPane canvas;	//this is where circles are drawn

    //constructor
    public CirclePane()
    {
        canvas = new GridPane();
        canvas.setPrefWidth(2*RADIUS * NUM_COL);
        canvas.setPrefHeight(2*RADIUS * NUM_ROW);

        VBox leftPane = new VBox();
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setStyle("-fx-border-color: black");
    }

    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
			//Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
			//to check whether the mouse key is dragged or released, etc
			//write your own codes here
            //----
        }
    }//end MouseHandler

	//Step #2(B) - Primary and secondary color handler
    private class PrimaryColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
			//Write your own code here
			//----

		}
    }//end PrimaryColorHandler

    //Step #2(C): background color handler
    //Write a private class called BackgroundColorHandler that handles the background
    //color changes
    //----
    //----



    //Step #2(D): handle the stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        //write your own code
        //----
        //----


    }//end of WidthHandler

} //end of CirclePane
