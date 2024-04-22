package io;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class OutputController implements Initializable {

  @FXML
  private Label valueLabel;
  Model model;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    model = Model.getInstance();

    String value = model.getValue();
    valueLabel.setText(value);
  }

}
