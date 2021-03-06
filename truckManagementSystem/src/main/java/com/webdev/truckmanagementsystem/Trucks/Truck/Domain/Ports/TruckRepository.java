package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TripId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;

import java.util.List;
import java.util.Optional;

public interface TruckRepository {
    void save(Truck truck);
    Optional<Truck> find(TruckId Id);
    void update(Truck truck);
    Optional<List<Truck>> all();
    void delete(Truck truck);
    Optional<List<Truck>> findByOwnerId(OwnerId id);
}
