const prompt = require("Prompt-sync")();
let productDetails = [] 
let subtotal = 0.0

function inputProductDetails() {
	while (true) {
		const productName = prompt("What did the customer buy:   ");
		const quantity = prompt("How many pieces:   ");
		const pricePerUnit = parseFloat(prompt("How many per unit:   "));

		const totalPrice = quantity * pricePerUnit;

		productDetails.push(`${productName}\t${quantity}\t${pricePerUnit.toFixed(2)}\t${totalPrice.toFixed(2)}`);
		subtotal += totalPrice;

		const response = prompt("Add more items? (yes/no):    ");
		if (response.toLowerCase() !=="yes") {
			break;
		}
	}
}

function calculateDiscount(discountPercentage) {
	return (discountPercentage / 100) * subtotal;
}

function calculateVAT(totalAfterDiscount) {
	return 0.075 * totalAfterDiscount;
}

function displayInvoice(customerName, cashierName) {
	console.log("\nSemicolon Stores");
	console.log("Main Branch");
	console.log("Location: 312	, HERBERT MACULAY WAY, SABO YABA, LAGOS.");
	console.log("TEL: 03293828343");
	console.log("Date:   ", getCurrentDate());
	console.log("Cashier:   ", cashierName);
	console.log("Customer:   ", customerName);
	console.log("===========================================");
	console.log("ITEM\t\tQTY\tPRICE\t\TOTAL(NGN)");
	
	productDetails.forEach(detail => {
		console.log(detail);
	});
	
	console.log("------------------------------------------------------------------------------");
	console.log(`subtotal:   ${subtotal.toFixed(2)}`);
	const discountPercentage = parseFloat(prompt("How much discount will he/she get:   "));
	const discount = calculateDiscount(discountPercentage);
	console.log(`Discount:   ${discount.toFixed(2)}`);
	const totalAfterDiscount = subtotal - discount;
	const vat = calculateVAT(totalAfterDiscount);
	console.log(`VAT (7.5%):  ${vat.toFixed(2)}`);
	const total = totalAfterDiscount + vat;
	console.log("===========================================");
	console.log(`Total:  ${total.toFixed(2)} (after applying discount and VAT)`);
	console.log("===========================================");
	return total;
}

function printReceipt(customerName, cashierName, total) {
	const amountPaid = parseFloat(prompt("How much did the customer pay:   "));
	console.log("\n=================RECEIPT====================");
	console.log("Thank you for shopping with us!");
	console.log("Customer Name:  ", customerName);
	console.log("Cashier:   ", cashierName);
	console.log("Total Amount:   ", total.toFixed(2));
	console.log("Amount Paid    ", amountPaid.toFixed(2));
	const change = amountPaid - total;
	if (change < 0){
		console.log(`Amount Due:   ${(-change).toFixed(2)}`);
	} else {
		console.log(`change:   ${change.toFixed(2)}`);
	}
	console.log("============================================");
}

function getCurrentDate() {
	const date = new Date();
	return date.toISOString().split('T')[0];
}

const customerName = prompt("What is the Customer's Name:   ");
const cashierName = prompt("What is the Cashier's Name:    ");

inputProductDetails();
const total = displayInvoice(customerName, cashierName);
printReceipt(customerName, cashierName, total);