package chess;

public enum ChessColor {

  BLACK("schwarz"), WHITE("weiß");

  private String description;

  ChessColor(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
