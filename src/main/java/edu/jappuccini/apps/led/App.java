package edu.jappuccini.apps.led;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the LED application. */
public class App extends BaseApp {

   /** Launches the LED JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "LED";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
