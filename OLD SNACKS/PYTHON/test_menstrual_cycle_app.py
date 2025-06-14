import unittest
from datetime import datetime
from menstrual_cycle_app import calculate_next_period_date  
from menstrual_cycle_app import calculate_ovulation_date
from menstrual_cycle_app import is_cycle_length_valid
from menstrual_cycle_app import is_period_length_valid
from menstrual_cycle_app import get_valid_date

class TestMenstrualCycleApp(unittest.TestCase):

	def test_calculate_next_period_date(self):
		self.assertEqual(calculate_next_period_date(datetime(2025, 5, 1), 28), datetime(2025, 5, 29))
		self.assertEqual(calculate_next_period_date(datetime(2025, 5, 1), 35), datetime(2025, 6, 5)) 

	def test_calculate_ovulation_date(self):
		self.assertEqual(calculate_ovulation_date(datetime(2025, 5, 1)), datetime(2025, 5, 15))
	

	def test_is_cycle_length_valid(self):
		self.assertTrue(is_cycle_length_valid(25))
		self.assertFalse(is_cycle_length_valid(20))
		self.assertFalse(is_cycle_length_valid(36))

	def test_is_period_length_valid(self):
		self.assertTrue(is_period_length_valid(5))
		self.assertFalse(is_period_length_valid(8))
		self.assertFalse(is_period_length_valid(2))
	
	



if __name__ == "__main__":
	unittest.main()