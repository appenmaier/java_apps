package edu.jappuccini.apps.login;

import edu.jappuccini.apps.BaseApp;
import javafx.application.Application;

/** Entry point for the Login application. */
public class App extends BaseApp {

   /** Launches the Login JavaFX application. */
   public static void main(String[] args) {
      Application.launch(App.class, args);
   }

   @Override
   protected String getTitle() {
      return "Login";
   }

   @Override
   protected String getFxmlName() {
      return "LoginView.fxml";
   }

}
