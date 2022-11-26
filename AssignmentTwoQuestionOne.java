import java.text.DecimalFormat;
import java.util.Scanner;


public class AssignmentTwoQuestionOne {
    public  enum CUSTOMER_TYPE {
        NA, DOMESTIC, INDUSTRIAL, COMMERCIAL
    }
    public static void main(String[] args) {
        Scanner display = new Scanner(System.in);
        String customerName = "";
        double previousMeterReading = 0;
        double currentMeterReading = 0;
        double qtyOfElectricityConsumed = 0;


        // Part A
        System.out.print("Enter your name: ");
        customerName = display.next();
        System.out.print("Enter previous meter reading (in kwh): ");
        previousMeterReading = display.nextDouble();
        System.out.print("Enter current meter reading (in kwh): ");
        currentMeterReading = display.nextDouble();

        // Part B
        qtyOfElectricityConsumed = currentMeterReading - previousMeterReading;
        CUSTOMER_TYPE customerType = GetCustomerType(qtyOfElectricityConsumed);

        // Part C and D
        double amountToPay = CalculateAmountToPay(qtyOfElectricityConsumed, customerType);
        double utilityCharges = amountToPay * 0.02;
        double totalAmountToPay = amountToPay + utilityCharges;

        System.out.println("***************** Customer Information **********************");
        System.out.println(String.format("Customer Name:\t %s", customerName));
        System.out.println(String.format("Customer Type:\t %s", customerType));
        System.out.println("**************** Meter Readings *****************************");
        System.out.println(String.format("Previous Meter Reading:\t %s kwh", previousMeterReading));
        System.out.println(String.format("Current Meter Reading:\t %s kwh", currentMeterReading));
        System.out.println(String.format("Quantity Consumed:\t %s kwh", qtyOfElectricityConsumed));
        System.out.println("**************** Billing Information *****************************");
        System.out.println(String.format("Amount Payable Before Charges:\t GHS%s", amountToPay));
        System.out.println(String.format("Utility Charges:\t GHS%s", utilityCharges));
        System.out.println(String.format("Amount Payable After Charges:\t GHS%s", totalAmountToPay));
        System.out.println("**************** Thank You! *****************************");


    }

    /**
     * Get customer type
     * @param qtyOfElectricityConsumed Customer's electricity consumed
     * @return an instance of CUSTOMER_TYPE enumerator
     */
    private static CUSTOMER_TYPE GetCustomerType(double qtyOfElectricityConsumed) {
        if (qtyOfElectricityConsumed <= 100) {
            return CUSTOMER_TYPE.DOMESTIC;
        }
        else if (qtyOfElectricityConsumed > 100 && qtyOfElectricityConsumed <= 200) {
            return CUSTOMER_TYPE.INDUSTRIAL;
        }
        else if (qtyOfElectricityConsumed > 200) {
            return CUSTOMER_TYPE.COMMERCIAL;
        }
        return CUSTOMER_TYPE.NA;
    }

    /**
     * Calculate a customer's bill to pay based on customer type and quantity of electricity consumed
     * @param qtyOfElectricityConsumed Quantity of electricity consumed
     * @param customerType Customer type (DOMESTIC, INDUSTRIAL, OR COMMERCIAL)
     * @return Calculated amount to pay
     */
    private static double CalculateAmountToPay(double qtyOfElectricityConsumed, CUSTOMER_TYPE customerType) {
        // Part C
        double amountToPay = 0;
        double discountedBill = 0;
        double billAfterDiscount = 0;
        double qtyAfterDiscount = 0;

        switch (customerType) {
            case DOMESTIC:
                qtyAfterDiscount = qtyOfElectricityConsumed - 60;
                discountedBill = (qtyAfterDiscount > 0) ? 60 * 0.3 : qtyOfElectricityConsumed * 0.3;
                billAfterDiscount = (qtyAfterDiscount > 0) ? qtyAfterDiscount * 0.5 : 0;
                break;
            case INDUSTRIAL:
                qtyAfterDiscount = qtyOfElectricityConsumed - 120;
                discountedBill = (qtyAfterDiscount > 0) ? 120 * 0.5 : qtyOfElectricityConsumed * 0.5;
                billAfterDiscount = (qtyAfterDiscount > 0) ? qtyAfterDiscount * 0.75 : 0;
                break;
            case COMMERCIAL:
                qtyAfterDiscount = qtyOfElectricityConsumed - 201;
                discountedBill = (qtyAfterDiscount > 0) ? 201 * 0.9 : qtyOfElectricityConsumed * 0.9;
                billAfterDiscount = (qtyAfterDiscount > 0) ? qtyAfterDiscount * 1.5 : 0;
                break;
        }
        amountToPay = discountedBill + billAfterDiscount;
        return amountToPay;
    }
}
