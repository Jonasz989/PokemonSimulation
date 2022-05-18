public class Map extends Simulation {
    //variables for H=height of the map, W=width of the map and getters and setters for them as well
    private static int H;
    private static int W;
    private int[][] tab;


Map (int H, int W) {
    this.H = H;
    this.W = W;
}

    /**
     * getters, setters for Height and width
     */
public static int getH() {
        return H;
    }
    public static int getW() {
        return W;
    }
    public int setH(int newH) {
        return H = newH;
    }
    public int setW(int newW) {
        return W = newW;
    }


    //variable for the count of water type fields on the map, getter and setter for it as well
    int WaterFieldsOnTheMap = 0, newWaterFieldsOnTheMap = 0;
    public int getWaterFieldsOnTheMap() {
        return WaterFieldsOnTheMap;
    }
    public int setWaterFieldsOnTheMap(int newWaterFieldsOnTheMap) {
        return WaterFieldsOnTheMap = newWaterFieldsOnTheMap;
    }
    //variable for the count of fire type fields on the map, getter and setter for it as well
    int FireFieldsOnTheMap = 0, newFireFieldsOnTheMap = 0;
    public int getFireFieldsOnTheMap() {
        return FireFieldsOnTheMap;
    }
    public int setFireFieldsOnTheMap(int newFireFieldsOnTheMap) {
        return FireFieldsOnTheMap = newFireFieldsOnTheMap;
    }
    //variable for the count of ground type fields on the map, getter and setter for it as well
    int GroundFieldsOnTheMap = 0, newGroundFieldsOnTheMap = 0;
    public int getGroundFieldsOnTheMap() {
        return GroundFieldsOnTheMap;
    }
    public int setGroundFieldsOnTheMap(int newGroundFieldsOnTheMap) {
        return GroundFieldsOnTheMap = newGroundFieldsOnTheMap;
    }
    //variable for the count of grass type fields on the map, getter and setter for it as well
    int GrassFieldsOnTheMap = 0, newGrassFieldsOnTheMap = 0;
    public int getGrassFieldsOnTheMap() {
        return GrassFieldsOnTheMap;
    }
    public int setGrassFieldsOnTheMap(int newGrassFieldsOnTheMap) {
        return GrassFieldsOnTheMap = newGrassFieldsOnTheMap;
    }
}

