package io;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputController implements Initializable {

   @FXML
   private TextField valueTextField;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();
   }

   @FXML
   public void goToOutput(ActionEvent actionEvent) throws IOException {
      String value = valueTextField.getText();
      model.setValue(value);

      Parent root = FXMLLoader.load(getClass().getResource("OutputView.fxml"));
      Scene scene = new Scene(root);
      Node node = (Node) actionEvent.getSource();
      Stage stage = (Stage) node.getScene().getWindow();
      stage.setScene(scene);
      stage.show();
   }

}
