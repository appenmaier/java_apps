package balls;

import javafx.scene.paint.Color;

public class Ball {

  private Color Color;
  private int r;
  private int speedX;
  private int speedY;
  private int x;
  private int y;

  public Ball(int r, int x, int y, Color color, int speedX, int speedY) {
    this.r = r;
    this.x = x;
    this.y = y;
    Color = color;
    this.speedX = speedX;
    this.speedY = speedY;
  }

  public Color getColor() {
    return Color;
  }

  public int getR() {
    return r;
  }

  public int getSpeedX() {
    return speedX;
  }

  public int getSpeedY() {
    return speedY;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void move(int minX, int minY, int maxX, int maxY) {
    x += speedX;
    y += speedY;
    if (x < minX) {
      x = minX;
      speedX = -speedX;
    }
    if (x + 2 * r > maxX) {
      x = maxX - 2 * r;
      speedX = -speedX;
    }
    if (y < minY) {
      y = minY;
      speedY = -speedY;
    }
    if (y + 2 * r > maxY) {
      y = maxY - 2 * r;
      speedY = -speedY;
    }
  }

}
