/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.helpers;

import com.whatthehack.ctrl.yourself.game.Challenge;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 */
public class FilesHelper {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = "&";

    public static ArrayList<Challenge> readCSVFileChallenges(String fileName, ArrayList<Challenge> defaultChallenges) throws IOException {
        ArrayList<Challenge> challengeArray = new ArrayList<>();
        File file = new File(fileName);
        if (file.isFile()) {

            System.out.println("File exists");
            FileInputStream fileInStream = new FileInputStream(file);
            BufferedReader fileReader = null;

            try {
                fileReader = new BufferedReader(new InputStreamReader(fileInStream));
                String line = null;
                while ((line = fileReader.readLine()) != null) {
                    String[] tokens = line.split(COMMA_DELIMITER);
                    if (tokens.length > 0) {
                        challengeArray.add(new Challenge(tokens[0], tokens[1], tokens[2]));
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error in CsvFileReader !!!");
            } catch (IOException e) {
                System.out.println("Error in CsvFileReader !!!");
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        System.out.println("Error while flushing/closing fileWriter !!!");
                    }
                }
            }
        } else {
            challengeArray = defaultChallenges;
            writeCSVFileChallenges(defaultChallenges, fileName);
        }
        return (challengeArray);
    }

    public static void writeCSVFileChallenges(ArrayList<Challenge> challengeArray, String fileName) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);

            for (int i = 0; i < challengeArray.size(); i++) {
                fileWriter.append(challengeArray.get(i).getTitle());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(challengeArray.get(i).getDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(challengeArray.get(i).getSound());
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
            }
        }
    }

}
