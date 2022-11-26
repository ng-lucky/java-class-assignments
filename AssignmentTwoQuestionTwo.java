import java.util.Scanner;

public class AssignmentTwoQuestionTwo {
    public static void main(String[] args) {
        Scanner display = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = display.next();
        System.out.println("Enter number of hours worked:");
        double hoursWorked = display.nextDouble();
        payRoll(name, hoursWorked);
    }
    private static void payRoll(String employeeName, double numberOfHoursworked) {
        double hourlyRate = 14.88;
        double grossSalary = hourlyRate * numberOfHoursworked;
        double belowThresholdPernalty = 0;
        // This is the 30% reduction in salaries of employees accross board
        // This has to be non-taxable to avoid further decline in employee's salary
        double payCut = grossSalary * 0.30;
        double grossSalaryAfterPayCut = grossSalary - payCut;
        double grossSalaryAfterPenalty = grossSalaryAfterPayCut;


        if (numberOfHoursworked < 170) {
            // Deducting 5% from employee's salary if the employee doesn't meet the
            // 170 hours threshold
            belowThresholdPernalty = grossSalaryAfterPayCut * 0.05;
            grossSalaryAfterPenalty = grossSalaryAfterPayCut - belowThresholdPernalty;
        }

        // Calculating the current income tax percentage of 50% reduction
        double currentIncomeTaxRate = 15 * 0.5;
        // Calculating income tax at current rate
        double incomeTaxAmount = grossSalaryAfterPenalty * (currentIncomeTaxRate / 100);
        // Calculating total deductions
        double totalDeductions = payCut + belowThresholdPernalty + incomeTaxAmount;
        double netSalary = grossSalaryAfterPenalty - incomeTaxAmount;


        // Printing the payroll information on screen
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf(" Payroll%n");
        System.out.printf(" Employee Name: %s %n", employeeName);
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-60s | %-25s | %-15s |%n", "PAYROLL ITEM", "DEDUCTIONS (GHS)", "AMOUNT (GHS)");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-60s | %-25s | %-15.2f |%n",    "Basic Salary (" + numberOfHoursworked + " hours * GHS " + hourlyRate + "", 0, grossSalary);
        System.out.printf("| %-60s | %-25.2f | %-15s |%n",   "30% Pay cut",   payCut, 0);
        System.out.printf("| %-60s | %-25.2f | %-15s |%n", "5% Penalty", belowThresholdPernalty, 0);
        System.out.printf("| %-60s | %-25.2f | %-15.2f |%n", currentIncomeTaxRate + "% Income Tax", incomeTaxAmount, totalDeductions);
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-60s | %-25s | %-15.2f |%n", "Net Salary", 0, netSalary);
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");

    }

}
