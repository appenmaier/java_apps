package edu.jappuccini.apps.circles;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** Controller for the Circles application; draws random circles on a canvas. */
public class Controller implements Initializable {

   private static final Random RANDOM = new Random();

   @FXML
   private Canvas canvas;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      GraphicsContext g = canvas.getGraphicsContext2D();
      g.setFill(Color.WHITE);
      g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
   }

   /** Draws a randomly sized and colored circle at a random position on the canvas. */
   @FXML
   public void drawCircle(ActionEvent actionEvent) {
      int d = RANDOM.nextInt(10, 100);
      int x = RANDOM.nextInt(0, (int) canvas.getWidth() - d);
      int y = RANDOM.nextInt(0, (int) canvas.getHeight() - d);
      double red = RANDOM.nextDouble(1);
      double green = RANDOM.nextDouble(1);
      double blue = RANDOM.nextDouble(1);
      double opacity = RANDOM.nextDouble(0.5, 1);
      Color color = new Color(red, green, blue, opacity);

      GraphicsContext g = canvas.getGraphicsContext2D();
      g.setFill(color);
      g.fillOval(x, y, d, d);
   }

}
