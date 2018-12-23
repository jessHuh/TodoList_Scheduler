
package Project.application.function;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class ReadWebPageJson {

    public static ArrayList<Holiday> holidayList = new ArrayList<>();

    public ArrayList<Holiday> getHolidayList() throws MalformedURLException, IOException{
        getHolidayData();
        return holidayList;
    }

    public void getHolidayData() throws MalformedURLException, IOException {

        BufferedReader br = null;

        String response;

        try {
            String theURL = "http://date.nager.at/api/v1/get/CA/2018"; // get holidays : Json Array
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
            }
            br.close();
            response = sb.toString();


        } finally {

            if (br != null) {
                br.close();
            }
        }

        // make JsonArray first
        JSONArray jsonArray = new JSONArray(response);

        for(int i=0;i<jsonArray.length();i++){

            //get the JSON Object
            JSONObject obj = jsonArray.getJSONObject(i);
            String date =obj.getString("date");
            String localName=obj.getString("localName");

            System.out.println(date);
            System.out.println(localName);

            Holiday holiday = new Holiday(date, localName);
            holidayList.add(holiday);
        }
    }
}




