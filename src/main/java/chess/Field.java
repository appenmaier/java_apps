package chess;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Field extends StackPane {

   private final int row;
   private final char column;
   private boolean isSelected;

   public Field(int row, char column, Color color) {
      this.row = row;
      this.column = column;

      Rectangle backgroundLayer = new Rectangle(60, 60);
      backgroundLayer.setFill(color);
      getChildren().add(backgroundLayer);
   }

   public boolean isSelected() {
      return isSelected;
   }

   public void setSelected(boolean isSelected) {
      this.isSelected = isSelected;
   }

   public void setFigure(ChessFigure figure) {
      if (figure == null) {
         getChildren().remove(1);
      } else if (getChildren().size() == 2) {
         getChildren().set(1, figure);
      } else {
         getChildren().add(figure);
      }
   }

   public ChessFigure getFigure() {
      return getChildren().size() == 2 ? (ChessFigure) getChildren().get(1) : null;
   }

   public Rectangle getBackgroundLayer() {
      return (Rectangle) getChildren().get(0);
   }

   public int getRow() {
      return row;
   }

   public char getColumn() {
      return column;
   }

   @Override
   public String toString() {
      return column + "" + row;
   }

}
