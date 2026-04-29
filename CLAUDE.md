# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## About

Sample solutions for JavaFX exercises from [Programmieren mit Java](https://jappuccini.github.io/java-docs/production/). Each app is a standalone JavaFX GUI application.

## Build & Run

```bash
# Compile
mvn clean compile

# Run tests
mvn test

# Package
mvn clean package
```

There is no Maven exec plugin configured — run apps from the IDE (Eclipse: right-click `MainClass.java` → Run As → Java Application).

**Stack:** Java 21, JavaFX 23.0.1 (controls + FXML), Lombok 1.18.36, JUnit 5.11.3, Mockito 5.14.2

## Architecture

Each app under `src/main/java/edu/jappuccini/apps/<appname>/` follows the same MVC pattern:

| File | Role |
|------|------|
| `App.java` | Entry point + extends `BaseApp` — implements `getTitle()` and `getFxmlName()` |
| `<Name>Controller.java` | Implements `Initializable` — `@FXML` fields, event handlers |
| `Model.java` | Business logic, singleton via `getInstance()` (eager initialization: `INSTANCE = new Model()`) |
| `<Name>View.fxml` | UI definition in `src/main/resources/.../` mirroring the Java package path |

`BaseApp` (`src/main/java/edu/jappuccini/apps/BaseApp.java`) is the shared base class that handles FXML loading, Scene/Stage setup, and `setResizable(false)` for all apps.

Apps with more complexity (e.g. `chess`, `login`) add domain model classes (e.g. `ChessFigure`, `User`) and extra controllers/views alongside this base structure.

## Apps

| Package | Description |
|---------|-------------|
| `balls` | Animated bouncing balls with physics (uses `AnimationTimer`); balls spawn at the clicked canvas position with random color, radius, and direction |
| `calculator` | Calculator with input validation and custom `InvalidInputException`; expects input as `"number operator number"` (comma or dot as decimal separator) |
| `chess` | Chess board with piece types (`ChessFigureType`) and colors (`ChessColor`); clicking a piece selects it, clicking another own piece switches selection, clicking an enemy piece captures it |
| `circles` | Canvas-based circle drawing with random size, position, and color |
| `dice` | Dice roller with image assets; rolls on startup and on button click |
| `hexagons` | Turn-based two-player game on a 5×5 hexagon grid; clicking a tile reveals a random point value (positive or negative); highest score wins |
| `interest` | Compound interest calculator |
| `led` | LED simulation with on/off toggle and color cycling (red → green → blue → red) |
| `login` | Multi-screen app with `LoginController` + `UserController` and a hardcoded user list in the model |
