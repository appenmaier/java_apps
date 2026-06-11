package edu.jappuccini.apps.dice;

import java.io.IOException;
import java.io.InputStream;
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
      String fileName = switch (value) {
         case 1 -> "one.png";
         case 2 -> "two.png";
         case 3 -> "three.png";
         case 4 -> "four.png";
         case 5 -> "five.png";
         case 6 -> "six.png";
         default -> throw new AssertionError("Ungültiger Würfelwert: " + value);
      };
      image = loadImage(fileName);
   }

   private Image loadImage(String name) {
      try (InputStream is = getClass().getResourceAsStream(name)) {
         return new Image(is);
      } catch (IOException e) {
         throw new RuntimeException("Bilddatei nicht gefunden: " + name, e);
      }
   }

}
