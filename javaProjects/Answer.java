import java.util.Stack;

public class Answer
 {
   private char[][] solution;

   public Answer(int size)
    {
     solution = new char[size][size];

     for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        solution[i][j] = '_';
     }

  public void setQueen(int row, int col)
   {
     solution[row][col] = 'Q';
   }

  public void copySolution(Stack solution)
   {
     while (!solution.isEmpty())
       {
        Pair current = (Pair) solution.pop();
        setQueen(current.getRow(), current.getColumn());
       }
   }
  public String toString()
   {
    String result = "";
    result += " |";
     for (int j = 0; j < solution.length; j++)
      {
       result += j + "|";
      }
     result += "\n";
     for (int i = 0; i < solution.length; i++)
      {
        result += i + "|";
       for (int j = 0; j < solution[i].length; j++)
        {
            result += solution[i][j] + "|";
        }
       result += "\n";
      }
     return result;
   }
}//end of the Answer class
