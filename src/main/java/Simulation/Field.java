package Simulation;

public class Field {
    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    String fieldType;
    String NORMAL = ".";

    Field () {
        fieldType = NORMAL;
    }

    Field (String typeOfPool) {
        fieldType = typeOfPool;
    }

}