import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class SemicolonCheckoutSystem {

	public static double checkProductdetails(Scanner inputs, ArrayList<String> productDetails) {
		double subTotal = 0;
		boolean addMoreItems = true;

		while (addMoreItems) {
			System.out.println("What did the customer buy:   ");
			String productName = inputs.nextLine();
	
			System.out.println("How many Pieces:   ");
			int quantity = Integer.parseInt(inputs.nextLine());

			System.out.println("How much per unit:   ");
			double  pricePerUnit = Double.parseDouble(inputs.nextLine());

			double totalPrice = quantity * pricePerUnit;
			productDetails.add(String.format("%s\t%d\t%.2f\t%.2f", productName, quantity, pricePerUnit, totalPrice));
			subTotal += totalPrice;

			System.out.println("Add more items? (yes/no):   ");
			String response = inputs.nextLine();
			addMoreItems = response.equalsIgnoreCase("yes");
		}
		return subTotal;
	}

	private static double calculateDiscount(double subTotal, double discountPercentage) {
		return (discountPercentage / 100) * subTotal;
	}

	private static double calculateVAT(double totalAfterDiscount) {
		return 0.075 * totalAfterDiscount;
	}

	private static void displayInvoice(String customerName, String cashierName, ArrayList<String>productDetails, double subTotal, double discount, double vat, double total) {
		LocalDate currentDate = LocalDate.now();
		System.out.println("\nSemicolon Stores");
		System.out.println("Main Branch");
		System.out.println("Location: 312, HERBERT MACULAY WAY< SABO YABA< LAGOS.");
		System.out.println("TEL:  03293828343");
		System.out.println("Date:   " + currentDate);
		System.out.println("Cashier:   " + cashierName);
		System.out.println("Customer:    " + customerName);
		System.out.println("======================================================");
		System.out.println("ITEM\t\tQTY\t\tTOTAL(NGN)");


		for (int i = 0; i < productDetails.size(); i++) {
			System.out.println(productDetails.get(i));
		}

		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.printf("Subtotal:  %.2f\n", subTotal);
		System.out.printf("Discount:  %.2f\n", discount);
		System.out.printf("VAT (7.5%%):  %.2f\n", vat);
		System.out.println("=======================================================");
		System.out.printf("Total: %.2f (after applying discount and VAT)\n", total);
		System.out.println("=======================================================");
	}

	public static void printReceipt(String customerName, String cashierName, double total, double amountPaid) {
		System.out.println("\n=====================================================");
		System.out.println("Thank you for shopping with us!");
		System.out.println("Customer Name:  " + customerName);
		System.out.println("Cashier:   " + cashierName);
		System.out.println("Total Amount:   " + total);
		System.out.println("Amount Paid:    " + amountPaid);
		double change = amountPaid - total;
		if (change < 0) {	
			System.out.printf("Amount Due:  %.2f\n", -change);
		} else{
			System.out.printf("Change:  %.2f\n", change);
		}
		System.out.println("=======================================================");
	}
	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);

		System.out.println("Customer's Name Please:   ");
		String customerName = inputs.nextLine();

		System.out.println("Cashier's Name Please:   ");
		String cashierName = inputs.nextLine();

		ArrayList<String> productDetails = new ArrayList<>();
		double subTotal = checkProductdetails(inputs, productDetails);

		System.out.println("How many discount will he/she get:   ");
		int discountPercentage = Integer.parseInt(inputs.nextLine());

		double discount = calculateDiscount(subTotal, discountPercentage);
		double totalAfterDiscount = subTotal - discount;
		double vat = calculateVAT(totalAfterDiscount);
		double total = totalAfterDiscount + vat;

		displayInvoice(customerName, cashierName, productDetails, subTotal, discount, vat, total);
		
		System.out.println("How much did the customer Pay:    ");
		double amountPaid = Double.parseDouble(inputs.nextLine());

		printReceipt(customerName, cashierName, total, amountPaid);
		
	}
}