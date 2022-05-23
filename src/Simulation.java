
public class Simulation extends Menu {
    public void createMap() {
    }

    Field[][] flatMap = new Field[Map.getH()][Map.getW()];

    public void start(Field[][] flatMap) {
        createMap(flatMap);
        printMap(flatMap);
        //fillMap(flatMap);
    }

    public void printMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                System.out.print(flatMap[i][j].fieldType + " ");
            }
            System.out.println();
        }
    }
    public void createMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j] = new Field();
            }
        }
    }

    public void fillMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {

            }
        }
    }

    public void moveTrainer() {
    }


//generating trainer and pokemons

}
