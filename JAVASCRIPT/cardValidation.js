const prompt = require("Prompt-sync")();
function validateCreditCard(cardNumber) {
	if (cardNumber.length < 13 || cardNumber.length > 16) {
		return {valid: false, message: "Invalid"};
	}
	let totalSum = 0
	let isEvenPosition = false;
	
	for (let i = cardNumber.length - 1; i >= 0; i--) {
		let digit = parseInt(cardNumber.charAt(i), 10);
		
		if (isEvenPosition) {
			digit *= 2;
			if (digit > 9){
				digit -= 9;
			}
		}
		totalSum += digit;
		isEvenPosition = !isEvenPosition;
	}
	return { valid: (totalSum % 10) === 0};
}

function getCardType(cardNumber) {
	if (cardNumber.startsWith("4")) {
		return "Visa";
	} else if (cardNumber.startsWith("5")) {
		return "MasterCard";
	} else if (cardNumber.startsWith("37")) {
		return "American Express";
	} else if (cardNumber.startsWith("6")) {
		return "Discover";
	} else {
		return "unknown";
	}
}

function main() {
	const cardNumber = prompt("Hello, kindly Enter card details to verify\nEnter credit card number:   ").trim();
	const validationResult = validateCreditCard(cardNumber);
	const cardType = validationResult.valid ? getCardType(cardNumber) : "Invalid";

	const cardDetails = [];
	if (validationResult.valid) {
		cardDetails.push(`Credit Card Type:  ${cardType}`);
		cardDetails.push(`Credit Card Number:  ${cardNumber}`);
		cardDetails.push(`Credit Card Digit Length:  ${cardNumber.Length}`);
		cardDetails.push(`Credit Card Validity Status:  Valid`);
	} else {
		cardDetails.push("Invalid credit card number.");
	}

	console.log("**********************************************************");
	cardDetails.forEach(detail => console.log(`**${detail}`));
	console.log("**********************************************************");	
}
main();