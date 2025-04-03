package balls;

import java.util.ArrayList;
import java.util.List;

public class Model {

   private List<Ball> balls;
   private static Model instance;

   private Model() {
      balls = new ArrayList<>();
   }

   public static Model getInstance() {
      if (instance == null) {
         instance = new Model();
      }
      return instance;
   }

   public void addBall(Ball ball) {
      balls.add(ball);
   }

   public List<Ball> getBalls() {
      return balls;
   }

}
