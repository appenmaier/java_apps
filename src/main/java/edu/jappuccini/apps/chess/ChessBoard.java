package edu.jappuccini.apps.chess;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ChessBoard extends GridPane {

   private final Field[][] fields;

   public ChessBoard() {
      fields = new Field[8][8];

      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            Color color = i % 2 == 0 ? j % 2 == 0 ? Color.SANDYBROWN : Color.SADDLEBROWN
                  : j % 2 == 0 ? Color.SADDLEBROWN : Color.SANDYBROWN;
            Field s = new Field(j + 1, (char) (i + 65), color);
            add(s, i, j);
            fields[i][j] = s;
         }
      }

      fields[0][0].setFigure(new ChessFigure(ChessFigureType.ROOK,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("rook_white.png"))));
      fields[1][0].setFigure(new ChessFigure(ChessFigureType.KNIGHT,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("knight_white.png"))));
      fields[2][0].setFigure(new ChessFigure(ChessFigureType.BISHOP,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("bishop_white.png"))));
      fields[3][0].setFigure(new ChessFigure(ChessFigureType.KING,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("king_white.png"))));
      fields[4][0].setFigure(new ChessFigure(ChessFigureType.QUEEN,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("queen_white.png"))));
      fields[5][0].setFigure(new ChessFigure(ChessFigureType.BISHOP,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("bishop_white.png"))));
      fields[6][0].setFigure(new ChessFigure(ChessFigureType.KNIGHT,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("knight_white.png"))));
      fields[7][0].setFigure(new ChessFigure(ChessFigureType.ROOK,
            ChessColor.WHITE,
            new Image(getClass().getResourceAsStream("rook_white.png"))));
      for (int i = 0; i < 8; i++) {
         fields[i][1].setFigure(new ChessFigure(ChessFigureType.PAWN,
               ChessColor.WHITE,
               new Image(getClass().getResourceAsStream("pawn_white.png"))));
      }

      fields[0][7].setFigure(new ChessFigure(ChessFigureType.ROOK,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("rook_black.png"))));
      fields[1][7].setFigure(new ChessFigure(ChessFigureType.KNIGHT,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("knight_black.png"))));
      fields[2][7].setFigure(new ChessFigure(ChessFigureType.BISHOP,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("bishop_black.png"))));
      fields[3][7].setFigure(new ChessFigure(ChessFigureType.KING,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("king_black.png"))));
      fields[4][7].setFigure(new ChessFigure(ChessFigureType.QUEEN,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("queen_black.png"))));
      fields[5][7].setFigure(new ChessFigure(ChessFigureType.BISHOP,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("bishop_black.png"))));
      fields[6][7].setFigure(new ChessFigure(ChessFigureType.KNIGHT,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("knight_black.png"))));
      fields[7][7].setFigure(new ChessFigure(ChessFigureType.ROOK,
            ChessColor.BLACK,
            new Image(getClass().getResourceAsStream("rook_black.png"))));
      for (int i = 0; i < 8; i++) {
         fields[i][6].setFigure(new ChessFigure(ChessFigureType.PAWN,
               ChessColor.BLACK,
               new Image(getClass().getResourceAsStream("pawn_black.png"))));
      }

   }

   public Field[][] getFields() {
      return fields;
   }

}
