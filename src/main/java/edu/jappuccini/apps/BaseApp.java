package edu.jappuccini.apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Abstract base class for all JavaFX applications in this project. */
public abstract class BaseApp extends Application {

   /** Returns the window title for this application. */
   protected abstract String getTitle();

   /** Returns the FXML file name used to load the UI for this application. */
   protected abstract String getFxmlName();

   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource(getFxmlName()));
      primaryStage.setTitle(getTitle());
      primaryStage.setScene(new Scene(root));
      primaryStage.setResizable(false);
      primaryStage.show();
   }

}
