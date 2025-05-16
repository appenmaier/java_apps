package edu.jappuccini.apps.chess;

public enum ChessColor {

   BLACK("schwarz"), WHITE("weiss");

   private final String description;

   ChessColor(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

}
