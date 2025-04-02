package com.model;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;

public class JSONHandler {
    private static Gson gson = new GsonBuilder()
    .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {

        @Override
        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
        
        
    })
    .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>(){

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
                    return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
        
    }).create();

    public static String ArrayListVersionsToStringJSON(ArrayList<ArrayList<User>> versionsUsers) {
        return gson.toJson(versionsUsers);
    }

    public static ArrayList<ArrayList<User>> StringJSONToArrayListVersions(String stringJSON) {
        return gson.fromJson(stringJSON, Versions.getVersions().getClass());
    }

}
