datamodel-command-java
=======================================

## Prerequisites ##
- maven
   - Version : 3.5.2
   - [How to install](https://maven.apache.org/install.html)
   - [Download](https://maven.apache.org/download.cgi)

## How to Build ##
- Linux command line
  1. Goto: <br></br>
    ~/datamodel-command-java/command-json-format

  2. Build command: <br></br>
    `$ mvn build` or `./build.sh.`

  3. On successful build it will create a jar: <br></br>
    ~/datamodel-command-java/command-json-format/target/datamodel-command-java-0.0.1-SNAPSHOT.jar

- eclipse IDE
  1. Import the datamodel-command-java sdk : <br></br>
    File -> Import -> Maven -> Existing Maven Projects -> Browse to "command-json-format" -> Finish

  2. Build : <br></br>
    Right Click on the project -> Run as -> Maven install

  3. On successful build it will create a jar: <br></br>
    ~/datamodel-command-java/command-json-format/target/datamodel-command-java-0.0.1-SNAPSHOT.jar
