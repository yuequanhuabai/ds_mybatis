//package com.ex.controller;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class ChocolateyPackagesFetcher {
//
//    private static final String API_URL = "https://community.chocolatey.org/api/v2/packages";
//
//    public static void main(String[] args) {
//        try {
//            // Create URL object
//            URL url = new URL(API_URL);
//
//            // Open connection
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            // Check response code
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                // Read response
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                // Parse JSON response
//                JSONObject jsonResponse = new JSONObject(response.toString());
//                JSONArray packages = jsonResponse.getJSONArray("results");
//
//                // Print package details
//                for (int i = 0; i < packages.length(); i++) {
//                    JSONObject pkg = packages.getJSONObject(i);
//                    System.out.println("Package ID: " + pkg.getString("id"));
//                    System.out.println("Package Title: " + pkg.getString("title"));
//                    System.out.println("Package Description: " + pkg.getString("description"));
//                    System.out.println("----");
//                }
//
//            } else {
//                System.out.println("GET request failed. Response code: " + responseCode);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
