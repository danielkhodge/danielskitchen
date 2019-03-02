package com.hodge.daniel;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    static int batchSize = 3;
    private List<Dough> doughsInBatch = new ArrayList<>();
    private List<Pastry> pastries = new ArrayList<>();

    private Preparation preparationStatus;

    public Preparation getPreperationStatus() {
        return preparationStatus;
    }

    public void setPreperationStatus(Preparation preparationStatus) {
        this.preparationStatus = preparationStatus;
    }

    public void addDough(Dough d) {
        if (doughsInBatch.size() >= batchSize) {
            throw new RuntimeException("This batch is already full: " + batchSize);
        }
        doughsInBatch.add(d);
    }

    public boolean isBatchFull() {
        return doughsInBatch.size() >= 3;
    }

    public void addPastry(Pastry p) {
        pastries.add(p);
    }

    public List<Pastry> getPastries() {
        return pastries;
    }

    public List<Dough> getDoughsInBatch() {
        return doughsInBatch;
    }
}
