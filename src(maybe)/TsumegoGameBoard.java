import java.util.ArrayList;

class TsumegoGameBoard {

	private int numberOfStones;
	private ArrayList<int[2]> occupiedPositions;
	private ArrayList<int[2]> whiteStonePositions;
	private ArrayList<int[2]> blackStonePositions;
	private Player whosTurn;
	private boolean gameStillInPlay;
	private int numberOfMoves;
	private String winner;
	private boolean surrender;

	public Player Black = new Player();
	public Player White = new Player();

	public TsumegoGameBoard(){
		whosTurn = Black;
		numberOfStones = 0;
		gameStillInPlay = ture;
		numberOfMoves = 0;
		surrender = false;

	}

	public void resetGame(){

	}

	public void updateTerritoryPossession(){

		whiteStonePositions = White.getStonePositions();
		blackStonePositions = Black.getStonePositions();
	}

	public Player getTurn() {return whosTurn;}

	public void switchTurn() {
		if(getTurn() == Black) {whosTurn = White;)
		else {whosTurn = Black;}
	}

}