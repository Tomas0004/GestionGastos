package com.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONHandler {
    private static JSONArray jsonVersionsArray;
    private static JSONArray jsonArray = new JSONArray();
    private static JSONArray jsonArrayTwo;
    private static JSONObject jsonObject;
    private static JSONObject jsonObjectTwo;
    private static ArrayList<Versions> arraylistVersions = new ArrayList<>();
    private static ArrayList<User> arraylistUser;

    public static String ArrayListVersionsToStringJSON(ArrayList<Versions> arraylist) {
        jsonArray.clear();

        for(Versions versions : arraylist) {
            jsonVersionsArray = new JSONArray();

            for(User user : versions.getVersions()){
                jsonObject = new JSONObject();
                jsonArrayTwo = new JSONArray();
                jsonObject.put("password", user.getPassword());
                jsonObject.put("username", user.getUsername());
                jsonObject.put("name", user.getName());
                jsonObject.put("amountLeft", user.getAmountLeft());
    
    
                for(Action action : user.getActions()){
                    jsonObjectTwo = new JSONObject();
    
                    jsonObjectTwo.put("date", action.getDate().toString());
                    jsonObjectTwo.put("hour", action.getHour().toString());
                    jsonObjectTwo.put("amountMoved", action.getAmountMoved());
                    jsonArrayTwo.put(jsonObjectTwo);
                }
                jsonObject.put("actions", jsonArrayTwo);
                jsonVersionsArray.put(jsonObject);
            }
            jsonArray.put(jsonVersionsArray);
        }

        return jsonArray.toString();
    }

    public static ArrayList<Versions> StringJSONToArrayListVersions(String stringJSON) {
        try {
            
            arraylistVersions.clear();
            jsonArray.clear();
    
            jsonArray = new JSONArray(stringJSON);
    
            for(int i = 0; i < jsonArray.length(); i++) {
                jsonArrayTwo = new JSONArray();
                jsonArrayTwo = jsonArray.getJSONArray(i);
                arraylistUser = new ArrayList<>();
    
                for(int ii = 0; ii < jsonArrayTwo.length(); ii++){
                    jsonObject = jsonArrayTwo.getJSONObject(ii);
                    arraylistUser.add(new User(jsonObject.getString("password"), jsonObject.getString("username"), jsonObject.getString("name"), jsonObject.getInt("amountLeft")));
                    for(int j = 0; j < jsonObject.getJSONArray("actions").length(); j++){
                        String temp;
                        arraylistUser.getLast().addAction(new Action(LocalDate.parse(jsonObject.getJSONArray("actions").getJSONObject(j).getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        , LocalTime.parse(temp = jsonObject.getJSONArray("actions").getJSONObject(j).getString("hour"), DateTimeFormatter.ofPattern(validateHourPattern(temp)))
                        , jsonObject.getJSONArray("actions").getJSONObject(j).getInt("amountMoved")));
                    }
                }
    
                arraylistVersions.add(new Versions());
                arraylistVersions.getLast().setVersions(arraylistUser);
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arraylistVersions;
    }

    public static String validateHourPattern(String temp){
        return temp.substring(temp.length() - 9, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSSSSSSSS"
        : temp.substring(temp.length() - 8, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSSSSSSS"
        : temp.substring(temp.length() - 7, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSSSSSS"
        : temp.substring(temp.length() - 6, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSSSSS"
        : temp.substring(temp.length() - 5, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSSSS"
        : temp.substring(temp.length() - 4, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSSS"
        : temp.substring(temp.length() - 3, temp.length()).matches("[0-9]*")? "HH:mm:ss.SSS"
        : temp.substring(temp.length() - 2, temp.length()).matches("[0-9]*")? "HH:mm:ss.SS"
        : temp.substring(temp.length() - 1, temp.length()).matches("[0-9]*")? "HH:mm:ss.S"
        : "HH:mm:ss";
    }
        
}
