package chess;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Field extends StackPane {

  private final int row;
  private final int column;
  private boolean isSelected;

  public Field(int column, int row, Color color) {
    this.row = row;
    this.column = column;

    Rectangle background = new Rectangle(60, 60);
    background.setFill(color);
    getChildren().add(background);
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean isSelected) {
    this.isSelected = isSelected;
  }

  public void setFigure(ChessFigure figure) {
    if (getChildren().size() == 1) {
      getChildren().add(figure);
    } else {
      getChildren().set(1, figure);
    }
  }

  public ChessFigure getFigure() {
    return getChildren().size() == 2 ? (ChessFigure) getChildren().get(1) : null;
  }

  public Rectangle getRectangle() {
    return (Rectangle) getChildren().get(0);
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  @Override
  public String toString() {
    return row + "-" + column;
  }

}
