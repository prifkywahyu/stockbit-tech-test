package config;

public class GlobalVariable {

    private static GlobalVariable globalVariable;

    public String baseUrl = "https://api.punkapi.com/v2/beers/";

    public static GlobalVariable getInstance() {
        if (globalVariable == null) {
            globalVariable = new GlobalVariable();
        }
        return globalVariable;
    }
}