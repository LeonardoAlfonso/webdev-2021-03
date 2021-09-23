package com.webdev.truckmanagementsystem.Shared.Domain.Ids;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class TripId extends CustomUUID {

    private TripId() {}

    public TripId(String value) {
        super(value);
    }
}
