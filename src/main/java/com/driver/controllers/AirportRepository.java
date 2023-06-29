package com.driver.controllers;

import com.driver.model.Airport;

import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class AirportRepository {


//    public String getLargestAirportName;
//    HashSet<Airport> airports = new HashSet<>();
//    HashMap<String, Integer> airTermi = new HashMap<>();
//    HashSet<Flight> flightHashSet = new HashSet<>();
//
//    HashSet<Passenger> passengerHashSet = new HashSet<>();
//
private TreeMap<String,Airport> airportMap= new TreeMap<>();
    private HashMap<Integer,Flight> flightMap= new HashMap<>();
    private HashMap<Integer,Passenger> passengerMap= new HashMap<>();
    private HashMap<Integer,Set<Integer>> flightPassMap= new HashMap<>();
    private HashMap<Integer,Integer> revenueMap= new HashMap<>();
    private HashMap<Integer,Integer> paymentMap= new HashMap<>();


    public void addAirport(Airport airport){
        if(!airportMap.containsKey(airport.getAirportName())){
            //return "Already exist";

            airportMap.put(airport.getAirportName(),airport);
            //airTermi.put(airport.getAirportName(),airport.getNoOfTerminals());
        }

    }

    public String getLargestAirportName(){

        String result = "";
        int ans =0;
        for(String name:airportMap.keySet()){
            int ter = airportMap.get(name).getNoOfTerminals();

            if(ter>ans){
                ans = ter;
                result = name;
            }
        }
        return result;

                }

    public void getShortest(City from, City to) {



    }

    public void addFlight(Flight flight) {
 if(!flightMap.containsKey(flight.getFlightId())){
     flightMap.put(flight.getFlightId(),flight);
 }
    }

    public void addPassenger(Passenger passenger) {
        if(!passengerMap.containsKey(passenger.getPassengerId())){
            passengerMap.put(passenger.getPassengerId(), passenger);
        }
    }
}
