JAVDOC FOUND AT: https://shnube.github.io/proj01-javadoc-praxideus-shnube/public_javadoc_workaround/javadoc/

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
README file updated by Gehrig Weber & Misha Zaied, CS56, W18;


project history
===============
```
NO | mastergberry | kwwham,nickabrahan | A gui version of the Chinese board game called Go
 W14 | jstaahl 4pm | kwwham,nickabrahan | A gui version of the Chinese board game called Go
  W16  | laurendumapias, liujeffreyk | A gui version of the Chinese board game called Go
  F16 | maggie-schmit, dong1016 | A gui version of the Chinese board game called Go
  W18 | praxideus, shnube | A gui version of the Chinese board game called Go
```
# F16 Final Remarks (Inaccurate due to F17 rework, please skip to W18 Final Remarks)

# ** The Current State of the Project **
The game works, but has a few bugs. We still haven't implemented the KO rule of the game, and there is a bug (on windows) where the mouse causes any stone that it hovers over to turn white after you've restarted the game (though the restart button works on mac systems). 

Everything that worked in W16 still works. You should be able to play the game (one time without restarting) fairly well.

# ** Developer Notes **

The code works, but is very confusing and does not always follow good OOP practices. We spent a considerable amount of time deleting commented out code and trying to clean up the files. Method names could definitely be clearer, and there is no practice of loose coupling here. If time, it would be worth it to restructure the code to adhere to good OOP practices and implement loose coupling, as now the code is very interrelated and it is difficult to make a change without causing an error somewhere else in the code.

# **File Explanation **

BackgroundMusic.java -- Represents a music object. Has methods to turn the music on and off

ButtonAndScrollComponent.java -- Handles the scrollbars/buttons in the GUI

Go.java -- The old contains main. Doesn't use graphics and can be played on the terminal. This no longer works due to we changed the number of paraments and the return type of the "checkSurrounded" method in GoGrid.java.

GoComponent.java -- Handles the actual game mechanics, such as piece color changing, and deciding whose turn it is.

GoGame.java -- Contains the interface used by GoGrid.java and assists in the implementation of the game rules.

GoGrid.java -- Contains the implementation of GoGame.java, with appropriate methods that are used by GoComponent to help with the game mechanics. It's also responsible for the drawing of the grid and the methods used to make sure that the rules stay valid.

GoGui1.java -- Organizes the layout of the game, to have the grid on the left side and the message box on the right side. Contains the main that build.xml runs.

GoGui2.java -- Contains the "Directions" section of the GUI, handles little else but that.

GoIllegalMoveException.java -- Contains the Exception that occurs when you try to make an illegal move in Go.

SoundEffect.java -- Represents a sound effect object. Has a method that is called when you want to play a sound effect

MessageDestination.java/SystemOutMessageDestination.java -- The interface and the implementation, respectively; Simply contains an easier way to output messages to the system instead of having to put "System.out.println("x")". Might be useful only for Go.java's main and unnecessary for GoGui1.java's main.

# **Running the Game**
ant run

see the picture in W16 final remarks to see what the game looks like


# W16 Final Remarks (Inaccurate due to F17 rework, please skip to W18 Final Remarks)

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

# F17 Final Remarks

Do not look at the file explaination section as a guide.  The code was heavily refactored and most of the functionality was thrown out to make the grid hold values in a Map instead of an 2D array.  
1. All rules for the game have been implemented so do not worry about this.
2. Every time a stone is placed(if the move is legal), a recursive step is taken to see if the stone will cause a capture of opponent stones.  This recursive method is in the Grid.java class and is referred to as a 'floodfill' method.  Look this method up online if the code confuses you.
3. Some code like the background music, is still in place but has not been plugged back into the program since refactoring took place, so this shoudl be an easy fix.

# W18 Final Remarks

# The Current State of the Project

There are two modes: Two-Player (which is presented as the default) and Single-Player (You play against an AI that places stones randomly). All the rules of the game are implemented correctly except for one bug (see issue #82 - "Cannot drop stone in eye on the edge of board when such a move would result in a capture."). If the words "perfectly" or some synonym of that is ever used from now on, please keep in mind that this bug is present.

In the Single-Player mode, everything works perfectly. There are no buttons that do nothing. One game at a time can be saved. There is a specific version of Go that this program adheres to, which is stated in this program's provided instructions.

In the Two-player mode, the player must click for the AI to place their stone, but the AI is the one who decides where the stone goes (randomly). The player may have to click multiple times in order for the AI to choose a valid spot. The player will also have to skip the AI's turn if they click repeatedly and the AI won't do anything because there are no more valid moves for it to make. Saving and loading minght not work in this mode.

# Developer Notes

This README was useless when W18 started because of F17's rework. W18 seeks to fix that. Please enjoy the information below.

The code works but it is pretty repetitive. It is basically understandable, but some aspects of the code could be more concise and the method names could be clearer. A little problem you might run into also, is trying to understand the game itself. It's a pretty deep game, with little intricacies here and there that makes the gameplay a little more confusing than usual. But the rules are in the game, as well as a source that goes into a little more detail than the in-game instructions panel does.

So I would suggest:
1. Starting with understanding the game. Read the rules of Go, try to understand the basic mechanics.
2. Start understanding the code. This step might be a little difficult, but the comments could make the process easier. 
3. Working on the issues.

# File Explanation

AboutTheAuthors.java -- Displays information about the authors when the "About the Authors" button on the Opening Screen is clicked

BackgroundMusic.java -- The class that actually retrieves the music file and plays it, on loop

ButtonAndScrollComponent.java -- Handles the scrollbars/buttons in the in-game GUI

ChooseBoardSizeScreen.java -- Displays options to choose a Go board of 5x5, 9x9, 13x13, or 19x19. Opens a new window.

GameBoard.java -- Displays the actual Go board and handles turning mouse clicks into locations usable by the rest of the program.

GameCreator.java -- Creates everything in the in-game GUI using GameBoard.java, ButtonAndScrollComponent.java, Grid.java, and others

GoInstructions.java -- Displays the instructions of Go when the appropriate button is clicked on the Opening Screen or the in-game GUI

Grid.java -- Handles adding stones to the board; includes methods to add stone, check if such a placement is valid according to the many complicated rules of Go, collecting dead stones, and others

Main.java -- All it does is create an instance of OpeningScreen

OpeningScreen.java -- Displays the screen one sees when starting the game. Right now, it has 5 buttons: "Start New Game", "Instructions", "Load Saved Game", "About the Authors", and "Single Player"

SoundEffect.java -- The class that actually retrieves the sound effect file and has a method to play it

State.java -- Enables the current player to either have a BLACK or WHITE state, indicating whose turn it is

Status.java -- Contains many "global" variables about the state of the game, indicating if the Skipped Turn button was pressed, if the game is over, etc.

Stone.java -- The class that represents a stone in the game of Go

# Running the Game

simply use the command:
```
ant run
```

