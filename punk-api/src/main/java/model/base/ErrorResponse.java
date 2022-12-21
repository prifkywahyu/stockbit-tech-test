package model.base;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ErrorResponse extends BaseResponse<ErrorResponse> {

    public String error;
    public String message;

    @Override
    public ErrorResponse getBody() {
        return this;
    }

    public static ErrorResponse toModel(String json) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
        return gson.fromJson(json, ErrorResponse.class);
    }
}