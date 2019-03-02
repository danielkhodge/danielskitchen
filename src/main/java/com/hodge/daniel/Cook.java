package com.hodge.daniel;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.UUID;

public class Cook {
    private static final Logger LOG = LogManager.getLogger(Cook.class);

    public  File[] listFilesForFolder(File folder) {
        File[] files = null;
        if (folder.isDirectory()) {
            files = folder.listFiles();
        }
        return files;
    }

    public static void main(String[] args) {
        Cook c = new Cook();
        c.cookThePastries();
    }

    private void cookThePastries() {
        File f = new File("C:\\temp\\kitchen\\input");
        File[] myFiles = listFilesForFolder(f);
        Batch batch = new Batch();
        for (int i = 0; i < myFiles.length; i++) {

            try {
                Properties p = new Properties();
                InputStream in = new FileInputStream(myFiles[i]);
                p.load(in);
                String type = p.getProperty("type");
                Dough d = new Dough();


                int butter = Integer.parseInt(p.getProperty("butter"));
                int flour = Integer.parseInt(p.getProperty("flour"));
                int salt = Integer.parseInt(p.getProperty("salt"));
                int sugar = Integer.parseInt(p.getProperty("sugar"));
                int jam = Integer.parseInt(p.getProperty("jam"));

                d.setButter(butter);
                d.setFlour(flour);
                d.setSalt(salt);
                d.setJam(jam);
                d.setSugar(sugar);

                batch.addDough(d);

            } catch (IOException e) {
                LOG.error("Could not read " + myFiles[i].getAbsolutePath());
            }
        }
        OvenFactory.getOven().cook(batch, this);
    }


    public void batchComplete(Batch batch) {
        for(Pastry p: batch.getPastries()) {
            try {
                Gson gson = new Gson();
                String json = gson.toJson(p);
                String filename = "C:\\temp\\kitchen\\output\\" + UUID.randomUUID().toString().substring(0, 8) + ".pastry.json";
                new FileWriter(filename).write(json);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
