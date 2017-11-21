package Go;


import Go.State;
import java.util.*;
import java.awt.Point;

/**
 * Provides game logic.
 *  
 *
 */
public class Grid{

    private final int SIZE;
	private int moveNumber;
    private int whiteStones;
    private int blackStones;
    private int whiteScore;
    private int blackScore;
    private Stone lastWhiteMove;
    private Stone lastBlackMove;
    private Map<Point, Stone> capturedByBlack;
    private Map<Point, Stone> capturedByWhite;
	private Map<Point, Stone> stonesOnBoard;

    /**
     * Creates empty grid with 
     *@param int  number of columns in the grid 
     *@param row  number of rows in the grid
     */
    

    public Grid(int col, int row) {
		
        SIZE = col;
    	stonesOnBoard = new LinkedHashMap<Point, Stone>(SIZE*SIZE);
    	moveNumber = 0;
        whiteStones = 0;
        blackStones = 0;
        whiteScore = 0;
        blackScore = 0;
        capturedByBlack = new LinkedHashMap<Point, Stone>();
        capturedByWhite = new LinkedHashMap<Point, Stone>();
    }


    /**
     * Adds Stone to Grid.
     * 
     * @param point
     * @param black
     */
    public void addStone(Point point, State state) {
		
		Stone newStone = new Stone(point, state, moveNumber);

        System.out.println("stone position: " + newStone.getLocation() + "\n");
		
		stonesOnBoard.put(point,newStone);

		// find newly killed opponent groups using floodfill method
		Map<String,LinkedHashMap<Point,Stone>> deadGroups = checkForDeadOpponentGroups(newStone);

        collectDeadStones(deadGroups,state);

        System.out.println("Move Number: " + moveNumber);
        System.out.println("Number of white stones on board: " + whiteStones);
        System.out.println("Number of black stones on board: " + blackStones);
        System.out.println("White score: " + whiteScore);
        System.out.println("Black score: " + blackScore + "\n");

        if(lastWhiteMove != null) 
            System.out.println("last white move: " + lastWhiteMove.getLocation());
        if(lastBlackMove != null)
            System.out.println("last black move: " + lastBlackMove.getLocation());
     
        addMove(newStone);

    }

    /**
     * Adds to indication values of game status
     * 
     * @param stone
     */
    public void addMove(Stone newStone){
    	this.moveNumber++;
        if(moveNumber%2 == 0){
            whiteStones++;
            lastWhiteMove = newStone;
        }

        else{
            blackStones++;
            lastBlackMove = newStone;
        }


    }


    /**
     * Returns a LinkedHashMaps of the groups that are dead as a result of a placed stone
     * 
     * @param stone
     */
    public LinkedHashMap<String,LinkedHashMap<Point,Stone>> checkForDeadOpponentGroups(Stone stone) {

        LinkedHashMap<String,LinkedHashMap<Point,Stone>> deadGroups = new LinkedHashMap<String,LinkedHashMap<Point,Stone>>();
        State currentPlayerState = stone.getState();
        State opponentState;

        //set the recently placed stone's color-state
        if(currentPlayerState == State.WHITE)
            opponentState = State.BLACK;
        else opponentState = State.WHITE;
    	
        //find groups around the recently placed stone 
        //then see if they are dead with doLibertiesExist()
        //Only looks at OPPONENT stones ADJACENT
        Stone up = stonesOnBoard.get(new Point(stone.getX(), stone.getY() - 1));
        if(up != null){
        	if ((stone.getY() > 0) && (up.getState() == opponentState))
            {
                LinkedHashMap<Point,Stone> upGroup = new LinkedHashMap<Point,Stone>();
                
                boolean libertiesExist = doLibertiesExist(up,opponentState,upGroup);

                if(!libertiesExist) deadGroups.put("up",upGroup);
    		}
        }

        Stone down = stonesOnBoard.get(new Point(stone.getX(), stone.getY() + 1));
        if(down != null){
    		if ((stone.getY() < SIZE - 1) && (down.getState() == opponentState))
            {
                LinkedHashMap<Point,Stone> downGroup = new LinkedHashMap<Point,Stone>();
    			
                boolean libertiesExist = doLibertiesExist(down,opponentState,downGroup);

                if(!libertiesExist) deadGroups.put("down",downGroup);
    		}
        }

        Stone left = stonesOnBoard.get(new Point(stone.getX() - 1, stone.getY()));
        if(left != null){
    		if ((stone.getX() > 0) && (left.getState() == opponentState))
            {
                LinkedHashMap<Point,Stone> leftGroup = new LinkedHashMap<Point,Stone>();
    			
                boolean libertiesExist = doLibertiesExist(left,opponentState,leftGroup);

                if(!libertiesExist) deadGroups.put("left",leftGroup); 
    		}
        }

        Stone right = stonesOnBoard.get(new Point(stone.getX() + 1, stone.getY()));
        if(right != null){
    		if ((stone.getX() < SIZE - 1) && (right.getState() == opponentState))
            {
                LinkedHashMap<Point,Stone> rightGroup = new LinkedHashMap<Point,Stone>();
    			
                boolean libertiesExist = doLibertiesExist(right,opponentState,rightGroup);

                if(!libertiesExist) deadGroups.put("right",rightGroup);  
    		}
        }

		return deadGroups;
    }

    public boolean doLibertiesExist(
        Stone stone, 
        State state, 
        LinkedHashMap<Point,Stone> stonesInGroup
        )
    {
            
    	if(!stonesOnBoard.containsValue(stone)) return true;
        
        else if(stone.getState() != state) return false;

    	else{

		      //check if we have visted this stone before
            if(!stonesInGroup.containsValue(stone)){

                // if this square is the colour expected and has not been visited before
                if(stone.getY() > 0){
                    Stone newStone = stonesOnBoard.get(new Point(stone.getX(), stone.getY() - 1));

                    if(!stonesOnBoard.containsValue(newStone)) return true;

                        stonesInGroup.put(stone.getLocation(),stone);
                        boolean up = doLibertiesExist(newStone,state,stonesInGroup);

                        //test with system.ou.println
                        if(up) return up;    
                }
        	   
                if (stone.getY() < SIZE - 1){
                    Stone newStone = stonesOnBoard.get(new Point(stone.getX(), stone.getY() + 1));

                    if(!stonesOnBoard.containsValue(newStone)) return true;

                        stonesInGroup.put(stone.getLocation(),stone);
                        boolean down = doLibertiesExist(newStone,state,stonesInGroup);

                        //test with system.ou.println
                        if(down) return down;
                }

                if (stone.getX() > 0){
                    Stone newStone = stonesOnBoard.get(new Point(stone.getX() - 1, stone.getY()));

                    if(!stonesOnBoard.containsValue(newStone)) return true;

                        stonesInGroup.put(stone.getLocation(),stone);
                        boolean left = doLibertiesExist(newStone,state,stonesInGroup);

                        //test with system.ou.println
                        if(left) return left;
                }

                if (stone.getX() < SIZE - 1){
                    Stone newStone = stonesOnBoard.get(new Point(stone.getX() + 1, stone.getY()));

                    if(!stonesOnBoard.containsValue(newStone)) return true;

                        stonesInGroup.put(stone.getLocation(),stone);
                        boolean right = doLibertiesExist(newStone,state,stonesInGroup);

                        //test with system.ou.println
                        if(right) return right;  
                }  
            }
            return false;
        }
    }

    /**
     * Adds dead stones to captured dictionaries, adds points for a player, and takes dead stones off the board
     * 
     * @param deadGroups
     * @param state
     */
    public void collectDeadStones(Map<String,LinkedHashMap<Point,Stone>> deadGroups, State state){

        System.out.println("dead stones: ");
        
        for(String group : deadGroups.keySet()){
            Map<Point,Stone> chain = deadGroups.get(group);
            for(Point point : chain.keySet()){

                //Take stones off of the board
                stonesOnBoard.remove(point);

                //add captured stones to respective groups and add points
                if(state == State.BLACK){
                    capturedByBlack.put(point,chain.get(point));
                    blackScore++;

                    System.out.println(point);
                }
                if(state == State.WHITE){
                    capturedByWhite.put(point,chain.get(point));
                    whiteScore++;

                    System.out.println(point);
                }
            }
        }
    }

    /**
     * This is the requirement that must be met for a stone to be allowed to be placed
     * 
     * @param stone
     * @param state
     */
    public boolean isMoveAllowed(Stone stone, State state){
        boolean firstAssessment = !isOccupied(stone.getLocation());
        boolean secondAssessment = followsKORule(stone,state);
        return firstAssessment && secondAssessment;

    }


    public boolean followsKORule(Stone stone, State state){

        if(state == State.WHITE){
            if(lastWhiteMove != null){
                if(lastWhiteMove.getX() == stone.getX()
                    && lastWhiteMove.getY() == stone.getY())
                {
                    System.out.println("current and last move are equal");
                    return false;
                }
                else System.out.println("current and last moves are not equal");
            }
        }
        else{
            if(lastBlackMove != null){
                if(lastBlackMove.getX() == stone.getX()
                    && lastBlackMove.getY() == stone.getY()) {
                    System.out.println("current and last move are equal");
                    return false;
                }
                else System.out.println("current and last moves are not equal");
            }
        }

        


        //check to see if surrounding points all have a stone. if they do not, return true.
        //If stones are completely surrounding the move, check to see if they are opponent stones
        if(stonesOnBoard.get(new Point(stone.getX(), stone.getY() - 1)) != null
            && stonesOnBoard.get(new Point(stone.getX(), stone.getY() + 1)) != null
            && stonesOnBoard.get(new Point(stone.getX() - 1, stone.getY())) != null
            && stonesOnBoard.get(new Point(stone.getX() + 1, stone.getY())) != null)
        {
            
            


            //if surreounding stones are opponent stones, check KO
            //if they are not, return true because you can play within your own eye
            if(stonesOnBoard.get(new Point(stone.getX(), stone.getY() - 1)).getState() != state
                && stonesOnBoard.get(new Point(stone.getX(), stone.getY() + 1)).getState() != state
                && stonesOnBoard.get(new Point(stone.getX() - 1, stone.getY())).getState() != state
                && stonesOnBoard.get(new Point(stone.getX() + 1, stone.getY())).getState() != state)
            {
                //temporarily add the stone to the board so getLiberties() will work properly!!
                Point temp = new Point(stone.getX(), stone.getY());
                stonesOnBoard.put(temp, stone);
                
                Map<String,LinkedHashMap<Point,Stone>> areDeadGroups = checkForDeadOpponentGroups(stone);

                stonesOnBoard.remove(temp);
                //if no dead groups are produced, you cannot place there
                if(areDeadGroups.isEmpty()) return false;

                //if the stone placed would produce dead groups, KO takes over
                else return true; 
            }
            else return true;
        }
        else return true;

        //check to see if surrounding are opponent state. If they are, see if you will break their eye


    }

    public boolean isOccupied(Point point){
        if(stonesOnBoard.get(point) != null)
            return true;
        else return false;
    }

    public State getState(int col, int row) {
        Stone stone = stonesOnBoard.get(new Point(col,row));
        if (stone == null) {
            return null;
        } else {
            return stone.getState();
        }
    }

   
    public int getMoveNumber(){
        return this.moveNumber;
    }

    public int getBlackScore(){
        return blackScore;
    }

    public int getWhiteScore(){
        return whiteScore;
    }












































}