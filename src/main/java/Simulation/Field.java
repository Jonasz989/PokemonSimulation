package Simulation;

public class Field {
    boolean isOccupied;
    boolean isOccupiedByTrainer;
    String fieldType;
    String NORMAL = ".";
    int poolID;
    static int staticPoolID = 0;


    //constructor for the field
    Field () {
        poolID = staticPoolID++;
        fieldType = NORMAL;
        isOccupied = false;
        isOccupiedByTrainer = false;
    }


    //getter and setter for the field's type
    public String getFieldType() {
        return fieldType;
    }
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }


    //checking if the field is occupied by the pokemon
    public boolean isOccupied() {
        return isOccupied;
    }
    //setting the field to be occupied by the pokemon
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }


    //checking if the field is occupied by the pokemons trainer
    public boolean isOccupiedByTrainer() {
        return isOccupied;
    }
    //setting the field to be occupied by the pokemons trainer
    public void setOccupiedByTrainer(boolean occupied) {
        isOccupiedByTrainer = occupied;
    }


    Field (String typeOfPool) {
        fieldType = typeOfPool;
    }

}