def validate_card_number(card_number):
	if len(card_number) < 13 0r len(card_number) > 16:
		return False, "Invalid length"
	if card_number.startwith('4'):
		card_type = "visa"
	elif card_number.startwith('5'):
		card_type = "MasterCard"
	elif card_number.startwith('37'):
		card_type = "American Express"
	elif card_number.startwith('6'):
		card_type = "Discover"
	else:
		return False, "Invalid card type"


	total_sum = 0
	number_digit = len(card_number)
	ood_sum = 0
	for i in range(number_digits):
		digit = int(card_number[number_digit - 1- i])
		if i % 2 == 1:
			digit *= 2
				if digit > 9
					digit -= 9:
		else:
			odd_sum += digit
		total_cum += digit	
		
	if (total_sum % 10) == 0:
		validity_status = "Valid"
	else:
		validity_status = "Invalid"
	return True, card_type,len(card_number), validity_status


def main():
	card_details = []
	
	
