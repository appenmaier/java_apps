package edu.jappuccini.apps.calculator;

/** Singleton model that parses and evaluates arithmetic expressions for the Calculator app. */
public class Model {

   private Calculator calculator;
   private static final Model INSTANCE = new Model();

   private Model() {
      calculator = new Calculator();
   }

   /** Returns the singleton instance of this model. */
   public static Model getInstance() {
      return INSTANCE;
   }

   /**
    * Parses and evaluates an arithmetic expression of the form {@code "number operator number"}.
    *
    * @param input the expression string entered by the user
    * @return the result formatted with two decimal places
    * @throws InvalidInputException if the input is null, malformed, uses an unsupported operator,
    *                               or attempts division by zero
    */
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

      if (tokens[1].isEmpty()) {
         throw new InvalidInputException();
      }
      char operator = tokens[1].charAt(0);
      if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
         throw new InvalidInputException();
      }

      if (operator == '/' && b == 0) {
         throw new InvalidInputException();
      }

      return String.format("%.2f", switch (operator) {
         case '+' -> calculator.add(a, b);
         case '-' -> calculator.subtract(a, b);
         case '*' -> calculator.multiply(a, b);
         case '/' -> calculator.divide(a, b);
         default  -> throw new AssertionError("Unexpected operator: " + operator);
      });
   }

}
