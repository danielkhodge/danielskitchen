package com.hodge.daniel;

public class Oven {
    Oven() {
        super();
    }

    public void cook(Batch b, Cook c) {

        for(Dough d: b.getDoughsInBatch()) {
            Pastry pastry = null;
            d.getType();
            if (d.equals("DONUT")) {
                pastry = new Donut();
            }
            else if (d.equals("CROISSANT")) {
                pastry = new Croissant();
            }
            else if (d.equals("DANISH")) {
                pastry = new Danish();
            }

            int butter = d.getButter();
            int flour = d.getFlour();
            int salt = d.getSalt();
            int sugar = d.getSugar();
            int jam = d.getJam();

            flour = flour * 5;

            pastry.setButter(butter);
            pastry.setFlour(flour);
            pastry.setSalt(salt);
            pastry.setJam(jam);
            pastry.setSugar(sugar);

            b.addPastry(pastry);
        }
        c.batchComplete(b);


    }
}