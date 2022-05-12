## Simple Adventurer Project

This objectif of this project is to create simple Adventurer Project. 
The user journey is to allow a player to load a map from a text file and make his character move by using char inputs.

# Functionalities 

Actually, the project got 3 main functionalities : 

- StepByStep mode : You can enter the number of try, your character coordinates and move the character one by one.
- OneShot mode from console inputs : In this mode, you will simply enter your character coordinates and a complete movement path. The program will execute the whole command line and display the result.
- OneShot mode from text file : As the first OneShot mode, the program will execute the whole command line and display the result, but to decide where your character will start and what path he's going to take, you have to select a text file from a Windows window.

# Notes

The step by step mode could be improved by generating a random goal and letting the player choose the path he wants to take. Furthermore, it could be possible to add some special event, like enemy spawn, special chest etc. 
To do this, we should verify that the goal has a distance reachable according to the number of tries. 
To create character interaction, it would be better to create a Character class with some parameters like health, abilities, etc.

# Limits

Tried to implement some unit tests for the first time. The unit test present in the actual project are working, but only implemented for some return functions.
It could be interesting to make a whole battery of unit testing, to be sure that functions are exactly doing what they are supposed to do. But, in this case, I had not enough time to find the way to test functions that return void or return special Objects, like File[].

