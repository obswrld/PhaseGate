import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MenstrualCycleApp{
	public static LocalDate calculateNextPeriodDate(LocalDate lastPeriodDate, int cycleLength){
		return lastPeriodDate.plusDays(cycleLength);
	}

	public static LocalDate calculateOvulationDate(LocalDate lastPeriodDate){
		return lastPeriodDate.plusDays(14);
	}
	
	public static boolean isCycleLengthValid(int cycleLength){
		return cycleLength >= 21 && cycleLength <= 35;
	}

	public static boolean isPeriodLengthValid(int periodLength){
		return periodLength >= 3 && periodLength <= 7;
	}

	public static LocalDate getValidDate(Scanner input){
		while (true){
			System.out.println("Enter the date of your last period (YYYY-MM-DD):   ");
			String lastPeriodInput = input.next();
			try{
				return LocalDate.parse(lastPeriodInput, DateTimeFormatter.ISO_LOCAL_DATE);
			} catch(DateTimeParseException e){
				System.out.println("Error. Invalid date format. Please use the format YYYY-MM-DD:   ");
			}
		}
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter your name:  ");
		String name = input.nextLine();

		int cycleLength = 0;
		while (true){
			System.out.print("Enter average cycle length (days):   ");
			cycleLength = input.nextInt();
			if (isCycleLengthValid(cycleLength)) {
				break;
			} else{
				System.out.println("Error! Cycle Length must be between 21 and 35 days. if this is not the case, i advice you see the doctor for further treatment Ma'am or Please try again:    ");
			}
		}
	
		int periodLength = 0;
		while (true){
			System.out.println("Enter Your Period Length (days):   ");
			periodLength = input.nextInt();
			if(isPeriodLengthValid(periodLength)) {
				break;
			} else{
				System.out.println("Error:  Period Length must be between 3 and 7 days. If this is not the case, i advise you see the doctor for further treatment Ma'am or try again:    ");
			}
		}

		LocalDate lastPeriodDate = getValidDate(input);
		LocalDate nextPeriodDate = calculateNextPeriodDate(lastPeriodDate, cycleLength);
		LocalDate ovulationDate = calculateOvulationDate(lastPeriodDate);
		LocalDate safePeriodStart = lastPeriodDate.plusDays(periodLength + 1);
		LocalDate safePeriodEnd = ovulationDate.minusDays(1);


		System.out.println("Hello  " + name + " :");
		System.out.println("Your next period is expected on:   " +  nextPeriodDate);
		System.out.println("Your ovulation date is expected on:  " +  ovulationDate);
		System.out.println("Your safe period is from:   " + safePeriodStart + " to " + safePeriodEnd);
	}
} 