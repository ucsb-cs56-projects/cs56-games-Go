cs56-games-Go
=============

A gui version of the Chinese board game called Go.
README file updated by Nicholas Abrahan & Keith Waldron, CS56, W14, Proj1;
Previously only contained "How to Run" and a screenshot.


# The Current State of the Project

The game, as it currently stands works, but it's missing some gameplay fundamentals. It doesn't implement area and territory scoring, and there are soem gameplay bugs (such as the one outlined in the Ko rule of the game). All of these are outlined in the issues.

But again, the game currently works, and the scoring is simply based on the amount of tiles held by one player. Capturing in the basic sense works, just not in a larger scale such as with territory/area scoring. 

# Developer Notes

The code might need a little overhaul. As it currently stands, it's a little difficult to understand, let alone make changes to, the code. A little problem you might run into also, is trying to understand the game itself. It's a pretty deep game, with little intricacies here and there that makes the gameplay a little more confusing than usual. But the rules are in the game, as well as a source that goes into a little more detail than the in-game instructions panel does.

So I would suggest:
1. Starting with understanding the game. Read the rules of Go, try to understand the basic mechanics.
2. Start understanding the code. This step might be a little difficult, because the code might need a large refactoring.
3. Working on the issues.

# File Explanation

DISCLAIMER: We are only human. We are not entirely 100% sure about this, since we weren't the original creators of the code. As previously stated, the original authors made it a little confusing to understand, but here's a little guide.


ButtonAndScrollComponent.java -- Handles the scrollbars/buttons in the GUI

Go.java -- The main hub that controls all the pieces.

GoComponent.java -- Handles the actual game mechanics, such as piece color changing, and deciding whose turn it is.

GoGame.java -- Contains the interface used by GoGrid.java, and assists in the implementation of the game rules.

GoGrid.java -- Contains the implementation of GoGame.java, with appropriate methods that are used by GoComponent to help with the game mechanics. It's also responsible for the drawing of the grid, and the methods used to make sure that the rules stay valid.

GoGui1.java -- Organizes the layout of the game, to have the grid on the left side and the message box on the right side.

GoGui2.java -- Contains the "Directions" section of the GUI, handles little else but that.

GoIllegalMoveException.java -- Contains the Exception that occurs when you try to make an illegal move in Go.

MessageDestination.java/SystemOutMessageDestination.java -- The interface and the implementatino, respectfully; Simply contains an easier way to output messages to the system instead of having to put "System.out.println("x")".




# Running the Game

simply use the command:
```
ant run
```

![](http://i.imgur.com/wETn3ly.png?1)
