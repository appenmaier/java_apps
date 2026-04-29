package edu.jappuccini.apps.balls;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Balls application. */
public class App extends BaseApp {

   /** Launches the Balls JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Bälle";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
