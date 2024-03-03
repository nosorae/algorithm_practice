package godofjava.a;

// GodOfJava Vol1. 5장
public class SalaryManager {
    private final double salaryTax = 12.5;
    private final double nationalPension = 8.1;
    private final double healthInsurance = 13.5;

    public static void main(String[] args) {
        SalaryManager salaryManager = new SalaryManager();
        System.out.println(salaryManager.getMonthlySalary(90_000_000));
    }

    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;
        double salaryTaxResult = calculateTax(monthlySalary);
        double nationalPensionResult = calculateNationalPension(monthlySalary);
        double healthInsuranceResult = calculateHealthInsurance(monthlySalary);
        double totalDeduction = salaryTaxResult + nationalPensionResult + healthInsuranceResult;
        monthlySalary -= totalDeduction;
        return monthlySalary;
    }

    public double calculateTax(double monthlySalary) {
        double tax = monthlySalary * (salaryTax / 100);
        System.out.println("근로소득세 : " + tax);
        return tax;
    }

    public double calculateNationalPension(double monthlySalary) {
        double tax  = monthlySalary * (nationalPension / 100);
        System.out.println("국민연금 공제 : " + tax);
        return tax;
    }

    public double calculateHealthInsurance(double monthlySalary) {
        double tax =  monthlySalary * (healthInsurance / 100);
        System.out.println("건강 보험료 공제 : " +  tax);
        return tax;
    }
}
