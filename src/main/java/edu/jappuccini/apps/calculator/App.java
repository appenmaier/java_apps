package edu.jappuccini.apps.calculator;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Calculator application. */
public class App extends BaseApp {

   /** Launches the Calculator JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Taschenrechner";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
