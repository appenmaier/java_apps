package edu.jappuccini.apps.dice;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
      Scene scene = new Scene(root);
      primaryStage.setTitle("Würfel");
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();
   }

}
