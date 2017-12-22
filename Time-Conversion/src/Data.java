import java.util.*;
import java.io.*;
/*
    Class "Data" retrieves information on countries and timezones from 'timezones.txt'
    and creates a map of keys and values. Keys are the registered timezone, values
    are locations in said timezone.
 */
public class Data {

    //instance variables
    private HashMap<String, String> MAIN_DATA = new HashMap<>();
    private String ZONES_FILE_NAME = "src/timezones.txt";

    //void constructor
    public Data(){}

    /*
        Method creates the necessary information in the Map<String, String> MAIN_DATA.
     */
    public void createMap(){
        try {
            //variables
            BufferedReader zonesReader = new BufferedReader(new FileReader(ZONES_FILE_NAME));
            String line = zonesReader.readLine();
            int count = 0;
            ArrayList<String> zones = new ArrayList<>();
            ArrayList<String> locations = new ArrayList<>();

            //fills in both arrays to be used to create the MAIN_DATA map
            while (line != null){
                if (count % 2 == 0) {
                    zones.add(line);
                    count++;

                    line = zonesReader.readLine();
                } else {
                    locations.add(line);
                    count++;

                    line = zonesReader.readLine();
                }
            }

            //fills in MAIN_DATA with correct arrangement of data
            for (int i = 0; i < zones.size(); i++) {
                MAIN_DATA.put(zones.get(i), locations.get(i));
            }
            zonesReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //returns MAIN_DATA hash map
    public HashMap<String, String> getMap(){
        return MAIN_DATA;
    }

    //finds which time zone the location falls in
    public String getTimeZone(String searchKey){
        for (HashMap.Entry<String, String> entry : MAIN_DATA.entrySet()) {
            if (entry.getValue().contains(searchKey)) {
                return entry.getKey();
            }
        }

        return null;
    }

    //returns the difference of two parsed strings, for example x and y could equal 'UTC+13:45'

    public Integer compareTime(String x, String y){
        try {
            Integer start = Integer.parseInt(x.substring(3));
            Integer end = Integer.parseInt(y.substring(3));

            int duration = end - start;
            if (duration < 0){
                duration = duration + 24;
            }

            return duration;

        } catch (Exception e){ e.printStackTrace();}

        return null;
    }
}
