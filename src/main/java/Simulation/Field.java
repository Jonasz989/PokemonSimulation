package Simulation;

public class Field {
    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOccupiedByTrainer() {
        return isOccupied;
    }

    public void setOccupiedByTrainer(boolean occupied) {
        isOccupiedByTrainer = occupied;
    }

    boolean isOccupied;
    boolean isOccupiedByTrainer;
    String fieldType;
    String NORMAL = ".";

    Field () {
        fieldType = NORMAL;
        isOccupied = false;
        isOccupiedByTrainer = false;
    }

    Field (String typeOfPool) {
        fieldType = typeOfPool;
    }

}