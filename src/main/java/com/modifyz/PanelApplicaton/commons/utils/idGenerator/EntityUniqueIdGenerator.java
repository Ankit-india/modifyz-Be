package com.modifyz.PanelApplicaton.commons.utils.idGenerator;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.time.Year;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EntityUniqueIdGenerator {

    private final AtomicInteger sequence = new AtomicInteger(0);

    public String generateUniqueId() {
        String currentYear = String.valueOf(Year.now().getValue());
        String sequenceNumber = String.format("%05d", getNextSequence());

        return (currentYear + sequenceNumber + System.currentTimeMillis());
    }

    private int getNextSequence() {
        // You can add any desired logic to increment the sequence number.
        // Here, we use a simple atomic integer to get the next value.
        return sequence.getAndIncrement() % 100000;
    }
}
