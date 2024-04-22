package chess;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {

  @FXML
  private BorderPane root;
  private Field selectedField;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ChessBoard board = new ChessBoard();
    root.getChildren().add(board);

    for (Field lines[] : board.getFields()) {
      for (Field field : lines) {
        field.setOnMouseClicked(new OnMouseClickedEventHandler());
      }
    }
  }

  public class OnMouseClickedEventHandler implements EventHandler<Event> {

    @Override
    public void handle(Event event) {
      Field field = (Field) event.getSource();

      boolean isSelectedField = selectedField == null ? true : false;
      boolean isEmptyField = field.getFigure() == null ? true : false;

      if (isSelectedField && !isEmptyField) {
        selectedField = field;
        field.getRectangle().setEffect(new ColorAdjust(0, 0, 0.5, 0));
        return;
      }

      if (!isSelectedField && selectedField == field) {
        selectedField = null;
        field.getRectangle().setEffect(new ColorAdjust(0, 0, 0, 0));
        return;
      }

      if (!isSelectedField && !isEmptyField
          && !field.getFigure().getColor().equals(selectedField.getFigure().getColor())) {
        ChessFigure figure = selectedField.getFigure();
        System.out.println(figure + " zieht von " + selectedField + " auf " + field
            + " und schlaegt " + field.getFigure());
        selectedField.getChildren().remove(1);
        field.setFigure(figure);
        selectedField.getRectangle().setEffect(new ColorAdjust(0, 0, 0, 0));
        selectedField = null;
        return;
      }

      if (!isSelectedField && isEmptyField) {
        System.out
            .println(selectedField.getFigure() + " zieht von " + selectedField + " auf " + field);
        ChessFigure figure = selectedField.getFigure();
        selectedField.getChildren().remove(1);
        field.setFigure(figure);
        selectedField.getRectangle().setEffect(new ColorAdjust(0, 0, 0, 0));
        selectedField = null;
        return;
      }
    }

  }

}
