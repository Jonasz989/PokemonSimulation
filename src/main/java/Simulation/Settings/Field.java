package Simulation.Settings;

public class Field {
    boolean Occupied;
    boolean OccupiedByTrainer;
    public String fieldType;

    int poolID;
    static int staticPoolID = 0;


    //constructor for the field
    public Field () {
        poolID = staticPoolID++;
        fieldType = ".";
        Occupied = false;
        OccupiedByTrainer = false;
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
        return Occupied;
    }
    //setting the field to be occupied by the pokemon
    public void setOccupied(boolean occupied) {
        Occupied = occupied;
    }


    //checking if the field is occupied by the pokemons trainer
    public boolean isOccupiedByTrainer() {
        return OccupiedByTrainer;
    }
    //setting the field to be occupied by the pokemons trainer
    public void setOccupiedByTrainer(boolean occupied) {
        OccupiedByTrainer = occupied;
    }


}