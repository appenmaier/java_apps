package interest;

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
  private TextField initialCapitalTextField;
  @FXML
  private TextField interestRateTextField;
  @FXML
  private TextField runningTimeTextField;
  @FXML
  private Label interestLabel;
  private Model model;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    model = Model.getInstance();
  }

  @FXML
  public void calculateInterest(ActionEvent actionEvent) {
    double initialCapital = 0;
    double interestRate = 0;
    int runningTime = 0;

    try {
      initialCapital = Double.valueOf(initialCapitalTextField.getText());
      interestRate = Double.valueOf(interestRateTextField.getText());
      runningTime = Integer.valueOf(runningTimeTextField.getText());
    } catch (NumberFormatException e) {
      Alert alert = new Alert(AlertType.ERROR, "Bitte nur ganze Zahlen eingeben");
      alert.show();
      interestLabel.setText("");
      return;
    }

    if (initialCapital <= 0 || interestRate <= 0 || runningTime <= 0) {
      Alert alert = new Alert(AlertType.ERROR, "Bitte nur ganze Zahlen größer als Null eingeben");
      alert.show();
      interestLabel.setText("");
      return;
    }

    double interest = model.getInterest(initialCapital, interestRate, runningTime);
    interestLabel.setText(String.format("%.2f", interest));
  }

}
