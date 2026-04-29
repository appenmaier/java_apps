package edu.jappuccini.apps.dice;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Dice application. */
public class App extends BaseApp {

   /** Launches the Dice JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Würfel";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
