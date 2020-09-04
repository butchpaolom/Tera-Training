import java.text.NumberFormat;

public class Mortgage {
  private final static byte MONTHS_IN_YEAR = 12;
  private final static byte PERCENT = 100;

  private int principal;
  private float annualInterest;
  private byte years;

  public Mortgage(int principal, float annualInterest, byte years) {
    this.principal = principal;
    this.annualInterest = annualInterest;
    this.years = years;
  }

  private double calculateBalance(short numberOfPaymentsMade) {
      float monthlyInterest = this.annualInterest / PERCENT / MONTHS_IN_YEAR;
      float numberOfPayments = this.years * MONTHS_IN_YEAR;

      double balance = this.principal
              * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
              / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

      return balance;
  }

  private double calculateMortgage() {
      float monthlyInterest = this.annualInterest / PERCENT / MONTHS_IN_YEAR;
      float numberOfPayments = this.years * MONTHS_IN_YEAR;

      double mortgage = this.principal
              * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
              / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

      return mortgage;
  }

  public void printMortgage() {
      double mortgage = calculateMortgage();
      String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
      System.out.println();
      System.out.println("MORTGAGE");
      System.out.println("--------");
      System.out.println("Monthly Payments: " + mortgageFormatted);
  }

  public void printPaymentSchedule() {
      System.out.println();
      System.out.println("PAYMENT SCHEDULE");
      System.out.println("----------------");
      for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
          double balance = calculateBalance(month);
          System.out.println(NumberFormat.getCurrencyInstance().format(balance));
      }
  }
}
