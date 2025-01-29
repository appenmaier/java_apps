package chess;

public enum ChessFigureType {

   BISHOP("Laeufer"), KING("Koenig"), KNIGHT("Springer"), PAWN("Bauer"), QUEEN("Dame"), ROOK(
         "Turm");

   private final String description;

   ChessFigureType(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }

}
