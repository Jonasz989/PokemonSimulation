package Simulation.Settings;

public class Map {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int H = 10;
    private static int W = 10;
    static int FireFieldsOnTheMap = 5;
    private static int WaterFieldsOnTheMap = 5;
    private static int GroundFieldsOnTheMap = 5;
    private static int GrassFieldsOnTheMap = 5;


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int getSumOfSpecialFields() {
        return getFireFieldsOnTheMap() + getGroundFieldsOnTheMap() + getGrassFieldsOnTheMap() + getWaterFieldsOnTheMap();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    public static int getWaterFieldsOnTheMap() {
        return WaterFieldsOnTheMap;
    }
    public static void setWaterFieldsOnTheMap(int newWaterFieldsOnTheMap) {WaterFieldsOnTheMap = newWaterFieldsOnTheMap;}
    public static int getFireFieldsOnTheMap() {
        return FireFieldsOnTheMap;
    }
    public static void setFireFieldsOnTheMap(int newFireFieldsOnTheMap) {
        FireFieldsOnTheMap = newFireFieldsOnTheMap;
    }
    public static int getGroundFieldsOnTheMap() {
        return GroundFieldsOnTheMap;
    }
    public static void setGroundFieldsOnTheMap(int newGroundFieldsOnTheMap) {
        GroundFieldsOnTheMap = newGroundFieldsOnTheMap;
    }
    public static int getGrassFieldsOnTheMap() {
        return GrassFieldsOnTheMap;
    }
    public static void setGrassFieldsOnTheMap(int newGrassFieldsOnTheMap) {
         GrassFieldsOnTheMap = newGrassFieldsOnTheMap;
    }
}


