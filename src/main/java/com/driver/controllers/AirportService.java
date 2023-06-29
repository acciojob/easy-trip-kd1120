package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Service;

@Service
public class AirportService {


    //public String getLargestAirportName;
    AirportRepository airportRepository  = new AirportRepository();

    public void addAirport(Airport airport){

        airportRepository.addAirport(airport);
    }
    public String getLargestAirportName() {
        return airportRepository.getLargestAirportName();
    }


    public double getShortest(City from , City to ){
        airportRepository.getShortest(from, to);
        return 0;
    }

    public void addFlight(Flight flight) {
        airportRepository.addFlight(flight);
    }

    public void addPassenger(Passenger passenger) {
        airportRepository.addPassenger(passenger);
    }
}
