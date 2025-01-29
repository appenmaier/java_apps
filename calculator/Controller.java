package calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

   @FXML
   private TextField inputTextField;
   @FXML
   private Label outputLabel;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();
   }

   @FXML
   public void calculate(ActionEvent actionEvent) {
      String input = inputTextField.getText();

      try {
         String output = model.calculate(input);
         outputLabel.setText(output);
      } catch (InvalidInputException e) {
         Alert alert = new Alert(AlertType.ERROR,
               "Bitte eine Berechnung in der Form \"Kommazahl Operator Kommazahl\" eingeben");
         alert.show();
         outputLabel.setText("");
      }
   }

}
