package balls;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller implements Initializable {

  @FXML
  private Canvas canvas;
  private Model model;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    model = Model.getInstance();

    canvas.setOnMouseClicked(e -> {
      Random random = new Random();
      int r = random.nextInt(25, 50);
      int x = (int) e.getX();
      int y = (int) e.getY();
      double red = random.nextDouble(1);
      double green = random.nextDouble(1);
      double blue = random.nextDouble(1);
      double opacity = random.nextDouble(0.5, 1);
      int speedX = random.nextInt(5, 15);
      int speedY = random.nextInt(5, 15);
      Color color = new Color(red, green, blue, opacity);
      model.addBall(new Ball(r, x, y, color, speedX, speedY));
    });

    AnimationTimer timer = new AnimationTimer() {
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
    };
    timer.start();
  }

}
