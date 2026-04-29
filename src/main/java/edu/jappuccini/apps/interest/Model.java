package edu.jappuccini.apps.interest;

/** Singleton model that performs compound interest calculations for the Interest app. */
public class Model {

   private static final Model INSTANCE = new Model();

   private Model() {}

   /** Returns the singleton instance of this model. */
   public static Model getInstance() {
      return INSTANCE;
   }

   /**
    * Calculates the compound interest earned over the given period.
    *
    * @param initialCapital the starting amount
    * @param interestRate   the annual interest rate in percent
    * @param runningTime    the number of years
    * @return the interest earned (final capital minus initial capital)
    */
   public double getInterest(double initialCapital, double interestRate, int runningTime) {
      return initialCapital * Math.pow((1 + interestRate / 100), runningTime) - initialCapital;
   }

}
