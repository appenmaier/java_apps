package calculator;

public class Model {

  private Calculator calculator;
  private static Model instance;

  private Model() {
    calculator = new Calculator();
  }

  public static Model getInstance() {
    if (instance == null) {
      instance = new Model();
    }
    return instance;
  }

  public String calculate(String input) throws InvalidInputException {
    if (input == null) {
      throw new InvalidInputException();
    }

    String[] tokens = input.split(" ");
    if (tokens.length != 3) {
      throw new InvalidInputException();
    }

    double a, b = 0;
    try {
      a = Double.valueOf(tokens[0].replace(",", "."));
      b = Double.valueOf(tokens[2].replace(",", "."));
    } catch (NumberFormatException e) {
      throw new InvalidInputException();
    }

    char operator = tokens[1].charAt(0);
    if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
      throw new InvalidInputException();
    }

    return String.format("%.2f", switch (operator) {
      case '+' -> calculator.add(a, b);
      case '-' -> calculator.subtract(a, b);
      case '*' -> calculator.multiply(a, b);
      case '/' -> calculator.divide(a, b);
      default -> "";
    });
  }

}
