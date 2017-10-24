# Tsumego Implementaion Heirarchy

1. class Board()
	* private
		- numberOfStones(int)
		- forbiddenPositions(ArrayList<int[2]>)
		- turn(String)

	* public
		- Main()
		- resetGame()
		- surrender()
		- getTurn
		- Action listeners for new stones placed
		- Action listeners for menu items selected

2. class Player()

	* private
		- color(String)
		- groupsPossessed(ArrayList<Group>)
		- opponentStonesCaptured(ArrayList<int[2])
		- stoneCapturedLastTurn(int[2]) **for** **Ko** **Rule**

	* public
		- addGroupAsPossessed(Group)
		- ubtractGroupAsPossessed(Group)

3. class Group()

	* private
		- positionOfStones(ArrayList<int[2]>)
		- numOfStone (int)
		- positionsOfLiberties(ArrayList<int[2]>)
		- numOfLiberties(int)
		- ownerOfGroup(String)
		- isGroupClosed(bool)

	* public
		- setStonePositions()
		- getStonePositions()
		- getLibertyPositions()
		- getStonePositions()
		- LibertiesThreatened()
		- isGroup

4. class GameHelper()


