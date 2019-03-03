package com.hodge.daniel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

                Dough d = new Dough();

                String type = p.getProperty("type");
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
                d.setType(type);

                if (!batch.addDough(d)) {
                    OvenFactory.getOven().cook(batch, this);
                    batch = new Batch();
                    batch.addDough(d);
                }

            } catch (IOException e) {
                LOG.error("Could not read " + myFiles[i].getAbsolutePath());
            }
        }

        if (batch.getPreparationStatus() == Preparation.Raw) {
            OvenFactory.getOven().cook(batch, this);
        }
    }


    public void batchComplete(Batch batch) {
        for(Pastry p: batch.getPastries()) {
            FileWriter writer = null;
            try {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(p);
                String filename = "C:\\temp\\kitchen\\output\\" + UUID.randomUUID().toString().substring(0, 8) + ".pastry.json";
                writer = new FileWriter(filename);
                writer.write(json);
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {writer.close();}
                    catch(Exception e){}
                }
            }
        }
    }

}
