package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.Date;

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
      return   airportRepository.getShortest(from, to);

    }

    public String bookATicket(Integer flightId, Integer passengerId){
        return airportRepository.bookATicket(flightId, passengerId);
    }

    public int calculateFare(int flightId){
        return airportRepository.calculateFare(flightId);
    }

    public void addFlight(Flight flight) {
        airportRepository.addFlight(flight);
    }

    public void addPassenger(Passenger passenger) {
        airportRepository.addPassenger(passenger);
    }

    public int getNumberOfPeople(Date date, String airportName) {
        return airportRepository.getNumberOfPeople(date, airportName);
    }
}
