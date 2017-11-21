# Tsumego Implementaion Heirarchy

1. class Board()
	* private
		- numberOfStones(int)
		- forbiddenPositions(ArrayList<int[2]>)
		- whosTurn(Player)
		- gameStillInPlay(boolean)

	* public
		- resetGame()
		
		- int[2] getPlayerMoveChoice() **must not match list of stones in forbiddenPositions**
		- isGameInPlay(return gameStillInPlay)
		- getWhosTurn {return whosTurn}
		- swithTurn(String currentTurn)
		- Action listeners for new stones placed
		- Action listeners for menu items selected

2. class Player()

	* private
		- color(String)
		- groupsPossessed(ArrayList<Group>)
		- opponentStonesCaptured(ArrayList<int[2])
		- stoneCapturedLastTurn(int[2]) **for** **Ko** **Rule**
		- numberOfSkips int

	* public
		- void addGroupAsPossessed(Group)
		- void ubtractGroupAsPossessed(Group)
		- ArrayList<int[2]> getGroupsPossessed()
		- void executeTurn()
		- surrender()

3. class Group()

	* private
		- positionOfStones(ArrayList<int[2]>)
		- numOfStone (int)
		- positionsOfLiberties(ArrayList<int[2]>)
		- numOfLiberties(int)
		- ownerOfGroup(String)
		- isGroupClosed(bool)

	* public
		- void setStonePositions()
		- void getStonePositions()
		- void getLibertyPositions()
		- void getStonePositions()
		- ArrayList<int[2]> LibertiesThreatened()
		- bool isGroupClosed(Group)
		- 

4. class TsumegoHelper()
	* private
	* public
		- getPlayerMoveChoice()
		- executeTurn()
~~~~
void executeTurn(Group stone){
	Group playersPossessedGroups = this.getGroupsPosessed();
	if position isIn tsumego.forbiddenPositions{
		throw runtimeexception;
	}
	else{
		this.groupsNextToThisGroup(stone){
			if none
			if one
			if multiple
		}
	}
}
~~~~

~~~~
class Main(){
	Board tsumego = new Board(whosTurn = "black");
	Player Black = new Player("black"); //create player instances in board constructor
	Player White = new Player("white");
	TsumegoHelper helper = new TsumegoHelper();

	
	do{
		Group newStone = new Group(helper.getPlayerMoeChoice() );
		tsumego.getWhosTurn().excuteTurn( newStone );
	}while(tsumego.isGameInPlay())
}
~~~~