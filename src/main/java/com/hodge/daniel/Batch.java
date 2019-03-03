package com.hodge.daniel;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    static int batchSize = 3;
    private List<Dough> doughsInBatch = new ArrayList<>();
    private List<Pastry> pastries = new ArrayList<>();

    private Preparation preparationStatus = Preparation.Raw;

    public Preparation getPreparationStatus() {
        return preparationStatus;
    }

    public void setPreparationStatus(Preparation preparationStatus) {
        this.preparationStatus = preparationStatus;
    }

    public boolean addDough(Dough d) {
        if (doughsInBatch.size() >= batchSize) {
            return false;
        }
        doughsInBatch.add(d);
        return true;
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
