# Tic-Tac-Toe

This repository contains a modified version of the Tic-Tac-Toe game. This modified game operates with 3 players (2 
users and the computer) and a board size that can vary from 3X3 to 10X10. The two users play against each other and 
against the computer. The order of the player is random. The position should be provided in a format like x,y (0,1).

```
Board:
| | | |
| | | |
| | | |

Player 1, you're up. Enter a position like x,y:
0,0
Board:
|X| | |
| | | |
| | | |

Player 2, you're up. Enter a position like x,y:
```

# How to run
Make sure your system has installed both [Java 8](https://www.java.com/en/download/faq/java8.xml) and 
[Maven +3.0.5](https://maven.apache.org/index.html).

* From the project root folder:
  * Use `mvn package` to build
  * Run the game with `java -jar target/tic-tac-toe-1.0-SNAPSHOT.jar`
  * You can build & run using `mvn spring-boot:run`
  * For running the tests only, execute `mvn test`

# Game settings
You can change the game configuration in the `./resources/application.properties` file. There you can set the players
characters as well as the board size.

# Implementation Overview
* Despite not really needed, the application uses [SpringBoot 2.0](https://spring.io/projects/spring-boot), taking 
advantage of some of the key benefits of such framework. By using the Spring container, boiler plate code is minimized, 
as it manages the life cycle and configuration of the objects. Tic-Tac-Toe makes use of the inversion of control that 
Spring helps to achieve. Also, the access to the configuration is done through the Spring framework.
* For the unit testing, [JUnit 4](https://junit.org/junit4/) and [Mockito 2](http://site.mockito.org/) are combined to 
run the tests, mock some elements to keep test isolated and to assert the expected results.

# Code Highlights
* `GameManager.java` is responsible for the dynamic of the game. It manages the interactions between the entities 
involved. It handles the players (whose turn is up), the board and the rules of the game. Game is still up while it 
says there's a play to be done.
* `PlayerFactory.java` provides the list of players (`Player.java`) composed by their names, characters (from the 
`application.properties`) and their designated implementation of `PositionReader.java`. Users should enter their plays
through the `PlayerPositionReader` as the computer does through `ComputerPosition.java`.
* The input "x,y" pattern is taken care of by `InputValidator.java`.
* Who's the winner is decided by `WinnerChecker.java`, called right after every successful play. It follows the 
basic/original rules: either a row, a column, or any of the diagonals fully filled with same character makes a winner 
(regardless of the board size).
* The `Board.java` has board size and position validation.
* The classes of exceptions are in the `exception` package. Most of the exceptions in there extend the java 
`RuntimeException` but the `UnableToReadPosition` (when the `IOException` is caught reading the position entered by the 
user, it is thrown, working as a interface to the users playing).

# Comments
* Code is modular enough to change behavior with class replacement; i.e. if the rule to win the game changes to: first 
player who takes all corners wins, a single place should be changed (ideally an interface should exist as of now, but 
for simplicity, I decided not to).
* I feel like there is space for improvement in the winner checker algorithms on what regards performance.
* Maybe I could've used more of Java 8 features, specially streams, but I am not sure if that would do any good in 
terms of code readability and performance, though.
* As mentioned before, the SpringBoot framework is not a requirement, as can be seen in the 
[commit 33da7ed](https://github.com/steinhen/tic-tac-toe/commit/33da7edcd4e19079620bde91a9ad05cb61fce6a3), when the 
game was working pretty much as the latest version but without the framework (even the dependency injection was there). 
* Another thing that would be nice to have would be a facade for the output, that would come in handy in case the 
`System.out` was no longer desired - there would be a single point of change.