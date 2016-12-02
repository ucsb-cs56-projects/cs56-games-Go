```

Before everything, make sure your partner and you have one mac and one windows/linux machine. 
The reason being that, there is a bug of this software that only shows on mac instead of other platform.

```
cs56-games-Go
=============

A gui version of the Chinese board game called Go.
README file updated by Nicholas Abrahan & Keith Waldron, CS56, W14, Proj1;
Previously only contained "How to Run" and a screenshot.
README file updated by Jeffrey Liu & Lauren Dumapias, CS56, W16;


project history
===============
```
NO | mastergberry | kwwham,nickabrahan | A gui version of the Chinese board game called Go
 W14 | jstaahl 4pm | kwwham,nickabrahan | A gui version of the Chinese board game called Go
  W16  | laurendumapias, liujeffreyk | A gui version of the Chinese board game called Go
  F16 | maggie-schmit, dong1016 | A gui version of the Chinese board game called Go
```

#W16 Final Remarks

# The Current State of the Project

The game, as it currently stands works, but it's missing some gameplay fundamentals. It doesn't implement area and territory scoring, and there are some gameplay bugs (such as the one outlined in the Ko rule of the game). All of these are outlined in the issues.

But again, the game currently works, and the scoring is simply based on the amount of tiles held by one player. Capturing works perfectly and there are no known glitches. You are able to restart the game, but it would nice to clear the previous scoreboard.

# Developer Notes

The code works but it is pretty repetitive. It is basically understandable, but some aspects of the code could be more concise and the method names could be clearer. A little problem you might run into also, is trying to understand the game itself. It's a pretty deep game, with little intricacies here and there that makes the gameplay a little more confusing than usual. But the rules are in the game, as well as a source that goes into a little more detail than the in-game instructions panel does.

So I would suggest:
1. Starting with understanding the game. Read the rules of Go, try to understand the basic mechanics.
2. Start understanding the code. This step might be a little difficult, but the comments could make the process easier. 
3. Working on the issues.

# File Explanation

ButtonAndScrollComponent.java -- Handles the scrollbars/buttons in the GUI

Go.java -- The old contains main. Doesn't use graphics and can be played on the terminal. This no longer works due to we changed the number of paraments and the return type of the "checkSurrounded" method in GoGrid.java.

GoComponent.java -- Handles the actual game mechanics, such as piece color changing, and deciding whose turn it is.

GoGame.java -- Contains the interface used by GoGrid.java and assists in the implementation of the game rules.

GoGrid.java -- Contains the implementation of GoGame.java, with appropriate methods that are used by GoComponent to help with the game mechanics. It's also responsible for the drawing of the grid and the methods used to make sure that the rules stay valid.

GoGui1.java -- Organizes the layout of the game, to have the grid on the left side and the message box on the right side. Contains the main that build.xml runs.

GoGui2.java -- Contains the "Directions" section of the GUI, handles little else but that.

GoIllegalMoveException.java -- Contains the Exception that occurs when you try to make an illegal move in Go.

MessageDestination.java/SystemOutMessageDestination.java -- The interface and the implementation, respectively; Simply contains an easier way to output messages to the system instead of having to put "System.out.println("x")". Might be useful only for Go.java's main and unnecessary for GoGui1.java's main.




# Running the Game

simply use the command:
```
ant run
```

![](http://i63.tinypic.com/fekpas.png?1)

 

