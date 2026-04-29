package edu.jappuccini.apps.interest;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Interest Calculator application. */
public class App extends BaseApp {

   /** Launches the Interest Calculator JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Zinsrechner";
   }

   @Override
   protected String getFxmlName() {
      return "View.fxml";
   }

}
