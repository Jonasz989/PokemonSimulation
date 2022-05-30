package Simulation;

public class Map {
    //variables for H=height of the map, W=width of the map and getters and setters for them as well
    private static int H;
    private static int W;

    /**
     * getters, setters for Height and width
     */
    public static int getH() {
        return H;
    }
    public static int getW() {
        return W;
    }
    public static int setH(int newH) {
        return H = newH;
    }
    public static int setW(int newW) {
        return W = newW;
    }


    //variable for the count of water type fields on the map, getter and setter for it as well
    private static int WaterFieldsOnTheMap = 0;
    static int newWaterFieldsOnTheMap = 0;
    public static int getWaterFieldsOnTheMap() {
        return WaterFieldsOnTheMap;
    }
    public static int setWaterFieldsOnTheMap(int newWaterFieldsOnTheMap) {
        return WaterFieldsOnTheMap = newWaterFieldsOnTheMap;
    }
    //variable for the count of fire type fields on the map, getter and setter for it as well
    static int FireFieldsOnTheMap = 0;
    static int newFireFieldsOnTheMap = 0;
    static int getFireFieldsOnTheMap() {
        return FireFieldsOnTheMap;
    }
    static int setFireFieldsOnTheMap(int newFireFieldsOnTheMap) {
        return FireFieldsOnTheMap = newFireFieldsOnTheMap;
    }
    //variable for the count of ground type fields on the map, getter and setter for it as well
    static int GroundFieldsOnTheMap = 0;
    static int newGroundFieldsOnTheMap = 0;
    static int getGroundFieldsOnTheMap() {
        return GroundFieldsOnTheMap;
    }
    static int setGroundFieldsOnTheMap(int newGroundFieldsOnTheMap) {
        return GroundFieldsOnTheMap = newGroundFieldsOnTheMap;
    }
    //variable for the count of grass type fields on the map, getter and setter for it as well
    static int GrassFieldsOnTheMap = 0;
    static int newGrassFieldsOnTheMap = 0;
    static int getGrassFieldsOnTheMap() {
        return GrassFieldsOnTheMap;
    }
    static int setGrassFieldsOnTheMap(int newGrassFieldsOnTheMap) {
        return GrassFieldsOnTheMap = newGrassFieldsOnTheMap;
    }
}


