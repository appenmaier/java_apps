package edu.jappuccini.apps.chess;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;

/** Controller for the Chess application; handles piece selection and movement. */
public class Controller implements Initializable {

   @FXML
   private ChessBoard board;
   private Field oldField;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      for (Field lines[] : board.getFields()) {
         for (Field field : lines) {
            field.setOnMouseClicked(new FieldClickedEventHandler());
         }
      }
   }

   /** Event handler that manages piece selection, moves, and captures on click. */
   private class FieldClickedEventHandler implements EventHandler<MouseEvent> {

      @Override
      public void handle(MouseEvent event) {
         Field newField = (Field) event.getSource();
         ChessFigure oldFigure = oldField == null ? null : oldField.getFigure();
         ChessFigure newFigure = newField.getFigure();
         boolean oldFieldIsNull = oldField == null;
         boolean newFieldIsEmpty = newField.getFigure() == null;

         if (oldFieldIsNull && !newFieldIsEmpty) {
            setHighlight(newField, true);
            oldField = newField;
            return;
         }

         if (!oldFieldIsNull && oldField == newField) {
            setHighlight(newField, false);
            oldField = null;
            return;
         }

         if (!oldFieldIsNull && oldFigure == null) {
            setHighlight(oldField, false);
            oldField = null;
            return;
         }

         if (!oldFieldIsNull && !newFieldIsEmpty
               && newFigure.getColor().equals(oldFigure.getColor())) {
            setHighlight(oldField, false);
            setHighlight(newField, true);
            oldField = newField;
            return;
         }

         if (!oldFieldIsNull && !newFieldIsEmpty
               && !newFigure.getColor().equals(oldFigure.getColor())) {
            System.out.println(oldFigure + " zieht von " + oldField + " auf " + newField
                  + " und schlaegt " + newFigure);
            oldField.setFigure(null);
            newField.setFigure(oldFigure);
            setHighlight(oldField, false);
            oldField = null;
            return;
         }

         if (!oldFieldIsNull && newFieldIsEmpty) {
            System.out.println(oldFigure + " zieht von " + oldField + " auf " + newField);
            oldField.setFigure(null);
            newField.setFigure(oldFigure);
            setHighlight(oldField, false);
            oldField = null;
            return;
         }
      }

   }

   /**
    * Applies or removes a brightness highlight on the given field.
    *
    * @param field     the field to highlight
    * @param highlight {@code true} to highlight, {@code false} to clear
    */
   private void setHighlight(Field field, boolean highlight) {
      if (highlight) {
         field.getBackgroundLayer().setEffect(new ColorAdjust(0, 0, 0.5, 0));
      } else {
         field.getBackgroundLayer().setEffect(new ColorAdjust(0, 0, 0, 0));
      }
   }

}
