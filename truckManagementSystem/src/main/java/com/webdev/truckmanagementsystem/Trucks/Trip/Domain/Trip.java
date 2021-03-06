package com.webdev.truckmanagementsystem.Trucks.Trip.Domain;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.truckmanagementsystem.Shared.Domain.DomainEvents.TripFinalizedDomainEvent;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TripId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects.*;

import java.util.HashMap;

public class Trip extends AggregateRoot {
    private TripId tripId;
    private TripOrigin origin;
    private TripDestiny destiny;
    private TripDistance distance;
    private TripStatus status;
    private TripLoadWeight loadWeight;
    private TripInitialDate initialDate;
    private TripPlannedFinalDate plannedFinalDate;
    private TripRealFinalDate realFinalDate;
    private TruckId truckId;

    public Trip(TripId tripId,
                TripOrigin origin,
                TripDestiny destiny,
                TripDistance distance,
                TripStatus status,
                TripLoadWeight loadWeight,
                TripInitialDate initialDate,
                TripPlannedFinalDate plannedFinalDate,
                TripRealFinalDate realFinalDate,
                TruckId truckId) {
        this.tripId = tripId;
        this.origin = origin;
        this.destiny = destiny;
        this.distance = distance;
        this.status = status;
        this.loadWeight = loadWeight;
        this.initialDate = initialDate;
        this.plannedFinalDate = plannedFinalDate;
        this.realFinalDate = realFinalDate;
        this.truckId = truckId;
    }

    public static Trip Create(TripId tripId,
                         TripOrigin origin,
                         TripDestiny destiny,
                         TripDistance distance,
                         TripLoadWeight loadWeight,
                         TripInitialDate initialDate,
                         TripPlannedFinalDate plannedFinalDate,
                         TruckId truckId) {
        Trip trip = new Trip(tripId, origin, destiny, distance, new TripStatus("start"), loadWeight, initialDate, plannedFinalDate, null, truckId);
        //EVENTS
        return trip;
    }

    public void finalizedTrip() {
        this.status = new TripStatus("finalized");
        this.record(new TripFinalizedDomainEvent(this.truckId.value(), this.distance.value()));
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", tripId.value());
            put("origin", tripId.value());
            put("destiny", tripId.value());
            put("distance", tripId.value());
            put("status", tripId.value());
            put("loadWeight", tripId.value());
            put("initialDate", tripId.value());
            put("finalDate", tripId.value());
            put("realFinalDate", tripId.value());
            put("truckId", truckId.value());
        }};
    }

    private Trip() {}
}
