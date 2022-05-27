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

#### Commands  of the TUI

### Running the GUI

To run this application, with the GUI, from the command line:

```bash
java -cp target/classes gui.Main ARG ARG ARG
```

#### Commands  of the TUI



### How run the JUnit tests with Maven
 THe JUnit test are usefull to cover all the corner cases and let you know if your code is going well. 
 For running them we can use:

 - `mvn test` for see the test that run and pass or fail.
 - `mvn site` for watch also the coverage for each class with JUnit tests.
 

 
	 
    

```bash
mvn test
```

### How to run Checkstyle with Maven

```bash
mvn compile
mvn checkstyle:check
```

### How to run PMD with Maven

```bash
mvn compile
mvn pmd:check
```

### How to run PMD's CPD with Maven

```bash
mvn compile
mvn pmd:cpd-check
```

### How to determine test coverage with Maven

```bash
mvn site
```

Then open `target/site/index.html` and find the JaCoCo report.
