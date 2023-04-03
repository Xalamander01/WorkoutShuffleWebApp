Project Overview: 
The author of this project, as well as many other people, has at least once in their lives started going to the gym and given up soon thereafter without seeing significant results.
After some reflection, the conclusion was reached that the biggest reason for this is that very few people know how to make their workouts less repetitive and thus more enjoyable.
The goal of this small application is to make time spent in the gym more entertaining by giving users a varied list of exercises every time they open the app.
After all, variety is the spice of life.

Installation Instructions:
To try this out for yourself, import this into your IDE of choice. 
You can obtain a copy of the SQL database by importing the following file to your machine:

workoutShuffleDump20230306.sql

Usage: 
Currently, when you launch the app, you are greeted with an index page that gives users the option to generate a single workout or a weekly split.
For a single workout, they simply have to give the type of workout they want.
If they choose weekly, then how many times per week do they want to exercise, and how repetitive do they want their weekly sessions to be?
After the user submits this information, they get a list of workouts that they can follow at their leisure.

Technologies Used:
The back end project is built on Java 17 with Spring Boot.
Connection to the MySQL database is achieved using the Java Persistence API.
The front end is built with React

Next steps to improve:
The variety algorithm can and will be improved in the future.
The database can be significantly expanded.
The criteria on which exercises are graded can also be updated.
Different exercises can be selected based on the available equipment.
