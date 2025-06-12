# Rock Paper Scissors

A console application for playing the rock-paper-scissors game between a computer and a user.
A simple, extensible code in Java using the _SOLID_ principles, accompanied with cost-effective
tests!

## How's the code SOLID?

To give some examples, the code adheres to the _Open-Closed Principle_ since new weapons
(e.g. rock, paper and scissor) can be added to the application by just adding new code without
modifying any of the existing code. All we have to do is add a new class that implements the
`Weapon` interface and inject an instance of it when the application starts. We don't have to
hunt through all the code looking for places that may require a change because of the new weapon.
There are for example no switch statements that switch over different types of weapons. We've
achieved this through the use of abstractions and polymorphism. The same also holds for adding
new types of players. The code is, in this sense, closed against adding new weapons and players.

The code also follows the _Dependency Inversion Principle_ by separating the abstractions from the
concretions. `Game` is the high level policy of the application. `Computer` and `Human` are the
low level implementation details. They both depend on the `Player` which is the abstraction.

And finally, the code _asks for what instead of telling how_. An example of this is `Game` which
doesn't _tell_ `Computer` and `Human` how to choose their weapon or interact with the UI. Instead,
it _trusts_ its collaborators do their part by passing itself to them and letting them ask for
the things they need. This reduces `Game`'s context and makes it more reusable.

## Running the application

Produce a new JAR from the project root, using:

`./gradlew clean build`

and run as:

`java -jar build/libs/rock-paper-scissors-1.0.jar $arg`

where `arg` is the number of times the game can be played. It's optional. It defaults to 5 if
not provided. The game can be played between 1 and 20 rounds.
