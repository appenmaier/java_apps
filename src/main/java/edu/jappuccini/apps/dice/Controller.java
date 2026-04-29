package edu.jappuccini.apps.dice;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** Controller for the Dice application; shows a dice face and re-rolls on button click. */
public class Controller implements Initializable {

   @FXML
   private ImageView diceImageView;
   private Model model;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      model = Model.getInstance();

      model.rollTheDice();
      Image diceImage = model.getDiceImage();
      diceImageView.setImage(diceImage);
   }

   /** Rolls the die and updates the displayed image. */
   @FXML
   public void rollTheDice(ActionEvent actionEvent) {
      model.rollTheDice();
      Image diceImage = model.getDiceImage();
      diceImageView.setImage(diceImage);
   }

}
