package edu.jappuccini.apps.chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** Represents a chess piece as an {@link ImageView} with type and color information. */
public class ChessFigure extends ImageView {

   private final ChessColor color;
   private final ChessFigureType type;

   ChessFigure(ChessFigureType type, ChessColor color, Image image) {
      this.type = type;
      this.color = color;

      super.setImage(image);
   }

   /** Returns the color of this chess piece. */
   public ChessColor getColor() {
      return color;
   }

   /** Returns the type of this chess piece. */
   public ChessFigureType getType() {
      return type;
   }

   @Override
   public String toString() {
      return color.getDescription() + (type.equals(ChessFigureType.QUEEN) ? "e " : "er ")
            + type.getDescription();
   }

}
