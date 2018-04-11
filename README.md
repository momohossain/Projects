# swen261-sample-webapp

An online Number Guessing Game system built in Java 8 and Spark,
a web micro-framework.


## Prerequisites

- Java 8
- Maven


## How to run it

1. Unzip the distributed zipfile and go to the root directory holding this
   README file.
2. Execute `mvn compile exec:java`
3. Open in your browser `http://localhost:4567/`
4. Start a game and begin playing.


## How to test it

The Maven build script provides hooks for run unit tests and generate code coverage
reports in HTML.

To run all tests do this:

1. Execute `mvn clean test jacoco:report`
2. Open in your browser the file at `PROJECT_HOME/target/site/jacoco/index.html`

To run tests on a single tier do this:

1. Execute `mvn clean test jacoco:report -Dtest.tags=Model-tier`
2. Open in your browser the file at `PROJECT_HOME/target/site/jacoco/index.html`

To run tests on multiple tiers do this:

1. Execute `mvn clean test jacoco:report -Dtest.tags=Model-tier,Application-tier`
2. Open in your browser the file at `PROJECT_HOME/target/site/jacoco/index.html`


## How to build a submission zip

1. Execute `mvn assembly:single@zip`
2. The distribution zip will be in `target/guessing-game.zip`


## License

MIT License

See LICENSE for details.
