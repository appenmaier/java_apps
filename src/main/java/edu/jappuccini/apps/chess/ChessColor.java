package edu.jappuccini.apps.chess;

/** Represents the color of a chess piece (black or white). */
public enum ChessColor {

   BLACK("schwarz"), WHITE("weiss");

   private final String description;

   ChessColor(String description) {
      this.description = description;
   }

   /** Returns the German description of this color. */
   public String getDescription() {
      return description;
   }

}
