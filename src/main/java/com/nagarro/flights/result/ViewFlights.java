package com.nagarro.flights.result;

import java.text.DecimalFormat;
import java.util.*;

import com.nagarro.flights.flightmodel.FlightInfo;
import com.nagarro.flights.readdata.FlightClass;

/**
 * Displays the flights matching with the input data according to the user
 * preference.
 * 
 * @author sanchitdwivedi
 *
 */
public class ViewFlights {

	public void output(ArrayList<FlightInfo> flight_details, HashMap<FlightInfo, Integer> avail_flights,
			int outputPreference) {

		if (outputPreference == 1) {

			Collections.sort(flight_details, new Comparator<FlightInfo>() {

				public int compare(FlightInfo obj1, FlightInfo obj2) {
					if (obj1 == null) {
						return (obj2 == null) ? 0 : -1;
					}
					if (obj2 == null) {
						return 1;
					}
					return (obj1.getFareRate() - obj2.getFareRate());

				}
			});

		} else if (outputPreference == 2) {

			Collections.sort(flight_details, new Comparator<FlightInfo>() {

				public int compare(FlightInfo obj1, FlightInfo obj2) {
					if (obj1 == null) {
						return (obj2 == null) ? 0 : -1;
					}
					if (obj2 == null) {
						return 1;
					}
					int y = (obj1.getFareRate() - obj2.getFareRate());

					if (y != 0) {
						return y;
					}

					return (int) (obj1.getDuration() - obj2.getDuration());

				}
			});

		} else {
			System.out.println("Wrong option");
			return;
		}

		display(flight_details, avail_flights);

	}

	public void display(ArrayList<FlightInfo> flight_details, HashMap<FlightInfo, Integer> avail_flights) {

		int totalFlights = 0;

		DecimalFormat df = new DecimalFormat("0.00");

		Set<FlightInfo> s = avail_flights.keySet();

		for (FlightInfo flight : s) {
			if (avail_flights.get(flight) == 1) {
				totalFlights++;
			}
		}

		if (totalFlights == 0) {
			System.out.println("\n *********** No flights available ***********");
			return;
		}

		System.out.println("\n *********** " + totalFlights + " flights available ***********");

		System.out.println("\nFLIGHT_NO|    DEP_LOC \t |   ARR_LOC \t | VALID_TILL| FARE \t|DURATION| \n");

		for (FlightInfo flight : flight_details) {
			if (avail_flights.get(flight) == 1) {
				System.out.print(" " + flight.getFlightNumber());
				System.out.print("\t |\t" + flight.getDeparture());
				System.out.print("\t |\t" + flight.getArrival());
				System.out.print("\t |" + flight.getFlightDate());

				if (flight.getFlightClass().equals(FlightClass.B.toString())) {
					System.out.print(" | " + df.format(1.4 * flight.getFareRate()));
				} else {
					System.out.print(" | " + flight.getFareRate());
				}
				System.out.println("\t|  " + flight.getDuration() + "\t |");
			}
		}
	}
}
