package led;

public class Model {

  private LED led;
  private static Model instance;

  private Model() {
    led = new LED();
  }

  public static Model getInstance() {
    if (instance == null) {
      instance = new Model();
    }
    return instance;
  }

  public LED getLED() {
    return led;
  }

}
