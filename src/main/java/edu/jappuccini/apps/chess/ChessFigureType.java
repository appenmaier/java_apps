package edu.jappuccini.apps.chess;

/** Represents the type of a chess piece. */
public enum ChessFigureType {

   BISHOP("Laeufer"), KING("Koenig"), KNIGHT("Springer"), PAWN("Bauer"), QUEEN("Dame"), ROOK(
         "Turm");

   private final String description;

   ChessFigureType(String description) {
      this.description = description;
   }

   /** Returns the German description of this figure type. */
   public String getDescription() {
      return description;
   }

}
