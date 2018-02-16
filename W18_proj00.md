Gehrig Weber, Github ID: praxideus

Misha Zaied, Github ID: shnube



(a) This project simulates the game of Go. It is 2-player only - no computer opponents.



(b) As a user, I can start a game of Go with another user, so that we can play a game of Go that never officially ends.
    The size of the board can be 5x5, 9x9, 13x13, and 19x19.
    
As a user, I can view the instructions of the game of Go, so that I understand how to enjoy this software.
    
    
    
(c) The software runs. It can display the instructions of the game of Go if the user clicks on a specific button. If the user clicks another button, they can then start a game of Go with the board size being 5x5, 9x9, 13x13, or 19x19.



(d) As a user, when I defeat an opponent, the software acknowledges my victory so I can enjoy this software.

As a user, when I lose to an opponent, the software acknowledges my defeat so my opponent can enjoy this software.

As a user, when I cannot finish a game right now, I can save the game and return to it later, so I and my opponent don't have to start over.

As a user, when I am playing a game of Go, I can listen to some nice music provided by the game, so I can better enjoy the software.

As a user, when I am all alone but would still like to play a game of Go, I can use this software to play against a computer opponent, so I can relieve my loneliness.



(e) The README.md is beyond useless. There is a large amount of seemingly useful information, yet a small snippet at the end, created by the F17 team, states that most of the README.md is now incorrect.
This small snippet does not provide any sort of replacement for this now incorrect information. First, I would delete the useless information, so that anyone who works on this in the future is not misled.
Then, I would add descriptions for each of the files in the repo. I would also add some basic rules for the game. Right now, "all the rules are implemented", but, coming across this for the first time, I have no idea what that means.



(f) The build.xml is based on Ant. It looks very clean, and it compiles the program perfectly. However, there are multiple warnings and errors when creating the javadoc. It needs to be fixed. It also needs to be modified so that it can be published to github pages.



(g) There are two critical issue to be fixed: the game never officially ends, and a user cannot capture an opponent's stones if that would require placing a stone on hte edge of the board (when they should be able to). The other issues would be very beneficial to have, and would greatly increase the enjoyability of the software, such as: having a computer opponent, having the option to surrender, and having music. Fixing the javadoc creation and creating JUnit tests would be benefical for anyone working on this project in the future. All of these issues are very clear in their expectations, and there are more than enough points possible to fulfill the requirement of 1000 project points.



(h) No additional issues have been added by us, at leaast not yet, because we have not touched the code.



(i) The code has each individual feature separated into its own .java file, past the point of practicality and efficiency. That being said, most filenames make clear exactly what their functions are, even if you have to follow the breadcrumb trail of function calls to find the source of the coded action. The code itself is clear enough, though some refactoring of the code to a more natural flow couldn't hurt readability. In an oversimplified overview, the code is connected as such: the ButtonsAndScrollComponent.java file creates all the user interfaces on the main menu screen, with buttons that link to various other .java files to open different options. The GameCreator.java file creates the initialized gameboard, and each click creates a Stone.java class object. It is still unclear to me how the program recognizes legal/illegal moves. 



(j) Insofar there are no JUnit tests. There are plans to remedy this problem later in the quarter, not only to improve our coding experience, but to help the next pair working on this project continue to improve the code. This will involve developing a comprehensive test suite for every aspect of the game code.
