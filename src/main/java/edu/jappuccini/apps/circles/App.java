package edu.jappuccini.apps.circles;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Circles application. */
public class App extends BaseApp {

   /** Launches the Circles JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Kreise";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
