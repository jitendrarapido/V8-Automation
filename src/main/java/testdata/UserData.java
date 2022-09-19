package testdata;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserData {

    //This function is to parse the .csv file to list
    public static List<String> getUserDataList(String uType, String path) {
        List<String> list = new ArrayList<>();
        try (CSVReader reader
                     = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Arrays.toString(nextLine).contains(uType)) {
                    list = Arrays.asList(nextLine);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

