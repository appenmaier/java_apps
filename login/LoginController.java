package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

   @FXML
   private TextField userNameTextField;
   @FXML
   private PasswordField passwordPasswordField;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();
   }

   @FXML
   public void login(ActionEvent actionEvent) throws IOException {
      String userName = userNameTextField.getText();
      String password = passwordPasswordField.getText();

      if (userName.equals("") || password.equals("")) {
         Alert alert = new Alert(AlertType.ERROR, "Fehlende Anmeldedaten");
         alert.show();
         return;
      }

      model = Model.getInstance();
      if (!model.setUser(userName, password)) {
         Alert alert = new Alert(AlertType.ERROR, "Fehlerhafte Anmeldedaten");
         alert.show();
         return;
      }

      Parent root = FXMLLoader.load(getClass().getResource("UserView.fxml"));
      Scene newScene = new Scene(root);
      Scene currentScene = userNameTextField.getScene();
      Stage primaryStage = (Stage) currentScene.getWindow();
      primaryStage.setScene(newScene);
      primaryStage.show();
   }

}
