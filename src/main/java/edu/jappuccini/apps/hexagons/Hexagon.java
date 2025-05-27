package edu.jappuccini.apps.hexagons;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import lombok.Getter;

@Getter
public class Hexagon {

   private static final int BASE_VALUE = 5;
   private static final Color BASE_COLOR = Color.DARKGREY;
   private static final Color STROKE_COLOR = Color.GREY;
   private static final Color POSITIVE_COLOR = Color.DARKGREEN;
   private static final Color NEGATIVE_COLOR = Color.DARKRED;
   private final Polygon hexagon;
   private Text value;
   private boolean isFlipped;

   public Hexagon(double size, double x, double y) {
      /* Create Hexagon */
      hexagon = new Polygon();
      Double[] points = new Double[12];
      for (int i = 0; i < 6; i++) {
         double angle = Math.PI / 3 * i;
         double x_i = x + size * Math.cos(angle);
         double y_i = y + size * Math.sin(angle);
         points[i * 2] = x_i;
         points[i * 2 + 1] = y_i;
      }
      hexagon.getPoints().addAll(points);

      /* Create Value */
      value = new Text();
      value.setX(x);
      value.setY(y);
      value.setScaleX(size / 20);
      value.setScaleY(size / 20);

      /* Set Colors */
      hexagon.setFill(BASE_COLOR);
      hexagon.setStroke(STROKE_COLOR);
   }

   public void flip() {
      /* Set Flipped */
      isFlipped = true;

      /* Set Value */
      Random random = new Random();
      int tmp;
      if (random.nextInt(1, 4) >= 2) {
         tmp = BASE_VALUE * random.nextInt(1, 6);
      } else {
         tmp = BASE_VALUE * -1 * random.nextInt(1, 4);
      }
      value.setText(String.valueOf(tmp));

      /* Change Hexagon Color */
      if (Integer.valueOf(value.getText()) > 0) {
         hexagon.setFill(POSITIVE_COLOR);
      } else {
         hexagon.setFill(NEGATIVE_COLOR);
      }

      /* Set Value Color */
      Color color = (Color) hexagon.getFill();
      double r = color.getRed();
      double g = color.getGreen();
      double b = color.getBlue();
      double luminance = (0.2126 * r + 0.7152 * g + 0.0722 * b);
      if (luminance > 0.5) {
         value.setFill(Color.BLACK);
      } else {
         value.setFill(Color.WHITE);
      }
   }

}
