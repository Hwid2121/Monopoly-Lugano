
# Monopoly Lugano Edition

A simple monopoly game with all the squares insipired by the city of Lugano. 
The game is possibile to play with:

 - TUI ( Terminal User Interface)
 - GUI (Graphical User Interface)

## Team Members

* Nicolo' Tafta (nicolo.tafta@usi.ch), Hwid2121
* Alberto Sardo (alberto.sardo@usi.ch), AlbertoSardo

## Mentor

* Diego Marcilio

## Project Structure

The code is structured into three packages:

* `model` - all the model classes and their tests
* `tui` - text user interface (works in a terminal)
* `gui` - Swing-based graphical user interface (opens a window)

Inside of the `Model` the code is structured with different classes with its own tests:

 - BonusSquare
 - Card
 - CardsDeck
 - Dice
 - House
 - JailSquare
 - Monopoly
 - Player
 - PropertySquare
 - Square
 - Table

The `tui` is composed by:

 - Main
 Inside of the Main there are all the methods for the interactions with the user and the strcucture of monopoly.

The `GUI` is composed by:

 - Images (package)
 - CLayout
 - FormPanel
 - GameFrame
 - GameMain
 - GamePanel
 - Main
 - MonopolyCommandsPanel
 - MonopolyGridPanel
 - MonopolyPanel
 - MonopolyPlayerPanel
 - MyButton
 - NicknameForm
 - NumPlayerFrame
 - PanelEnd
 - PanelMonopoly
 - PanelNickname
 - PanelPlayers
 - PanelPregame
---
You can use Maven to compile, test, and check the code
by running `mvn` in this top-level directory (see below).


The classes in the `model` package are not refer to any
classes in the `tui` or `gui` packages. But instead TUI and GUI refer to model for take the structure of Monopoly game.



In the `model` package is covered by unit tests.

## Known problems
The project has trouble with the execution with BlueJ:
	The imports inside of the classes will be broken.


## How build using Maven

In this top-level directory:

```bash
mvn compile
```



## How to run the application

To run the application from outside BlueJ, first build it with Maven.
This generates the compiled classes in the directory `target/classes`.

Using an IDE will be helpful to play quickly. 
For the Visual Studio Code IDE and InteliJ just import the project and compile it.
We can choose between compile the `tui`  or the `gui`

### Running the TUI

To run this application, with the TUI, from the command line:

```bash
java -cp target/classes tui.Main ARG ARG ARG
```


### Running the GUI

To run this application, with the GUI, from the command line:

```bash
java -cp target/classes gui.Main ARG ARG ARG
```


#### Commands  of the TUI

The game is divided by different stages:
 - Pregame
 This is the start of the match, the user decide how many player will play (number > 1).
For each player it asked to insert the Nickname.
When all the players have a nickname, the pregame finish.
- Game
 The dice is rolled automatically every start of the turn.
The game will tell which square is the player after the rolling. 
If the Square is:
	- Bonus, then the description and the action of the square will be visible.
	- Jail, the player will be in jail and it can be free doing:
		- Waiting 3 turns. 
		- Paying the fine of the jail.
		- Doing a perfect pair with the dice.
	-	Property:
	The player can choose between:
	
			-	[d] (for the description of the property) 
			-	[b] (for buying the property) 
			-	[s] (to sell this property)  
			-	[p] (to finish the turn) 
			-	[m] (to show your balance)
			-	[i] (for all info of the player)   
			-	[c] (for show the situation of the other properties of same color)
			-	[h] (for buy house, hotel and more info)
			-	[o] (for see the infos for other players)
			
	For every comand the player must have the requisties for using otherwise an advertise will be shown.
	
		-	Without owner:
			The plauer can buy the property.
			
		-	With owner (not itself):
			The player must pay the rent.
		
		- With owner (itself):
		- The player can sell it or build houses and hotels.

- Go to jail:
 The player will be moved to the jail.

- Pick card:
The player must pick a card that can be bonus (add money) or malus (take out money).


- Empty Square:
	Nothing to do for the plaeyer.

When the player is out of money it will be in bankrupt status, where the player must sell its properties and reach at least 0 otherwise the player will be eliminated.

When the player buy every square of same color then the player will do Monopoly Color and the rent for each property of that color will be doubled.

The game finish when only one player have still money.


## GUI 
The game is the of TUI, some feature is in update.


## GUI - to know
Every stage is refresh at each turn. Then for every update it will be show 
	 
    

## TUI's Key Aspects Screenshots

* Starting the game choosing the number and the name of the players, then let's throw the dice for the first time!
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen1readmetui.png)
* Let's buy a property square!
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen3readmetui.png)
* Let's sell a property square!
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen4readmetui.png)
* Showing current player info's.
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen5readmetui.png)
* Showing current player bank balance.
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen6readmetui.png)
* Showing other players info's
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen2readmetui.png)
* Showing the situation of the other properties of the same colour.
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen7readmetui.png)

## GUI's Key Aspects Screenshots

* Initial Main Menu
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen1readmegui.png)

* Pregame Panel, choosing the number of players.
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen2readmegui.png)

* Pregame Panel, choosing the names of the players. 
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen2readmegui.png)


* Game Panel, start of the game. 
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen6gui.png)


* Game Panel, the process of the game. 
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen5gui.png)



* Game Panel, the BonusSquare frame of the game. 
![.](https://github.com/usi-pf2-2022/project-monopoly-dinasty/blob/main/src/gui/images/screen4gui.png)
