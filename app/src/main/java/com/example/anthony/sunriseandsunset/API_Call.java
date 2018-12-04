package com.example.anthony.sunriseandsunset;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class API_Call {
    public static void main(String[] args) {
        try {
            System.out.println(API_Call.call_me());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String call_me() throws Exception {
        String url = "https://api.sunrise-sunset.org/json?lat=-36.7201600&lng=4.4203400&date=2017-01-01";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        String myResponse = response.toString();
        in.close();
        //print in String
        System.out.println(myResponse);
        Map jsonJavaRootObject1 = new Gson().fromJson(myResponse, Map.class);
        String result = jsonJavaRootObject1.get("results").toString();
        System.out.println(result);
        String sunrise = "Sun Rise Time " + result.substring(9, 19);
        String sunset = "Sun Set Time " + result.substring(28, 38);
        String solarnoon = "Solar Noon Time " + result.substring(51, 62);
        String daylength = "Day Length " + result.substring(75, 83) + " (Hour,min)";
        String civiltwilightbegin = "Civil Twilight Begins At " + result.substring(106, 116);
        String civiltwilightend = "Civil Twilight Ends At " + result.substring(137, 147);
        String naturaltwilightbegins = "Natural Twilight Begins At " + result.substring(173, 183);
        String naturaltwilightends = "Natural Twilight Ends At " + result.substring(207, 217);
        String astronomicaltwilightbegin = "Astronomical Twilight Begins At " + result.substring(247, 257);
        String astronomicaltwilightend = "Astronomical Twilight Ends At " + result.substring(285, 295);

        /*
        System.out.println(sunrise);
        System.out.println(sunset);
        System.out.println(solarnoon);
        System.out.println(daylength);
        System.out.println(civiltwilightbegin);
        System.out.println(civiltwilightend);
        System.out.println(naturaltwilightbegins);
        System.out.println(naturaltwilightends);
        System.out.println(astronomicaltwilightbegin);
        System.out.println(astronomicaltwilightend);
         */

        return sunrise + "\n"
                + sunset + "\n"
                + solarnoon + "\n"
                + daylength + "\n"
                + civiltwilightbegin + "\n"
                + civiltwilightend + "\n"
                + naturaltwilightbegins + "\n"
                + naturaltwilightends + "\n"
                + astronomicaltwilightbegin + "\n"
                + astronomicaltwilightend;
    }
}