//package edu.ucsb.cs56.W14.kwwham.cp1;
/**
 An interface for Go games
  
   @author David Winkenwerder and Dustin Henderson
   @author Keith Waldron and Nick Abrahan
   @author Jeffrey Liu and Lauren Dumapias
   @author Chunqing Liu and Xingyuan Zhang
   @version CS56 7/20/16
   @see GoGrid
   @see GoComponent
   @see Go
 */
public interface GoGame 
{
    /** returns 'B' or 'W' depending on whose turn it is.  Returns ' ' if game over.
     */
    public char getTurn();

    /** used to set the turn
     */
    public void setTurn(char turn);

    /** is this square blank.  Should be called before move() to see
	whether the move is legal.  
	@param i number between 1 and 361 indicating square
	@return whether square is blank or not.
    */
    public boolean isBlank(int i);

    /**	play the next move. if isBlank(i) is not true, will throw
	GoIllegalMoveException.

	@param i number between 1 and 361 indicating square, 
	       organized like a telephone grid.  If i is already occupied,
	       a GoMoveException is thrown.
	@return winner 'B', 'W', or 'D' for draw, or ' ' for none yet.
     */
//    public char move(int i) throws GoIllegalMoveException;

    public boolean makeMove(int i) throws GoIllegalMoveException;

    /** Allows the game to end when both parties are surrendering
     */
    public char getWinner();

    /** Allows to set surrendering condition true
     */
    public void setSurrendering();
  /** Allows the game to restart
     */
    public void restart();
  /**this is the toString conversion method
     */
    public String toString();
      /** return the char at the location
     */
    public char charAt(int i);
  /** check whether surrender is surrending 
     */
    public boolean getSurrender1();

 //   public void setGameStatus(boolean boo);
      /** the surrender becomes the first player
     */
    public void setSurrender1(boolean boo);
      /** check whether surrender is surrending
     */
    public boolean getSurrender2();
      /** the surrender becomes the second player
     */
    public void setSurrender2(boolean boo);
  /** return the winner of the game 
     */
    public char setWinner(char a);
      /** check each chess surrended by how many chesses and which color
     */
    public boolean checkSurrounded(int num, char color);
/** check each chess surrended by how many chesses and which color
     */
    public boolean checkSurrounded2(int num);
/** change the turn of the player
     */
    public void changeTurn();
/** set up the chess grid
     */
    public void setGrid(int i, char c);
   /** get the score of the player who uses white chess
     */
    public int getWScore();
 /** get the score of the player who uses black chess
     */
    public int getBScore();
   

}
