// Assignment #: 8
// Name: Your name
// StudentID: your id
// Lecture: your lecture
// Section: your section
// Description: The pair class pairs a row number and a column number.

public class Pair
 {
  private int row;
  private int col;

  //Initializes the pair object using two parameters
  public Pair(int row, int col)
   {
     this.row = row;
     this.col = col;
   }

  //Accessor method for the row number
  public int getRow()
   {
     return row;
   }

  //Accessor method for the column number
  public int getColumn()
   {
     return col;
   }
 }
