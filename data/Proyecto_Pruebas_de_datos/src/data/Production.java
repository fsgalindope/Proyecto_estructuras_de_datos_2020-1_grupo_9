package data;

import Estructuras_de_datos.*;

import java.util.Scanner;

public class Production extends Event{
    private MyArrayList<RawMaterial> rawMaterials;
    private ArrayQueue<Stage> stages;

    public Production(String name, String description, MyArrayList<RawMaterial> rawMaterials,
                      ArrayQueue<Stage> stages) {
        super(name, description);
        this.rawMaterials = rawMaterials;
        this.stages = stages;
    }

    public Production() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre de producción:");
        String name = input.next();
        System.out.println("nombre: " + name);
        System.out.println("Ingrese descripción:");
        String description = input.next();
        System.out.println("Descripción: " + description);
        System.out.println("Ahora creamos etapas");
        ArrayQueue<Stage> processStages = new ArrayQueue<>() ;
        Stage stage = new Stage();
        processStages.enqueue(stage);
        boolean createStage = true;
        int numberOfStages = 1;
        while (createStage) {
            System.out.println("¿Desea agregar más etapas al proceso?");
            String answer = input.next();
            if (answer.equalsIgnoreCase("Si")){
                System.out.println("Hacer una nueva etapa.");
                stage = new Stage();
                processStages.enqueue(stage);
                numberOfStages++;
            }else if (answer.equalsIgnoreCase("No")){
                System.out.println("No hacer más etapas.");
                createStage = false;
            }else{
                System.out.println("Entrada no válida. Intente de nuevo.");
            }
        }
        super.setName(name);
        super.setDescription(description);
        this.stages = processStages;
        System.out.println("Se creó la producción '" + name + "' con " + numberOfStages + " etapas.");
    }


    public MyArrayList<RawMaterial> getRawMaterials() {
        return rawMaterials;
    }

    public ArrayQueue<Stage> getStages() {
        return stages;
    }

    public void setRawMaterials(MyArrayList<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public void setStages(ArrayQueue<Stage> stages) {
        this.stages = stages;
    }
}