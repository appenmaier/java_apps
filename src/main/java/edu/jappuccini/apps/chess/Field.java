package edu.jappuccini.apps.chess;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** A single square on the chess board, identified by column letter and row number. */
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

   /** Returns {@code true} if this field is currently highlighted as selected. */
   public boolean isSelected() {
      return isSelected;
   }

   /** Sets the selection state of this field. */
   public void setSelected(boolean isSelected) {
      this.isSelected = isSelected;
   }

   /**
    * Places the given figure on this field, or removes the current figure when {@code null}.
    */
   public void setFigure(ChessFigure figure) {
      if (figure == null) {
         if (getChildren().size() > 1) {
            getChildren().remove(1);
         }
      } else if (getChildren().size() == 2) {
         getChildren().set(1, figure);
      } else {
         getChildren().add(figure);
      }
   }

   /** Returns the figure on this field, or {@code null} if the field is empty. */
   public ChessFigure getFigure() {
      return getChildren().size() == 2 ? (ChessFigure) getChildren().get(1) : null;
   }

   /** Returns the background rectangle that represents the field color. */
   public Rectangle getBackgroundLayer() {
      return (Rectangle) getChildren().get(0);
   }

   /** Returns the row number (1–8) of this field. */
   public int getRow() {
      return row;
   }

   /** Returns the column letter (A–H) of this field. */
   public char getColumn() {
      return column;
   }

   @Override
   public String toString() {
      return column + "" + row;
   }

}
