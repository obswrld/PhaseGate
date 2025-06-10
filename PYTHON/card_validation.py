def validate_credit_card(card_number):
	if len(card_number) < 13 or len(card_number) > 16:
		return False, "Invalid length"
	if card_number.startswith('4'):
		card_type = "visa"
	elif card_number.startswith('5'):
		card_type = "MasterCard"
	elif card_number.startswith('37'):
		card_type = "American Express"
	elif card_number.startswith('6'):
		card_type = "Discover"
	else:
		return False, "Invalid card type"


	total_sum = 0
	number_digit = len(card_number)
	odd_sum = 0
	for i in range(number_digit):
		digit = int(card_number[number_digit - 1- i])
		if i % 2 == 1:
			digit *= 2
			if digit > 9:
				digit -= 9
		else:
			odd_sum += digit
		total_sum += digit	
		
	if (total_sum % 10) == 0:
		validity_status = "Valid"
	else:
		validity_status = "Invalid"
	return True, card_type, len(card_number), validity_status

	
def main():
	card_details = []

	print("Hello kindly Enter card details to verify")
	card_number = input("Enter credit card number:   ").strip()

	is_valid, *details = validate_credit_card(card_number)
	if is_valid:
		card_type, digit_length, validity_status = details
		card_details.append({
			"Credit Card Type": card_type,
			"Credit Card Number": card_number,
			"Credit card Digit Length": digit_length,
			"Credit Card Validity Status": validity_status
		})	
	else:
		print("Error:  ", details[0])

	if card_details:
		print("***************************************************************")
		for detail in card_details:
			for key, value in detail.items():
				print(f"***{key} : {value}")
		print("***************************************************************")

if __name__ == "__main__":
	main()


	
