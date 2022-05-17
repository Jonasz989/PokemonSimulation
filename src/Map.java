public class Map {
    //variables for H=height of the map, W=width of the map and getters and setters for them as well
    private int H, W;
    private int[][] tab;


Map (int H, int W) {
    this.H = H;
    this.W = W;
}

    /**
     * getters, setters for Height and width
     */
public int getH() {
        return H;
    }
    public int getW() {
        return W;
    }
    public int setH(int newH) {
        return H = newH;
    }
    public int setW(int newW) {
        return W = newW;
    }
}


