package dice;

import javafx.scene.image.Image;

public class Model {

   private Dice dice;
   private static Model instance;

   private Model() {
      dice = new Dice();
   }

   public static Model getInstance() {
      if (instance == null) {
         instance = new Model();
      }
      return instance;
   }

   public void rollTheDice() {
      dice.rollTheDice();
   }

   public Image getDiceImage() {
      return dice.getImage();
   }

   public int getDiceValue() {
      return dice.getValue();
   }

}
