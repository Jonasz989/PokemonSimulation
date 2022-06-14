package Simulation;

public class Map {

    //variables, getters and setters for the size of the map
    private static int H = 10;
    private static int W = 10;
    public static int getH() {
        return H;
    }
    public static int getW() {
        return W;
    }
    public static void setH(int newH) {
         H = newH;
    }
    public static void setW(int newW) {
         W = newW;
    }


    //variable, getter and setter for the count of water pokemons on the map
    private static int WaterFieldsOnTheMap = 5;
    public static int getWaterFieldsOnTheMap() {
        return WaterFieldsOnTheMap;
    }
    public static void setWaterFieldsOnTheMap(int newWaterFieldsOnTheMap) {WaterFieldsOnTheMap = newWaterFieldsOnTheMap;}


    //variable, getter and setter for the count of fire pokemons on the map
    static int FireFieldsOnTheMap = 5;
    static int getFireFieldsOnTheMap() {
        return FireFieldsOnTheMap;
    }
    static void setFireFieldsOnTheMap(int newFireFieldsOnTheMap) {
        FireFieldsOnTheMap = newFireFieldsOnTheMap;
    }


    //variable, getter and setter for the count of ground pokemons on the map
    static int GroundFieldsOnTheMap = 5;
    static int getGroundFieldsOnTheMap() {
        return GroundFieldsOnTheMap;
    }
    static void setGroundFieldsOnTheMap(int newGroundFieldsOnTheMap) {
        GroundFieldsOnTheMap = newGroundFieldsOnTheMap;
    }


    //variable, getter and setter for the count of grass pokemons on the map
    static int GrassFieldsOnTheMap = 5;
    static int getGrassFieldsOnTheMap() {
        return GrassFieldsOnTheMap;
    }
    static void setGrassFieldsOnTheMap(int newGrassFieldsOnTheMap) {
         GrassFieldsOnTheMap = newGrassFieldsOnTheMap;
    }


    //the sum of fields on the map
    public static int getSumOfSpecialFields() {
        return getFireFieldsOnTheMap() + getGroundFieldsOnTheMap() + getGrassFieldsOnTheMap() + getWaterFieldsOnTheMap();
    }


}


