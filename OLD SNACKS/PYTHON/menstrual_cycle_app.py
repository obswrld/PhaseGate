from datetime import datetime, timedelta

def calculate_next_period_date(last_period_date, cycle_length):
	return last_period_date + timedelta(days=cycle_length)

def calculate_ovulation_date(last_period_date):
	return last_period_date + timedelta(days=14)

def is_cycle_length_valid(cycle_length):
	return 21 <= cycle_length <= 35

def is_period_length_valid(period_length):
	return 3 <= period_length <= 7

def get_valid_date():
	while True:
		last_period_input = input("Enter the date of the last period (YYYY-MM-DD):   ")
		try:
			return datetime.strptime(last_period_input,  "%Y-%m-%d").date()
		except ValueError:
			print("Error: Invalid date format. Please use the YYYY-MM-DD.")

def main():
	name = input("Enter your name:  ")

	while True: 
		cycle_length = int(input("Enter cycle length (days):    "))
		if is_cycle_length_valid(cycle_length):
			break
		else:
			print("Error: cycle length must be between 21 and 35 days. If this is not the case. Please see the doctor for treatment. Please try again:   ")

	while True:
		period_length = int(input("Enter period length (days):   "))
		if is_period_length_valid(period_length):
			break
		else:
			print("Error: Period length must be between 3 and 7 days. If this is not the case. Please see the doctor for treatment. Please try again:     ")

	last_period_date = get_valid_date()
	next_period_date = calculate_next_period_date(last_period_date, cycle_length)
	ovulation_date = calculate_ovulation_date(last_period_date)
	safe_period_start = last_period_date + timedelta(days=period_length + 1)
	safe_period_end = ovulation_date - timedelta(days=1)

	print(f"Hello,  {name}!")
	print(f"Your next period is expected on:  {next_period_date}")
	print(f"Your ovulation date is expected on:  {ovulation_date}")
	print(f"Your safe period is from:  {safe_period_start} to {safe_period_end}")

if __name__ == "__main__":
	main()
