import java.util.Scanner;

public class AssignmentTwoQuestionThree {
    public  enum CAREER_PATH {
        SCHOOL, LEARN_TRADE, NA
    }
    public  enum EXIT_STATUS {
        YES, NO
    }
    public static void main(String[] args) {
        // This variable will be used to collect/hold the age at which an individual quits his/her career (School/Trade)
        int careerExitAge = 0;

        // This variable is used to hold/collect the investment amount Government commits to his/her career. I set default to be 100 with the
        // assumption that all are students except otherwise then I set the new value based on the career choice
        int investmentPremium = 100;

        double currentInvestmentAmount = 0;

        // This variable will be used to calculate the overall amount a user is due after investment maturity
        int investmentMaturityAmount = 0;

        // Number of investable month holds the age difference between 18 year and 30 years in period of months by
        // multiplying the age difference by 12 (months)
        // This is done on the basis of investment maturity period
        int numberOfInvestableMonths = (30 - 18) * 12;



        Scanner display = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = display.next();
        System.out.println("How old are you?:");
        int age = display.nextInt();


        // Checking to determine if to disqualify user or to allow user to proceed based on the age bracket (18-30)
        if (age < 18 || age > 30) {
            System.out.println("Sorry! You are not qualified!");
            System.out.println("Exiting now....");
            System.exit(0);
        }
        System.out.println("What do you want to do? Enter 1 for School, 2 for Trade:");
        int careerPath = display.nextInt();
        CAREER_PATH careerPathFullName = getCareerPathFullName(careerPath);
        // As mentioned earlier, I am now checking if the career path is to LEARN TRADE then I update the value to GHS 70
        if (careerPathFullName == CAREER_PATH.LEARN_TRADE) {
            investmentPremium = 70;
        }
        System.out.printf("Did you stop to %s? Enter 1 for Yes, 2 for No %n", careerPathFullName);
        int careerExitChoice = display.nextInt();

        //Setting the career exit age value should a user exit the career before completion
        if (careerExitChoice == 1) {
            System.out.printf("At what age did you stop to %s? %n", careerPathFullName);
            careerExitAge = display.nextInt();
        }


        //Getting the number of months for investments made for a user
        // The logic below shows that if a user exited before completion (which is exit age now greater than 0)
        // The invested months will now be calculated based on the exit age
        // Else the invested months will be calculated based on the user's current age
        int numberOfMonthsInvested = (careerExitAge > 0) ? (careerExitAge - 18) * 12 : (age - 18) * 12;

        // At this point, I am calculating the current investment amount value for the user assuming we do not have
        // any interest rate and also do not know whether to apply compound interest, simple interest, etc.
        currentInvestmentAmount = numberOfMonthsInvested * investmentPremium;


        //At this point, I am calculating the amount a user would have gotten at the end of the investment's maturity
        // period (Only if the user waits till the end/completion will he/she get this amount)
        investmentMaturityAmount = numberOfInvestableMonths * investmentPremium;

        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf(" Government Investment for it's citizens%n");
        System.out.printf(" Name: %s %n", name);
        System.out.printf(" Age: %s %n", age);
        System.out.printf(" Career: %s %n", careerPathFullName);
        System.out.printf(" Exited?: %s %n", getExitStatus(careerExitChoice));
        System.out.printf(" Exit Age: %s %n", careerExitAge);
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-60s | %-15s |%n", "ITEM",  "AMOUNT (GHS)");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-60s | %-15s |%n",    "Investment Premium", investmentPremium);
        System.out.printf("| %-60s | %-15.2f |%n",   "Current Amount",  currentInvestmentAmount);
        System.out.printf("| %-60s |%-15s |%n", "Maturity Value", investmentMaturityAmount);
        System.out.printf("| %-60s | %-15s |%n", "Number of Months Invested", numberOfMonthsInvested);
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-60s | %-15s |%n",   "Current Amount",  currentInvestmentAmount);
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");

    }
    private static CAREER_PATH getCareerPathFullName(int careerPathCode) {
        if (careerPathCode == 1) {
            return CAREER_PATH.SCHOOL;
        } else if (careerPathCode == 2) { return  CAREER_PATH.LEARN_TRADE; }
        return CAREER_PATH.NA;
    }
    private static EXIT_STATUS getExitStatus(int statusCode) {
        if (statusCode == 1) {
            return EXIT_STATUS.YES;
        }
        return EXIT_STATUS.NO;
    }
}
