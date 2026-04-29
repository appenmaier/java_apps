package edu.jappuccini.apps.hexagons;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Hexagons application. */
public class App extends BaseApp {

   /** Launches the Hexagons JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Hexagons";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
