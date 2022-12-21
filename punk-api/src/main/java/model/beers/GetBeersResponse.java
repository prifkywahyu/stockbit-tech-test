package model.beers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class GetBeersResponse {

    public static Collection<BeersResponsePojo> toModel(String json) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
        Type collectionType = new TypeToken<Collection<BeersResponsePojo>>(){}.getType();
        return gson.fromJson(json, collectionType);
    }
}