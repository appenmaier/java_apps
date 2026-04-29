package edu.jappuccini.apps.hexagons;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

/** Controller for the Hexagons application; manages a two-player turn-based grid game. */
public class Controller {

   private static final int GRID_SIZE = 5;

   @FXML
   private Pane grid;
   @FXML
   private Label points1Text;
   @FXML
   private Label points2Text;
   @FXML
   private Label currentPlayerText;

   private List<Hexagon> hexagonFields;
   private int points1;
   private int points2;
   private int currentPlayer;
   private int rounds;

   @FXML
   public void initialize() {
      resetGame();
   }

   /** Resets all game state and rebuilds the hexagon grid. */
   private void resetGame() {
      /* Initialize Attributes */
      hexagonFields = new ArrayList<>();
      rounds = 0;
      points1 = 0;
      points2 = 0;
      currentPlayer = 1;
      currentPlayerText.setText(currentPlayer == 1 ? "1" : "2");
      points1Text.setText("0");
      points2Text.setText("0");

      /* Clear existing grid */
      grid.getChildren().clear();

      /* Calculate Hexagon Size */
      Screen primaryScreen = Screen.getPrimary();
      Rectangle2D visualBounds = primaryScreen.getVisualBounds();

      double screenHeight = visualBounds.getHeight();

      double hexagonSize = screenHeight / (GRID_SIZE * 2.5);
      double hexagonHeight = Math.sqrt(3) * hexagonSize;
      double hexagonWidth = 2 * hexagonSize;

      /* Create Grid */
      for (int row = 0; row < GRID_SIZE; row++) {
         for (int column = 0; column < GRID_SIZE; column++) {
            double x = column * (hexagonWidth * 3 / 4);
            double y = row * hexagonHeight;
            if (column % 2 != 0) {
               y += hexagonHeight / 2;
            }
            Hexagon hexagonField = new Hexagon(hexagonSize, x + hexagonSize, y + hexagonHeight / 2);
            hexagonFields.add(hexagonField);

            final int r = row;
            final int c = column;
            hexagonField.getHexagon().setOnMouseClicked(event -> handleHexagonFieldClick(r, c));
            grid.getChildren().addAll(hexagonField.getHexagon(), hexagonField.getValue());
         }
      }
   }

   /**
    * Handles a click on a hexagon tile: flips it, awards points to the current player,
    * switches turns, and shows a game-over dialog when all tiles are revealed.
    */
   private void handleHexagonFieldClick(int row, int column) {
      /* Get Hexagon */
      int index = row * GRID_SIZE + column;
      Hexagon hexagon = hexagonFields.get(index);
      if (hexagon.isFlipped()) {
         return;
      }

      /* Increment Rounds */
      rounds++;

      /* Flip Hexagon */
      hexagon.flip();

      /* Add Points */
      if (currentPlayer == 1) {
         points1 += Integer.valueOf(hexagon.getValue().getText());
         points1Text.setText(String.valueOf(points1));
      } else {
         points2 += Integer.valueOf(hexagon.getValue().getText());
         points2Text.setText(String.valueOf(points2));
      }

      /* Check Game Over */
      if (rounds == hexagonFields.size()) {
         String text;
         if (points1 > points2) {
            text = "Spieler 1 gewinnt";
         } else if (points2 > points1) {
            text = "Spieler 2 gewinnt";
         } else {
            text = "Beide Spieler gewinnen";
         }

         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Game Over");
         alert.setHeaderText("Das Spiel ist vorbei");
         alert.setContentText(text);
         alert.showAndWait();

         resetGame();
         return;
      }

      /* Switch Player */
      currentPlayer = (currentPlayer == 1) ? 2 : 1;
      currentPlayerText.setText((currentPlayer == 1) ? "1" : "2");
   }

}
