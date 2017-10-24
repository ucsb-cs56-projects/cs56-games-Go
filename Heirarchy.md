# Tsumego Implementaion Heirarchy

1. class Board()
	* private
		- numberOfStones(int)
		- forbiddenPositions(ArrayList<int[2]>)
		- whosTurn(String)
		- gameStillInPlay(boolean)

	* public
		- resetGame()
		- surrender()
		- int[2] getPlayerMoveChoice() **must not match list of stones in forbiddenPositions**
		- swithTurn(String currentTurn)
		- Action listeners for new stones placed
		- Action listeners for menu items selected

2. class Player()

	* private
		- color(String)
		- groupsPossessed(ArrayList<Group>)
		- opponentStonesCaptured(ArrayList<int[2])
		- stoneCapturedLastTurn(int[2]) **for** **Ko** **Rule**

	* public
		- void addGroupAsPossessed(Group)
		- void ubtractGroupAsPossessed(Group)

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
---
void executeTurn(int[2] position, String Turn){
	if
}
---

---
class Main(){
	Board tsumego = new Board(whosTurn = "black");
	Player Black = new Player("black");
	Player White = new Player("white");

	
	do{
		excuteTurn(tsumego.getPlayerMoveChoice(), whosTurn);
	}while(gameStillInPlay)
}