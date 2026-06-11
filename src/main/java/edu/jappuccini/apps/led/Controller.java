package edu.jappuccini.apps.led;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

/** Controller for the LED application; drives the animation and handles button actions. */
public class Controller implements Initializable {

   @FXML
   private Circle layer1;
   @FXML
   private Circle layer2;
   @FXML
   private Circle layer3;
   @FXML
   private Circle layer4;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();

      LEDAnimationTimer timer = new LEDAnimationTimer();
      timer.start();
   }

   /** Switches the LED on. */
   @FXML
   public void switchOn(ActionEvent actionEvent) {
      model.getLED().switchOn();
   }

   /** Switches the LED off. */
   @FXML
   public void switchOff(ActionEvent actionEvent) {
      model.getLED().switchOff();
   }

   /** Cycles the LED to the next color. */
   @FXML
   public void switchColor(ActionEvent actionEvent) {
      model.getLED().switchColor();
   }

   /**
    * AnimationTimer that updates the concentric circle layers to reflect the LED state every frame.
    */
   private class LEDAnimationTimer extends AnimationTimer {

      @Override
      public void handle(long l) {
         Color color = model.getLED().getColor();
         layer1.setFill(color);
         if (model.getLED().isShining()) {
            layer2.setFill(radialGlow(color, 0.75));
            layer3.setFill(radialGlow(color, 0.5));
            layer4.setFill(radialGlow(color, 0.25));
         } else {
            layer2.setFill(Color.TRANSPARENT);
            layer3.setFill(Color.TRANSPARENT);
            layer4.setFill(Color.TRANSPARENT);
         }
      }

      private RadialGradient radialGlow(Color color, double maxOpacity) {
         return new RadialGradient(0,
               0,
               0.5,
               0.5,
               0.5,
               true,
               CycleMethod.NO_CYCLE,
               new Stop(0,
                     new Color(color.getRed(), color.getGreen(), color.getBlue(), maxOpacity)),
               new Stop(1, Color.TRANSPARENT));
      }

   }

}
