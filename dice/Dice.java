package dice;

import java.util.Random;

import javafx.scene.image.Image;

public class Dice {

   private int value;
   private Image image;

   public Dice() {
      rollTheDice();
   }

   public void rollTheDice() {
      Random random = new Random();
      value = random.nextInt(1, 7);
      switch (value) {
         case 1:
            image = new Image(getClass().getResourceAsStream("one.png"));
            break;
         case 2:
            image = new Image(getClass().getResourceAsStream("two.png"));
            break;
         case 3:
            image = new Image(getClass().getResourceAsStream("three.png"));
            break;
         case 4:
            image = new Image(getClass().getResourceAsStream("four.png"));
            break;
         case 5:
            image = new Image(getClass().getResourceAsStream("five.png"));
            break;
         case 6:
            image = new Image(getClass().getResourceAsStream("six.png"));
            break;
      }
   }

   public int getValue() {
      return value;
   }

   public Image getImage() {
      return image;
   }

}
