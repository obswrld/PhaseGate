from datetime import datetime

product_details = []
subtotal = 0.0

def input_product_details():
	global subtotal
	while True:
		product_name = input("What did the customer buy:   ")
		quantity = int(input("How many pieces:   "))
		price_per_unit = float(input("How much per unit:   "))
		
		total_price = quantity * price_per_unit
		product_details.append(f"{product_name}\t{quantity}\t{price_per_unit: .2f}\t{total_price: .2f}")
		subtotal += total_price


		response = input("Add more itmes? (yes/n0):   ")
		if response.lower() != "yes":
			break

def calculate_discount(discount_percentage):
	return (discount_percentage / 100) * subtotal

def calculate_vat(total_after_discount):
	return 0.075 * total_after_discount

def display_invoice(customer_name, cashier_name):
	print("\nSemicolon Stores")
	print("Main branch")
	print("Location: 312, HERBERT MACULAY WAY, SABO YABA, LAGOS.")
	print("TEL:   03293828343")
	print("DATE:  ", get_current_date())
	print("Cashier:   ", cashier_name)
	print("Customer Name:   ", customer_name)
	print("===========================================")
	print("ITEM\t\tPRICE\t\tTOTAL(NGN)")

	for detail in product_details:
		print(detail)

	print("------------------------------------------------------------------------------")
	print(f"Subtotal:   {subtotal: .2f}")
	discount_percentage = float(input("how much discount will he get:   "))
	discount = calculate_discount(discount_percentage)
	print(f"Discount:   {discount: .2f}")
	total_after_discount = subtotal - discount
	vat = calculate_vat(total_after_discount)
	print(f"VAT (7.5%):   {vat: .2f}")
	total = total_after_discount + vat
	print("==========================================")
	print(f"Total:   {total: .2f} (after applying discount and VAT)")
	print("==========================================")
	return total

def print_receipt(customer_name, cashier_name, total):
	amount_paid = float(input("How much did the customer pay:   "))
	print("\n=============== RECEIPT ===================")
	print("Thank you for shopping with us!")
	print("Customer name:   ", customer_name)
	print("Cashier's name:    ", cashier_name)
	print("Total Amount:    ", total)
	print("Amount Paid:    ", amount_paid)
	change = amount_paid - total
	if change < 0:
		print(f"Amount Due:   {-change: .2f}")
	else: 
		print(f"Change: {change: .2f}")
	print("===========================================")

def get_current_date():
	return datetime.now().strftime("%y-%m-%d")

if __name__ == "__main__":
	customer_name = input("What is the customer's name:    ")
	cashier_name = input("What is the cashier name:    ")
	
	input_product_details()
	total = display_invoice(customer_name, cashier_name)
	print_receipt(customer_name, cashier_name, total)
	
	