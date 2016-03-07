package com.sainsbury.grocery.sws.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonConverter {

    public String constructJson(Object o) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        String json = gson.toJson(o);
        return json;
    }
}


