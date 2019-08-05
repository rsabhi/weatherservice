package com.weatherservice.weatherservice.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

    private final WeatherRepository repository;
    private static final String API_KEY = "43b4399c8386b1cb725a71e06e83e289";
    private static final String UrlName = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static DecimalFormat DecimalFormat = new DecimalFormat("#.#");

    @Autowired
    public DemoLoader(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {

        String[] CityNamesList = {"Melbourne", "Sydney", "Brisbane", "Hobart", "Perth", "Adelaide", "Darwin"};

        for (String strcity : CityNamesList) {
            Double temperature = getTemperatureFromCityName(UrlName, strcity);
            this.repository.save(new Weather(strcity, DecimalFormat.format(temperature).toString()));
        }

    }

    public static Double getTemperatureFromCityName(String myURL, String CityName) {

        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        Double cityTemperature = 0.00;
        try {
            URL url = new URL(myURL + CityName + ",AU" + "&appid=" + API_KEY);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                    JSONObject json = new JSONObject(sb.toString());
                    String ss = json.getJSONObject("main").get("temp").toString();
                    cityTemperature = Double.parseDouble(ss) - 271.15;

                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }

        return cityTemperature;
    }

}
