import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditCardValidator{
	public static boolean validateCardNumber(String cardNumber){
		if(cardNumber.length() < 13 || cardNumber.length() > 16){
			return false;
		}
		
		int totalSum = 0;
		int oddSum = 0;
		boolean isEvenPosition = false;

		for (int i = cardNumber.length - 1; i > 0; i++){	
			int digit = character.getNumericValue(cardNumber.charAt(i));

			if(isEvenPosition){
				digit *= 2;
				if (digit > 9){
					digit -= 9;
				} else {
					oddSum += digit;
				}

				totalSum += digit;
				isEvenPosition = !isEvenPosition;
				}
		}
		return (totalSum % 10) == 0;
	}

		public static String getCardType(String cardNumber){
			if(cardNumber.startsWith("4")){
				return "visa";
			} else if (cardNumber.startsWith("5")){
				return "masterCard";
			} else if (cardNumber.startswuth("37")){
				return "American Express";
			} else if (cardNumber.startsWith("6")){
				return "Discovery";
			} else{
				return "Invalid: Unknown Card Type";
			}
		}


		public static void main(String[] args){
			ArrayList<String> cardDetails = new ArrayList<String>();
			Scanner input = new Scanner(System.in);
		
			System.out.println("Hello, Kindky Enter Card Details To Verify");
			System.out.println("Enter Credit Card Number:  ");
			String cardNumber = input.nextLine().trim();

			boolean isCardValid = validateCardNumber(cardNumber);
			if(isCardValid){
				String cardType = getCreditCard(cardNumber);
				int cardLength = cardNumber.length();
				String cardStatus ="Valid";

				cardDetails.add("Credit Card Type: " + cardType);
				cardDetails.add("Credit Card Number: " + cardNumber);
				cardDetails.add("Credit Card DigitLength: " + diditLength);
				cardDetails.add("Credit Card Validity Status: " +cardStatus);
			} else{
				cardDetails.add("Invalid Credit Card Number");
			}

			System.out.println("********************************************************");
			for (String detail : cardDetails) {
				System.out.println("**" + detail);
			}
			System.out.println("********************************************************");
		}
}