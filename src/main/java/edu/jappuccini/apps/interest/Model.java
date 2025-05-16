package edu.jappuccini.apps.interest;

public class Model {

   private static Model instance;

   private Model() {}

   public static Model getInstance() {
      if (instance == null) {
         instance = new Model();
      }
      return instance;
   }

   public double getInterest(double initialCapital, double interestRate, int runningTime) {
      return initialCapital * Math.pow((1 + interestRate / 100), runningTime) - initialCapital;
   }

}
