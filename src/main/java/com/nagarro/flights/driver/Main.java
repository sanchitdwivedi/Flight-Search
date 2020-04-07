package com.nagarro.flights.driver;

import java.util.*;

import com.nagarro.flights.findflights.SearchUtility;
import com.nagarro.flights.flightmodel.FlightInfo;
import com.nagarro.flights.readdata.ReadUtilty;
import com.nagarro.flights.result.ViewFlights;
import com.nagarro.flights.validate.*;

/**
 * Driver class which calls functions from different classes. readCSV() function
 * reads data from all the data files present and stores that data in an
 * ArrayList flight_details. takeInput() takes input from the user and validates
 * it simultaneously using Validations class. It then stores the input data in a
 * FlightInfo object inputFlight. searchForFlights() function searches for the
 * flights matching with the inputFlights. output() function will display the
 * available flights by sorting them according to user preference.
 * 
 * @author sanchitdwivedi
 * 
 */
public class Main {

	static int outputPreference;
	
	public static void main(String[] args) {

		ArrayList<FlightInfo> flight_details;

		HashMap<FlightInfo, Integer> avail_flights = new HashMap<FlightInfo, Integer>();

		ReadUtilty read = new ReadUtilty();
		flight_details = read.readCSV();

		FlightInfo inputFlight = takeInput(flight_details);

		SearchUtility su = new SearchUtility();
		su.searchForFlights(inputFlight, flight_details, avail_flights);

		ViewFlights vf = new ViewFlights();
		vf.output(flight_details, avail_flights, outputPreference);
	}

	/**
	 * 
	 * Takes input from user and Validates it.
	 * 
	 * @param flight_details
	 * @param outputPreference
	 * @return
	 */
	public static FlightInfo takeInput(ArrayList<FlightInfo> flight_details) {

		String departure;
		String arrival;
		String flightDate;
		String flightClass;

		Validations val = new Validations(flight_details);

		Scanner input = new Scanner(System.in);

		System.out.print("Departure Location:- ");
		departure = input.nextLine().toUpperCase();
		while (true) {
			if (val.validateDeparture(departure)) {
				break;
			}
			departure = input.nextLine().toUpperCase();
		}

		System.out.print("Arrival Location:- ");
		arrival = input.nextLine().toUpperCase();
		while (true) {
			if (val.validateArrival(arrival)) {
				break;
			}
			arrival = input.nextLine().toUpperCase();
		}

		System.out.print("Departure Date(DD-MM-YYYY):- ");
		while (true) {
			flightDate = input.nextLine();
			if (val.validateDate(flightDate)) {
				break;
			}
		}

		System.out.print("Flight Class (E/B):- ");

		while (true) {
			flightClass = input.next().toUpperCase();
			if (val.validateFlightClass(flightClass)) {
				break;
			}
		}

		System.out.println("Output preference:- \n 1) Sort by Fare\n 2) Sort by both Fare and Flight Duration");
		System.out.print("Enter your choice (1/2):- ");

		while (true) {
			String temp = input.next();
			if (val.validatePreference(temp)) {
				outputPreference = Integer.parseInt(temp);
				break;
			}
		}

		input.close();

		return (new FlightInfo(departure, arrival, flightDate, flightClass));
	}

}
