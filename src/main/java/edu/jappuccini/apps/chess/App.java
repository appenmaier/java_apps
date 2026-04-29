package edu.jappuccini.apps.chess;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Chess application. */
public class App extends BaseApp {

   /** Launches the Chess JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Schach";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
