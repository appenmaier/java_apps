package edu.jappuccini.apps.balls;

import java.util.ArrayList;
import java.util.List;

/** Singleton model that manages the collection of balls for the Balls application. */
public class Model {

   private List<Ball> balls;
   private static final Model INSTANCE = new Model();

   private Model() {
      balls = new ArrayList<>();
   }

   /** Returns the singleton instance of this model. */
   public static Model getInstance() {
      return INSTANCE;
   }

   /** Adds a ball to the collection. */
   public void addBall(Ball ball) {
      balls.add(ball);
   }

   /** Returns the list of all balls. */
   public List<Ball> getBalls() {
      return balls;
   }

}
