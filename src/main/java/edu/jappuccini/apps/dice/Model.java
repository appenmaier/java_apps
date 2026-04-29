package edu.jappuccini.apps.dice;

import javafx.scene.image.Image;

/** Singleton model that wraps the die and exposes its current state for the Dice application. */
public class Model {

   private Dice dice;
   private static final Model INSTANCE = new Model();

   private Model() {
      dice = new Dice();
   }

   /** Returns the singleton instance of this model. */
   public static Model getInstance() {
      return INSTANCE;
   }

   /** Rolls the die to a new random value. */
   public void rollTheDice() {
      dice.rollTheDice();
   }

   /** Returns the image corresponding to the current die face. */
   public Image getDiceImage() {
      return dice.getImage();
   }

   /** Returns the numeric value of the current die face. */
   public int getDiceValue() {
      return dice.getValue();
   }

}
