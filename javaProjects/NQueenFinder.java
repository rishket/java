import java.util.Stack;

public class NQueenFinder
{
	private Answer answer1;
	private int boardSize; //This is N in the assignment description.

	//Constructor to initialize the boardSize, which is also the number of
	//queens to be placed. Also create an answer object.
	public NQueenSolver(int queenNum)
	{
		answer1 = new Answer(queenNum);
		boardSize = queenNum; //This is N in the assignment description.
	}

	//Return an answer -- accessor of the answer1
	public Answer returnAnswer()
	{
		return answer1;
	}

	//The findSolution will return true if a solution is found,
	//false otherwise. Please see the pseudo-code of the assignment 11 statement
	public boolean findSolution()
	{
		Stack<Pair> stackSoln = new Stack<Pair>();
		//back-up stack
		Stack<Pair> stackSoln2 = new Stack<Pair>();
		boolean success = false;
		boolean conflict = false;
		//Push information onto the stack indicating the first choice
		//is a queen in row 0 and column 0.
		stackSoln.push(new Pair(0,0));
		while (!success && !stackSoln.isEmpty())
		{
			System.out.println("Trying to place a queen in row "
					+ stackSoln.peek().getRow()
					+ " in column "
					+ stackSoln.peek().getColumn() );
			conflict = false;
			//Check whether the most recent choice (on top of the stack) is in the same row, same column,
			//or same diagonal as any other choices in the stack.
			//If so, there is a conflict; otherwise, there is no conflict.
			//Note that to check if two pairs (row1,col1) and (row2,col2) are in the same diagonal,
			//you just need to check if row1-col1 == row2-col2 or row1+col1 == row2+col2

			//Also note that, to check this, you need to pop all items in the stack.
			//When you finish it, you need to push them back onto the stack,
			//so you will need a back-up stack.
			Pair P = stackSoln.peek();
			stackSoln.pop();
			while (!stackSoln.isEmpty()) {
				stackSoln2.push(stackSoln.pop());
					// checks if queens are diagonal or across
					if  ( P.getRow() - P.getColumn() == stackSoln2.peek().getRow() - stackSoln2.peek().getColumn() 
							|| P.getRow() + P.getColumn() == stackSoln2.peek().getRow() + stackSoln2.peek().getColumn() 
							|| P.getRow() == stackSoln2.peek().getRow()  
							||P.getColumn() == stackSoln2.peek().getColumn() ) {
						conflict = true;
					}
			}
		// loop to empty stack2 into stack1
			while(!stackSoln2.isEmpty()) {
				stackSoln.push(stackSoln2.pop());
			}
			stackSoln.push(new Pair (P.getRow(), P.getColumn()));
			if (conflict == true)
			{

				while( !stackSoln.isEmpty()  && stackSoln.peek().getColumn() == boardSize - 1) {
					stackSoln.pop();
				}
				if (!stackSoln.isEmpty()) {
					Pair p = stackSoln.pop();
					stackSoln.push(new Pair(p.getRow(), p.getColumn() + 1));
				}
			}
			else if (conflict == false && stackSoln.size() == boardSize)
			{
				success = true;
				//Since a solution is found, copy the stack info into the answer
				//so that it can print them.
				answer1.copySolution(stackSoln);
			}
			else //no conflict, and it has not finished finding a solution yet
			{
				//The next choice is to place a queen at row number stackSoln.size()
				//(one more than the current choice's row) and column number 0.
				//So push (stackSoln.size(), 0) onto the stack
				stackSoln.push(new Pair (stackSoln.size() , 0));
			}
		}  //end of while loop
		return success;
	}//end of findSolution method
}//end of the NQueenSolver class
