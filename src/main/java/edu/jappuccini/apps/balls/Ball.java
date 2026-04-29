package edu.jappuccini.apps.balls;

import javafx.scene.paint.Color;
import lombok.Getter;

/** Represents a bouncing ball with position, radius, color, and velocity. */
@Getter
public class Ball {

   private Color color;
   private int r;
   private int speedX;
   private int speedY;
   private int x;
   private int y;

   /**
    * Creates a new ball with the given properties.
    *
    * @param r      radius of the ball
    * @param x      initial x position
    * @param y      initial y position
    * @param color  fill color
    * @param speedX horizontal speed in pixels per frame
    * @param speedY vertical speed in pixels per frame
    */
   public Ball(int r, int x, int y, Color color, int speedX, int speedY) {
      this.r = r;
      this.x = x;
      this.y = y;
      this.color = color;
      this.speedX = speedX;
      this.speedY = speedY;
   }

   /**
    * Moves the ball by its speed and reverses direction on boundary collisions.
    *
    * @param minX left boundary
    * @param minY top boundary
    * @param maxX right boundary
    * @param maxY bottom boundary
    */
   public void move(int minX, int minY, int maxX, int maxY) {
      x += speedX;
      y += speedY;
      if (x < minX) {
         x = minX;
         speedX = -speedX;
      }
      if (x + 2 * r > maxX) {
         x = maxX - 2 * r;
         speedX = -speedX;
      }
      if (y < minY) {
         y = minY;
         speedY = -speedY;
      }
      if (y + 2 * r > maxY) {
         y = maxY - 2 * r;
         speedY = -speedY;
      }
   }

}
