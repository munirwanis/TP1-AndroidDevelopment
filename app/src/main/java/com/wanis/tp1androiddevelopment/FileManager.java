package com.wanis.tp1androiddevelopment;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by munirwanis on 12/11/17.
 */

class FileManager {
    private static String fileName = "contacts.txt";

    static void Store(String text) throws IOException {

        File file;
        byte[] data;
        try {
            file = new File(Environment.getExternalStorageDirectory(), FileManager.fileName);
            FileOutputStream fos;

            data = text.getBytes();

            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            throw e;
        }
    }

    static String Read() throws IOException {
        File file;
        String stringFile = "";
        String stringFileLine;
        try {
            file = new File(Environment.getExternalStorageDirectory(), FileManager.fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((stringFileLine = br.readLine()) != null) {
                if (!stringFile.equals("")) {

                    stringFile = stringFile.concat("\n");
                }
                stringFile = stringFile.concat(stringFileLine);
            }

            return stringFile;
        } catch (Exception e) {
            throw e;
        }
    }
}
