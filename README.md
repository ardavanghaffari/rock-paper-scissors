Rock Paper Scissors
===================

A console application for playing the rock-paper-scissors game between a
computer and a user. A simple, extensible code in Java using the SOLID
principles, accompanied with cost-effective tests!

# Running the application
Produce a new JAR from project root, using:

  ```mvn clean install```

and run as:

  ```java -jar PRS-1.0-SNAPSHOT-jar-with-dependencies.jar $arg```

where arg is the number of times the game can be played. It's optional. It
defaults to 5 if not provided. The game can be played between 1 and 20 rounds.

# Libraries
Junit and Mockito are used for testing.
