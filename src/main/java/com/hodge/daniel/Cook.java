package com.hodge.daniel;

import java.io.File;

public class Cook {

    public  File[] listFilesForFolder(File folder) {
        File[] files = null;
        if (folder.isDirectory()) {
            files = folder.listFiles();
        }
        return files;
    }

    public static void main(String[] args) {
        File f = new File("C:\\temp\\kitchen\\input");
        Cook c = new Cook();
        File[] myFiles = c.listFilesForFolder(f);

        for (int i = 0; i < myFiles.length; i++) {

        }

    }

}
