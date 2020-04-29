package data;

import Estructuras_de_datos.MyArrayList;

import java.time.LocalDateTime;

import static graphicInterface.Proyecto_2020.scanner;


public class RawMaterial {

    private String name;
    private String admissionDate;
    private String expirationDate;
    private String batch;
    private String description;
    private MyArrayList<Parameter> parameterList;


    public RawMaterial() {
        System.out.println("Ingrese el nombre del material:");
        String name = scanner.nextLine();
        setName(name);
        System.out.println("Nombre del material: " + name);
        System.out.println("Ingrese la descripción de la etapa:");
        String description = scanner.nextLine();
        setDescription(description);
        System.out.println("Descripción del material: " + description);
        System.out.println("Cree parámetros de calidad del material:");
        MyArrayList<Parameter> parameterList = new MyArrayList<>();
        Parameter parameter = new Parameter();
        parameter.setValue(0);
        parameterList.pushBack(parameter);
        boolean createParameter = true;
        while (createParameter) {
            System.out.println("¿Desea agregar más parámetros de calidad al material?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Si")) {
                parameter = new Parameter();
                parameter.setValue(0);
                parameterList.pushBack(parameter);
            } else if (answer.equalsIgnoreCase("No")) {
                System.out.println("Creación de material finalizada.");
                createParameter = false;
            } else {
                System.out.println("Entrada no válida. Intente de nuevo.");
            }
        }
        System.out.println("Se creó el material con "
                + parameterList.getSize() + " parámetros de calidad.");
        this.parameterList = parameterList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MyArrayList<Parameter> getParametrosCalidad() {
        return parameterList;
    }

    public void setParameterList(MyArrayList<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public RawMaterial(String name, String admissionDate, String expirationDate, String batch, String description, MyArrayList<Parameter> parameterList) {
        this.name = name;
        this.admissionDate = admissionDate;
        this.expirationDate = expirationDate;
        this.batch = batch;
        this.description = description;
        this.parameterList = parameterList;
    }

    @Override
    public String toString() {
        return (name + ";" + admissionDate + ";" + expirationDate + ";" + batch + ";" + description);
    }
}
