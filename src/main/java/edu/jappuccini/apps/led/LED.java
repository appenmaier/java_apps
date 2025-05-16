package edu.jappuccini.apps.led;

import javafx.scene.paint.Color;

public class LED {

   private Color color;
   private boolean isShining;

   public LED() {
      color = Color.RED;
   }

   public Color getColor() {
      return color;
   }

   public boolean isShining() {
      return isShining;
   }

   public void switchColor() {
      color = color.equals(Color.RED) ? Color.GREEN
            : color.equals(Color.GREEN) ? Color.BLUE : Color.RED;
   }

   public void switchOff() {
      isShining = false;
   }

   public void switchOn() {
      isShining = true;
   }

}
