JPacman Scenarios
=================

Arie van Deursen, Delft University of Technology.


## 1. Background

This document describes a series of JPacman user scenarios, following the format of [behavior-driven development](http://dannorth.net/whats-in-a-story/).

Thus, each scenario is of the form:

---
 **Title** _one line describing the story_

**Narrative**

    As a [role]
     I want [feature]
    So that [benefit]

**Acceptance Criteria,** _presented as scenarios of the form:_

    Scenario 1: Title
    Given [context]
     and  [some more context]...
    When  [event] 
    Then  [outcome]
     and  [another outcome]...
----


## 2. JPacman Overview

JPacman is a very simple JPacman derivative, to be used for educational purposes. Essential features such as multiple levels and multiple players, energizers and different ghost types are postponed for later releases (and may be implemented by students as an exercise).  Furthermore, to give the game a somewhat different flavor, JPacman deviates from standard Pacman behavior in several ways.  This document describes the requirements as a series of use cases, and explains what the GUI should look like.

The JPacman game is played on a rectangular board.  A square on the board can be empty, or can contain the Pacman itself, one of the several ghosts, a pellet (worth 10 points), or a wall. Moveable characters such as the Pacman and the ghosts can make single-step horizontal or vertical moves.  Tunnels on the border make it possible to move from one border to the opposite border.  When the Pacman moves over a square containing a pellet, the player earns points and the pellet disappears. If a player and a ghost meet at the same square, the the game is over. The player wins the game once he or she has eaten all pellets.

JPacman ที่กลุ่มเราได้พัฒนาได้มีการเพิ่มปุ่ม Start ในหน้า Home เพื่อเข้าสู่หน้าเลือกด่านที่กลุ่มเราได้เพิ่ม Feature 
ในการเลือกด่านโดยมีด่านให้เลือกทั้งหมด 5 ด่าน ได้แก่ด่าน Maha-Ud, ด่าน Takrut Ton, ด่าน Chatra Phet,ด่าน Phokkasub 
และด่าน Praphutnimit โดยด่านที่ออกแบบได้รับแรงบันดาลใจจากยันต์ต่างๆ และได้มีการเพิ่มปุ่ม Theme ในหน้า Home เพื่อเข้าสู่หน้า Theme ที่ด้เพิ่ม Feature 
ในการเลือก Theme ของเกม โดยมีทั้งหมด 5 Theme ได้แก่ Original, Wat Prasri, Wat Mahabud, Wat Sa-mhan และ Wat Khamer โดยได้รับแรงบันดาลใจจาก
วัดต่างๆ โดยที่ในแต่ละ Theme ได้มีการแก้ไข Wall และ Pallets ให้เป็นกำแพงวัดและพระเครื่องที่เข้ากับวัดต่างๆในแต่ละ Theme และเราได้ยังเก็บ Theme Original 
เพื่อคงความเป็น Pacman ไว้ 


## 3. User Stories

#### Story 1: Startup

```
As a player
 I want to start the game
so that I can actually play
 
Scenario S1.1: Start.
Given the user has launched the JPacman GUI;
When  the user presses the "Start" button,
and select the map at mappage;
Then  the game should start.
```


#### Story 2: Move the Player

```
As a player, 
 I want to move my Pacman around on the board;
So that I can earn all points and win the game.

Scenario S2.1: The player consumes
Given the game has started,
 and  my Pacman is next to a square containing a pellet;
When  I press an arrow key towards that square;
Then  my Pacman can move to that square,
 and  I earn the points for the pellet,
 and  the pellet disappears from that square.

Scenario S2.2: The player moves on empty square
Given the game has started,
 and  my Pacman is next to an empty square;
When  I press an arrow key towards that square;
Then  my Pacman can move to that square
 and  my points remain the same.

Scenario S2.3: The move fails
Given the game has started,
  and my Pacman is next to a cell containing a wall;
When  I press an arrow key towards that cell;
Then  the move is not conducted.

Scenario S2.4: The player dies
Given the game has started,
 and  my Pacman is next to a cell containing a ghost;
When  I press an arrow key towards that square;
Then  my Pacman dies,
 and  the game is over.
  
Scenario S2.5: Player wins, extends S2.1
When  I have eaten the last pellet;
Then  I win the game.
```


#### Story 3: Move The Ghost
```
As a ghost;
 I get automatically moved around;
So that I can try to kill the player.

Scenario S3.1: A ghost moves.
Given the game has started,
 and  a ghost is next to an empty cell;
When  a tick event occurs;
Then  the ghost can move to that cell.

Scenario S3.2: The ghost moves over a square with a pellet.
Given the game has started,
 and  a ghost is next to a cell containing a pellet;
When  a tick event occurs;
Then  the ghost can move to the cell with the pellet,
 and  the pellet on that cell is not visible anymore.

Scenario S3.3: The ghost leaves a cell with a pellet.
Given a ghost is on a cell with a pellet (see S3.2);
When  a tick even occurs;
Then  the ghost can move away from the cell with the pellet,
 and  the pellet on that cell is is visible again.

Scenario S3.4: The player dies.
Given the game has started,
 and  a ghost is next to a cell containing the player;
When  a tick event occurs;
Then  the ghost can move to the player,
 and  the game is over.
```
#### Story 4 : Select Theme

```
As a player,
  I want to select theme;
so that I can try different theme  

Scenerio S4.1: select Theme Original
Given on select Theme page;
When the player clicks "Original" button;
Then back to Homepage and show Original Theme.

Scenerio S4.2: select Theme Wat Prasri
Given on select Theme page;
When the player clicks "Wat Prasri" button;
Then back to Homepage and show Wat Prasri Theme.

Scenerio S4.3: select Theme Wat Mahabud
Given on select Theme page;
When the player clicks "Wat Mahabud" button;
Then back to Homepage and show Wat Mahabud Theme.

Scenerio S4.4: select Theme Wat Sa-mhan
Given on select Theme page;
When the player clicks "Wat Sa-mhan" button;
Then back to Homepage and show Wat Sa-mhan Theme.

Scenerio S4.5: select Theme Wat Khamer
Given on select Theme page;
When the player clicks "Wat Khamer" button;
Then back to Homepage and show Wat Khamer Theme.
```

#### Story 5 : Select Stage

```
As a player,
  I want to select stage;
so that I can play diferrent stage  

Scenerio S5.1: select Maha-ud Stage
Given on select Stage page;
When the player clicks "Maha-ud" button;
Then The game shows the game playing page with the Maha-ud stage.

Scenerio S5.2: select Takrut Ton Stage
Given on select Stage page;
When the player clicks "Takrut ton" button;
Then The game shows the game playing page with the Trakrut Ton stage.

Scenerio S5.3: select Chatra Phet Stage
Given on select Stage page;
When the player clicks "Chatra Phet" button;
Then The game shows the game playing page with the Chatra Phet stage.

Scenerio S5.4: select Phokkasub Stage
Given on select Stage page;
When the player clicks "Phokkasub" button;
Then The game shows the game playing page with the Phokkasub stage.

Scenerio S5.5: select Praphutnimit Stage
Given on select Stage page;
When the player clicks "Praphutnimit" button;
Then The game shows the game playing page with the Praphutnimit stage.

```

#### Story 6 : Show Score

```
As a player,
 I want to see my score ;
So that I can know current score.

Scenario S6.1: During Playing.
Given Playing game;
When  the player look at banner;
Then  banner is show current score.

Scenario S6.2:  the player dies.
Given the player dies;
When  the game is  show Game over page  ;
Then  the game is show score that the player score achieved.

Scenario S6.3:  the player wins.
Given the player win the game;
When  the game is  show You win page  ;
Then  the game is show score that the player score achieved.
```

#### Story 7 : Suspend the Game

```
As a player,
 I want to be able to suspend the game;
So  that I can pause and do something else.

Scenario S7.1: Suspend the game.
Given the game has started;
When  the player clicks the "Pause" button;
Then  all moves from ghosts and the player are suspended.

Scenario S7.2: Resume the game.
Given the game is suspended;
When  the player hits the "Resume" button;
Then  the game is resumed.

Scenario S7.2: Quit the game.
Given the game is suspended;
When the player hits the "Quit" button;
then the game back to Homepage.

```
#### Story 8 : Quit the game

```
As a player,
 I want to quit playing game ;
So that I can close the game or change something.

Scenario S8.1: during play the game.
Given Playing game;
When  the player clicks "Pause" button,
and clicks "Quit" button;
Then the game back to the homepage.

Scenario S8.2:  the player dies.
Given the player dies;
When the game is  show Game over page,
and the player clicks "Quit" button; 
Then the game back to homepage.

Scenario S8.3:  the player wins.
Given the player win the game;
When  the game is  show You win page,
and the player clicks "Quit" button;
Then  the game back to homepage.

```

#### Story 9 : Restart the Game

```
As a player,
 I want to restart the game;
So  that I can play that stage again.

Scenario S9.1: the player dies.
Given the game is show game over page;
When  the player clicks the "Restart" button;
Then  the game restart at that stage.


```

## 3. User Interface

The user interface for JPacman is relatively simple.  The game is
rectangular board, which can be read from a special text file with
simple character encoding. On the GUI, special (animated) images or
colored squares are used for the ghost, food, empty cells, and wall
cells on the board.  The direction of the last (attempted) move is
reflected in the image used for the player. The GUI furthermore
contains a "Start", and "Stop" button (at the bottom of the
GUI), as well as an indicator for the amount of food eaten and the
game's overall state (playing, game won, player died, ready to start
the play). 

ในส่วนของตัวละคร Pacman เราได้ทำการแต่งตัว Pacman เป็นลุงกำนันที่เป็นเซียนพระและมีชื่อว่าลุงอิน โดยลุงอินจะสะสม Pallet พระเครื่องจากวัดต่างๆเพื่อหนีผีต่างๆจากแต่ละ
Theme ได้แก่
- Theme Wat Prasri จะมี Pallet เป็นพระเครื่องเขียวและ Ghost เป็นผีตานี
- Theme Wat Mahabud จะมี Pallet เป็นพระเครื่องน้ำเงินและ Ghost เป็นกุมารทอง
- Theme Wat Sa-mhan จะมี Pallet เป็นพระเครื่องน้ำตาลและ Ghost เป็นผีงั่ง
- Theme Wat Khamer จะมี Pallet เป็นพระเครื่องส้มและ Ghost เป็นผีตาโบ๋

เมื่อผู้เล่นเลือก Theme และด่านแล้ว ผู้เล่นจะเข้าสู่หน้าเล่นเกม โดยที่เราจะมีเวลานับถอยหลัง 5 วินาทีเพื่อเป็นการเตรียมตัวก่อนเริ่มเกม
ในหน้านี้เราจะมีชื่อด่าน คะแนนของผู้เล่น และปุ่ม Pause ในระหว่างเล่นเกม ผู้เล่นสามารถกดปุ่ม Pause หยุดเกมระหว่างเล่นได้ โดยจะแสดง Pop-up Pause
โดยสามารถเลือกเล่นต่อที่ปุ่ม Resume หรือออกจากเกมที่ปุ่ม Quit ได้ หากผู้เล่นเลือกออกจากเกมจะกลับไปที่หน้า Home ของ Theme ที่ผู้เล่นเลือก หากผู้เล่นเลือกเล่นต่อ
เกมจะแสดงหน้าเกมต่อจากที่เล่นค้างไว้และมีเวลาแสดง 3 วินาทีเพื่อเป็นการเตรียมตัวก่อนเริ่มเล่น หากผู้เล่นเล่นจนจบด่านจะแสดงหน้า Win และคะแนนของผู้เล่น
และแสดงปุ่ม Quit เพื่อออกไปยังหน้า Home และหากผู้เล่นเล่นไม่ผ่านด่านจะแสดงหน้า Game Over โดยจะบอกคะแนนของผู้เล่นและปุ่ม Restart
เพื่อให้ผู้เล่นสามารถกลับไปเล่นด่านนี้ได้

## 4. Development Requirements

JPacman should be developed in Java. It should be set up so that it
can easily be used by (the latest versions of) standard (open source) Java development tools, such as maven, JUnit, Eclipse/IntelliJ, cobertura, etc. To allow for working with maven, the maven standard directory structure should be used.  Since the educational purposes include testing, JPacman should be delivered with an extensive test suite.

----
[![Creative Commons License](http://i.creativecommons.org/l/by-sa/4.0/88x31.png)](http://creativecommons.org/licenses/by-sa/4.0/)
