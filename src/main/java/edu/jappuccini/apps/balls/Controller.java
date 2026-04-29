package edu.jappuccini.apps.balls;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/** Controller for the Balls application; manages the animation loop and mouse interaction. */
public class Controller implements Initializable {

   private static final Random RANDOM = new Random();

   @FXML
   private Canvas canvas;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();

      canvas.setOnMouseClicked(new CanvasClickedEventHandler());

      BallsAnimationTimer timer = new BallsAnimationTimer();
      timer.start();
   }

   /** AnimationTimer that redraws and moves all balls every frame. */
   private class BallsAnimationTimer extends AnimationTimer {

      @Override
      public void handle(long l) {
         GraphicsContext g = canvas.getGraphicsContext2D();
         g.setFill(Color.WHITE);
         g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
         for (Ball ball : model.getBalls()) {
            ball.move(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
            g.setFill(ball.getColor());
            g.fillOval(ball.getX(), ball.getY(), ball.getR() * 2, ball.getR() * 2);
         }
      }

   }

   /** Event handler that creates a new random ball at the clicked canvas position. */
   private class CanvasClickedEventHandler implements EventHandler<MouseEvent> {

      @Override
      public void handle(MouseEvent event) {
         int r = RANDOM.nextInt(25, 50);
         int x = Math.clamp((int) event.getX(), 0, (int) canvas.getWidth() - 2 * r);
         int y = Math.clamp((int) event.getY(), 0, (int) canvas.getHeight() - 2 * r);
         double red = RANDOM.nextDouble(1);
         double green = RANDOM.nextDouble(1);
         double blue = RANDOM.nextDouble(1);
         double opacity = RANDOM.nextDouble(0.5, 1);
         int speedX = RANDOM.nextInt(5, 15) * (RANDOM.nextBoolean() ? 1 : -1);
         int speedY = RANDOM.nextInt(5, 15) * (RANDOM.nextBoolean() ? 1 : -1);
         Color color = new Color(red, green, blue, opacity);
         model.addBall(new Ball(r, x, y, color, speedX, speedY));
      }

   }

}
