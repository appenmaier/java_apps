package edu.jappuccini.apps.led;

/** Singleton model that holds the LED instance for the LED application. */
public class Model {

   private LED led;
   private static final Model INSTANCE = new Model();

   private Model() {
      led = new LED();
   }

   /** Returns the singleton instance of this model. */
   public static Model getInstance() {
      return INSTANCE;
   }

   /** Returns the LED managed by this model. */
   public LED getLED() {
      return led;
   }

}
