package led;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller implements Initializable {

  @FXML
  private Circle layer1;
  @FXML
  private Circle layer2;
  @FXML
  private Circle layer3;
  @FXML
  private Circle layer4;
  private Model model;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    model = Model.getInstance();

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long l) {
        Color color = model.getLED().getColor();
        layer1.setFill(color);
        if (model.getLED().isShining()) {
          layer2.setFill(new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.75));
          layer3.setFill(new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.5));
          layer4.setFill(new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.25));
        } else {
          layer2.setFill(Color.TRANSPARENT);
          layer3.setFill(Color.TRANSPARENT);
          layer4.setFill(Color.TRANSPARENT);
        }
      }
    };
    timer.start();
  }

  @FXML
  public void switchOn(ActionEvent actionEvent) {
    model.getLED().switchOn();
  }

  @FXML
  public void switchOff(ActionEvent actionEvent) {
    model.getLED().switchOff();
  }

  @FXML
  public void switchColor(ActionEvent actionEvent) {
    model.getLED().switchColor();
  }

}
