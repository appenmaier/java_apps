package edu.jappuccini.apps.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/** Controller for the user view; displays a personalised greeting for the logged-in user. */
public class UserController implements Initializable {

   @FXML
   private Label greetingsLabel;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();
      User user = model.getUser();
      greetingsLabel.setText("Hallo " + user.getFirstName() + " " + user.getFamilyName());
   }

}
