package edu.jappuccini.apps.led;

import javafx.scene.paint.Color;

/** Represents an LED with a cycling color and an on/off shining state. */
public class LED {

   private Color color;
   private boolean isShining;

   public LED() {
      color = Color.RED;
   }

   /** Returns the current color of this LED. */
   public Color getColor() {
      return color;
   }

   /** Returns {@code true} if this LED is currently switched on. */
   public boolean isShining() {
      return isShining;
   }

   /** Cycles the LED color through red → green → blue → red. */
   public void switchColor() {
      color = color.equals(Color.RED) ? Color.GREEN
            : color.equals(Color.GREEN) ? Color.BLUE : Color.RED;
   }

   /** Turns the LED off (stops shining). */
   public void switchOff() {
      isShining = false;
   }

   /** Turns the LED on (starts shining). */
   public void switchOn() {
      isShining = true;
   }

}
