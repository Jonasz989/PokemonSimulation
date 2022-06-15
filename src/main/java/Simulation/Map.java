package Simulation;

public class Map {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int H = 10;
    private static int W = 10;
    static int FireFieldsOnTheMap = 5;
    private static int WaterFieldsOnTheMap = 5;
    static int GroundFieldsOnTheMap = 5;
    static int GrassFieldsOnTheMap = 5;


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
    static int getFireFieldsOnTheMap() {
        return FireFieldsOnTheMap;
    }
    static void setFireFieldsOnTheMap(int newFireFieldsOnTheMap) {
        FireFieldsOnTheMap = newFireFieldsOnTheMap;
    }
    static int getGroundFieldsOnTheMap() {
        return GroundFieldsOnTheMap;
    }
    static void setGroundFieldsOnTheMap(int newGroundFieldsOnTheMap) {
        GroundFieldsOnTheMap = newGroundFieldsOnTheMap;
    }
    static int getGrassFieldsOnTheMap() {
        return GrassFieldsOnTheMap;
    }
    static void setGrassFieldsOnTheMap(int newGrassFieldsOnTheMap) {
         GrassFieldsOnTheMap = newGrassFieldsOnTheMap;
    }
}


