# PIM Developer Manual

## Platform
This manual is prepared for **Windows**.

## Java Version
The PIM project was developed using **Java version "15.0.1" 2020-10-20**.

## IDE
The recommended IDE for this project is **Microsoft Visual Studio Code**. You may need to install the **"Extension Pack for Java"** for the best development experience.

## Debugging Mode
To start the PIM in debugging mode, open `Main.java` in VS Code and click on the **"Debug"** option.

## Project Setup
Navigate to the PIM directory (`../PIM`) and execute the following commands:

```bash
javac -d build src/Model/*.java
javac -cp build -d build src/View/*.java
javac -cp build -d build src/Controller/*.java
javac -cp build -d build src/*.java
java -cp build Main
```

Alternatively, you can execute `run.bat`.

This manual should provide all the necessary information for a developer to get started with the PIM project. If you encounter any issues, please refer to the project's documentation or contact the project maintainer.