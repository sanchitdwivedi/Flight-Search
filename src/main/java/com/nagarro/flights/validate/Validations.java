package com.nagarro.flights.validate;

import java.text.*;
import java.util.*;

import com.nagarro.flights.flightmodel.FlightInfo;
import com.nagarro.flights.readdata.FlightClass;

/**
 * Class to validate input data.
 * 
 * @author sanchitdwivedi
 *
 */
public class Validations {

	ArrayList<FlightInfo> flight_details;
	ArrayList<String> departure_locations = new ArrayList<String>();
	ArrayList<String> arrival_locations = new ArrayList<String>();

	public Validations(ArrayList<FlightInfo> flight_details) {
		this.flight_details = flight_details;
		createDepartureList();
		createArrivalList();
	}

	public void createDepartureList() {

		for (FlightInfo flight : flight_details) {
			if (!departure_locations.contains(flight.getDeparture())) {
				departure_locations.add(flight.getDeparture());
			}
		}

	}

	public void createArrivalList() {
		for (FlightInfo flight : flight_details) {
			if (!arrival_locations.contains(flight.getArrival())) {
				arrival_locations.add(flight.getArrival());
			}
		}

	}

	public boolean validateDeparture(String departure) {

		if (!departure_locations.contains(departure)) {
			System.out.println("No flights available from " + departure);
			System.out.print("Available departure locations are:- ");
			for (String location : departure_locations) {
				System.out.print(location + " ");
			}
			System.out.print("\nEnter departure location again:- ");
			return false;
		} else {
			return true;
		}

	}

	public boolean validateArrival(String arrival) {

		if (!arrival_locations.contains(arrival)) {
			System.out.println("No flights going to " + arrival);
			System.out.print("Available arrival locations are:- ");
			for (String location : arrival_locations) {
				System.out.print(location + " ");
			}
			System.out.print("\nEnter arrival location again:- ");

			return false;
		} else {
			return true;
		}
	}

	public boolean validateDate(String flightDate) {
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		try {
			df.parse(flightDate);
			return true;
		} catch (ParseException e) {
			System.out.print("Wrong date fromat! \nEnter date again:- ");
			return false;
		}
	}

	public boolean validateFlightClass(String flightClass) {
		if (flightClass.equals(FlightClass.E.toString()) || flightClass.equals(FlightClass.B.toString())) {
			return true;
		} else {
			System.out.print("Wrong class! \nEnter flight class again:- ");
			return false;
		}
	}

	public boolean validatePreference(String outputPreference) {
		if (outputPreference.equals("1") || outputPreference.equals("2")) {
			return true;
		} else {
			System.out.print("Wrong preference! \nEnter either 1 or 2:- ");
			return false;
		}
	}

}
