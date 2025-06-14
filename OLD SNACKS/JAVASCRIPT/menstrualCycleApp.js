const prompt = require("Prompt-sync")();
function calculateNextPeriodDate(lastPeriodDate, cycleLength){
	return new Date(lastPeriodDate.getTime() + cycleLength * 24 * 60 * 60 * 1000);
}
function calculateOvulationDate(lastPeriodDate) {
	return new Date(lastPeriodDate.getTime() + 14 * 24 * 60 * 60 * 1000);
}
function isCycleLengthValid(cycleLength) {
	return cycleLength >= 21 && cycleLength <= 35;
}
function isPeriodLengthValid(periodLength) {
	return periodLength >= 3 && periodLength <= 7;
}
function isValidDate(dateString){
	const regex = /^\d{4}-\d{2}-\d{2}$/;
	if (!regex.test(dataString)) return false;
	
	const date = new Date(dateString);
	return date instanceof Date && !NaN(date);
}
function getValidDate() {
	while (true) {
		let lastPeriodInput = prompt("Enter the date of the last period (YYYY-MM-DD):   ");
		try{
			let lastPeriodDate = new Date(lastPeriodInput);

			if(!isNaN(lastPeriodDate.getTime())) {
				return lastPeriodDate;
			} else {
				console.log("Error: Invalid date format. Please enter the format. YYYY-MM-DD");
			}
		}catch {
			console.log("Error: Invalid date format.");
		}
	}
}
function main() {
	let name = prompt("Enter your Name:   ");
	let cycleLength;
	while (true) {
		cycleLength = parseInt(prompt("Enter average cycle Length (days):   "));
		if (isCycleLengthValid(cycleLength)) {
			break;
		} else {
			console.log("Error: cycle length must be between 21 and 35 days. if this is not the case please see the doctor for treatment or Try again:   ")
		}
	}
	
	let periodLength;
	while (true) {
		let periodLength = parseInt(prompt("Enter period length (days):   "));
		if(isPeriodLengthValid(periodLength)) {
			break;
		}else {
			console.log("Error: Period length must be between 3 and 7 days. if this is not the case please see the doctor for treatment or Try again:    ")
		}
	}

	let lastPeriodDate = getValidDate();
	let nextPeriodDate = calculateNextPeriodDate(lastPeriodDate, cycleLength);
	let ovulationDate = calculateOvulationDate(lastPeriodDate);
	

	console.log(`Hello, ${name}!`); 
	console.log(`Your next period is expected on:  ${nextPeriodDate.toISOString().split('T')[0]}`);
	console.log(`Your ovulation date is expected on: ${ovulationDate.toISOString().split('T')[0]}`);
}

main();