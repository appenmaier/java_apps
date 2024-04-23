package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessFigure extends ImageView {

  private final ChessColor color;
  private final ChessFigureType type;

  ChessFigure(ChessFigureType type, ChessColor color, Image image) {
    this.type = type;
    this.color = color;

    super.setImage(image);
  }

  public ChessColor getColor() {
    return color;
  }

  public ChessFigureType getType() {
    return type;
  }

  @Override
  public String toString() {
    return color.getDescription() + (type.equals(ChessFigureType.QUEEN) ? "e " : "er ")
        + type.getDescription();
  }

}
