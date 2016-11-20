import java.util.ArrayList;
/**
 * A grid for playing Go, with numbers according to row, 1-19 being the first row
 and 20-38 being the next, etc.
 
 
 @author David Winkenwerder and Dustin Henderson
 @author Keith Waldron and Nick Abrahan
 @author Jeffrey Liu and Lauren Dumapias
 @version CS56 2/21/16
 @see GoGridTest
 */

public class GoGrid implements GoGame
{
    
    private ArrayList<Character> grid = new ArrayList<Character>();
    private int numMoves=0;
    private char turn = 'B';
    private int scoreW = 0;//amount of white tiles
    private int scoreB = 0;//amount of black tiles
    private char winner = ' ';
    private boolean gameOver = false;
    private boolean surrender1 = false; boolean surrender2=false; boolean surrendering = false;
    //add spaces to the game state equal to the number of spaces on the board: 362.

    private int W_skips = 0;//keeps track how many times white has skipped a turn
    private int B_skips = 0;//keeps track of how many times black has skipped a turn
     
/**
     * Default constructor for objects of the class GoGrid
     */
    public GoGrid() {	
	grid.add('_');
	for(int i=1;i<362; i++)
	{
	    grid.add(' ');
	}

    }
    
    //Restarts the game, restarts all information
    public void restart(){
        for(int i=1;i<362; i++)
        {
            setGrid(i, ' ');
        }
        numMoves = 0;
        turn = 'B';
        scoreW = 0;
        scoreB = 0;
        winner = ' ';
        gameOver = false;
        surrender1 = false;
        surrender2 = false;
        surrendering = false;
	W_skips = 0;
	B_skips = 0;

    }

    //How to tell if the game is over
    public boolean isGameOver(){
	return gameOver;
    }

    //Used to change turns
    public void setTurn(char turn){
        this.turn = turn;
    }
    
    //Used to signal surrender
    public void setSurrendering() {
        this.surrendering = true;
    }
    
    //Used to set grids
    public void setGrid(int i, char c){
        grid.set(i,c);
    }

    /**
     Constructor for objects of class GoGrid that allows
     creation of games in middle of play. This is mostly for testing.
     
     There should be an equal number of B's and Ws
     (in which case it is the Ws turn) or else
     1 more W that there are Bs (in which case it is Bs turn),
     otherwise IllegalArgumentException("illegal game state") is thrown.
     
     @param gameState 362 character string with Ws and Bs for positions 1-362
     @return turn 'B' or 'W' for turn
     */
    
    public char GoGrid(ArrayList gameState) {
        this.grid = gameState;
        return turn;
    }
    
    /**
     @param i is number of square (like telephone pad)
     @return 'B','W', or ' '--i.e. contents of square i
     */
    
    public char charAt(int i)
    {
        return grid.get(i);
    }
    
    /**
     checkSurrounded checks to see if the piece selected is surrounded
     the other players pieces. it returns true if surrounded,
     and false, if it is not.
     */
    
    public boolean checkSurrounded(int i, char color)
    {
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> canVisit = new ArrayList<Integer>();
        canVisit.add(i);     // we start with a single element in canVisit. the helper function may add more elements to or remove elements from canVisit
        while(canVisit.size()>0)       // loop exits when we checked all the important stones in the area or when liberty is found
        {
            if(!checkSurroundedHelper(canVisit.get(0),color,visited,canVisit))   // check first element of canVisit
                return false;          // there is liberty, function returns
        }
        for(int in: visited)
        {
            grid.set(in,' ');          // no liberty, surrounded stones get removed.
        }
        return true;
    }
    
    /**
     checkSurrounded2 is like checkSurrounded but it doesn't modify the grid. It is useful for checking whether a move is legal.
     */
    
    public boolean checkSurrounded2(int i)
    {
        char color = grid.get(i);              // the actionPerformed method in GoComponent.java already put the stone in without knowing the legality of the move. Depending on what checksurrounded2 returns, it would either keep the stone or throw it away.
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> canVisit = new ArrayList<Integer>();
        canVisit.add(i);
        while(canVisit.size()>0)
        {
            if(!checkSurroundedHelper(canVisit.get(0),color,visited,canVisit))
                return false;
        }
        setGrid(i,' ');                  // undo illegal move
        return true;
    }
    
    //NOT DONE reason The two work fine as seperate, and we may come back and make them recursive for CP3.
    
    public boolean checkSurroundedHelper(int i,char color,ArrayList visited,ArrayList canVisit) //DONE
    {
        if(!visited.contains(i))
        {
            if(grid.get(i)==' ')
                return false;                // this means there is liberty
            if(grid.get(i)!=color)           // it's the color of the opponent's stone
            {
                canVisit.remove(canVisit.indexOf(i));
                return true;
            }
            visited.add(i);                // stones at risk of removal
            int v = canVisit.indexOf(i);
            if(v!=-1)         // -1 means not in arraylist
                canVisit.remove(v);
            //find the four neighbors
            //if not in can visit and not over an edge, add it to canvisit
            if((i)%19!=0)
            {
                if(!canVisit.contains(i+1))
                    if(!visited.contains(i+1))
                        canVisit.add(i+1);
            }
            if((i)%19!=1)
            {
                if(!canVisit.contains(i-1))
                    if(!visited.contains(i-1))
                        canVisit.add(i-1);
            }
            if((i+19)<362)
            {
                if(!canVisit.contains(i+19))
                    if(!visited.contains(i+19))
                        canVisit.add(i+19);
            }
            if((i-19)>0)
            {
                if(!canVisit.contains(i-19))
                    if(!visited.contains(i-19))
                        canVisit.add(i-19);
            }
        }
        
        return true;
        
    }
    
    //Gets score of white player
    public int getWScore(){
        int wcount=0;
        for(char c : grid){
            if(c=='W')
                wcount++;
        }
        return wcount;
    }
    
    //Gets score of black player
    public int getBScore(){
        int bcount=0;
        for(char c : grid){
            if(c=='B')
                bcount++;
        }
        return bcount;
    }
    
    
    /** This private convenience method sets the gameOver and winner variables,
     and then returns the winner. It is simply a way to factor out
     common code from all the cases in getWinner */
    
    public char setWinner(char c)
    {
        this.gameOver = true;
        this.winner = c;
        this.turn = ' ';
        return c;
    }
    
    /**
     @return 'W' or 'B' if there is a winner, ' ' if there is not
     */
    
    public char getWinner()
    {
        char result;
        
        if(gameOver)
            return winner;
        int blackCount=0;
        int whiteCount=0;
        if(surrendering){
            for(char c : grid)
            {
                if(c=='B')
                    blackCount++;
                if(c=='W')
                    whiteCount++;
            }
            if(blackCount>whiteCount)
                setWinner('B');
            else if(whiteCount>blackCount)
                setWinner('W');
            else
                setWinner(' ');
        }
        return winner;
    }
    
    /** is this square blank. Should be called before move() to see
     whether the move is legal.
     
     
     
     @param i number between 1 and 361 indicating square
     @return whether square is blank or not.
     @throws IllegalArguementException if i is not between 1 and 361 (inclusive)
     */
    public boolean isBlank(int i)
    {
        return(grid.get(i)==' ');
    }
    
    public boolean makeMove(int i) throws GoIllegalMoveException{

           /* indexes go from 0 to 361.
              Second substring has 362 as last param because second param
              to substring is first index NOT included in subsequence.
           */

	
	if(turn == 'B')
	    resetBSkips();
	if(turn == 'W')
	    resetWSkips();

           if(!this.isBlank(i))
               throw new GoIllegalMoveException("Square "+i+" occupied\n");
           //if(this.checkSurrounded(i))
           //  throw new GoIllegalMoveException("Cannot place piece here, it would be surrounded.\n");
           char e = ' ', w = ' ', s = ' ', n = ' ';
           if (i%19!=0)
               e = grid.get(i+1);
           if (i%19!=1)
               w = grid.get(i-1);
           if (i+19<362)
               s = grid.get(i+19);
           if (i-19>0)
               n = grid.get(i-19);
           grid.set(i,turn);
           char turn2 = (turn=='W')?'B':'W';
           if(i+1<362)
               checkSurrounded(i+1,turn2);
           if(i-19>0)
               checkSurrounded(i-19, turn2);
           if(i-1>0)
               checkSurrounded(i-1, turn2);
           if(i+19<362)
               checkSurrounded(i+19, turn2);
        
  
           if (i%19!=0) {
               if (e!=grid.get(i+1))
                   return true;
           }
           if (i%19!=1) {
               if (w!=grid.get(i-1))
                   return true;
           }
           if (i+19<362) {
               if (s!=grid.get(i+19))
                   return true;
           }
           if (i-19>0) {
               if (n!=grid.get(i-19))
                   return true;
           }
           return !checkSurrounded2(i);
   }
    
       public void changeTurn() {
           turn = (turn=='W')?'B':'W'; //change turn
           numMoves++;
         }

    /** Return game state as a 361 character string.
     This is mostly for testing purposes.
     
     @param game state string
     */
    
    public String getGameState()
    {
        ArrayList retval = new ArrayList();
        retval = grid;
        retval.remove(0);
        return retval.toString();
    }
    
    public char getTurn()
    {
        return turn;    

    }

    //Skip method, checks for too many skips in a row, in which game should end
    public boolean skip(){
	if(turn == 'B'){
	    B_skips++;
	    if(B_skips == 2){
		//end game
		setWinner('W');
		return true;
	    }
	}
	if(turn == 'W'){
	    W_skips++;
	    if(W_skips == 2){
		//end game
		setWinner('B');
		return true;
	    }
	}
	return false;
    }
    
    //Used to reset skip count when the game is reset
    public void resetWSkips(){
	W_skips = 0;
    }
    public void resetBSkips(){
	B_skips = 0;
    }

}
