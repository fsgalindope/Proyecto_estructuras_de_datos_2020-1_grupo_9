package data;

import java.util.Scanner;

import static graphicInterface.Proyecto_2020.scanner;

public class Parameter {
    private String name;
    private double value;
    private double lowerLimit;
    private double upperLimit;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Parameter() {
        System.out.println("Creación de parámetro");
        System.out.println("Ingrese el nombre del parámetro");
        this.name = scanner.nextLine();
        boolean validLowerInput = false;
        while (!validLowerInput) {
            System.out.println("Digite limite inferior");
            try {
                this.lowerLimit = scanner.nextDouble();
                validLowerInput = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida, intente nuevamente");
                scanner.nextLine();
            }
        }
        boolean validUpperInput = false;
        while (!validUpperInput) {
            System.out.println("Digite limite superior");
            try {
                this.upperLimit = scanner.nextDouble();
                validUpperInput = true;
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida, intente nuevamente");
                scanner.nextLine();
            }
        }
    }

    public Parameter(String name, double value, double lowerLimit, double upperLimit) {
        this.name = name;
        this.value = value;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public boolean satisfyQuality() {
        return (lowerLimit <= value) && (value <= upperLimit);

    }


    @Override
    public String toString() {
        return (name + ";" + String.valueOf(value) + ";" + String.valueOf(lowerLimit) + ";" + String.valueOf(upperLimit));
    }

}
