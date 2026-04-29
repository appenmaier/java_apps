package edu.jappuccini.apps.dice;

import java.util.Random;

import javafx.scene.image.Image;
import lombok.Getter;

/** Represents a six-sided die that stores its current value and the corresponding image. */
@Getter
public class Dice {

   private static final Random RANDOM = new Random();

   private int value;
   private Image image;

   public Dice() {
      rollTheDice();
   }

   /** Generates a random value between 1 and 6 and loads the matching face image. */
   public void rollTheDice() {
      value = RANDOM.nextInt(1, 7);
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

}
