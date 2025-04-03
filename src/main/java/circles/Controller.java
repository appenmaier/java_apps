package circles;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller implements Initializable {

   @FXML
   private Canvas canvas;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      GraphicsContext g = canvas.getGraphicsContext2D();
      g.setFill(Color.WHITE);
      g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
   }

   @FXML
   public void drawCircle(ActionEvent actionEvent) {
      Random random = new Random();
      int d = random.nextInt(10, 100);
      int x = random.nextInt(0, (int) canvas.getWidth() - d);
      int y = random.nextInt(0, (int) canvas.getHeight() - d);
      double red = random.nextDouble(1);
      double green = random.nextDouble(1);
      double blue = random.nextDouble(1);
      double opacity = random.nextDouble(0.5, 1);
      Color color = new Color(red, green, blue, opacity);

      GraphicsContext g = canvas.getGraphicsContext2D();
      g.setFill(color);
      g.fillOval(x, y, d, d);
   }

}
