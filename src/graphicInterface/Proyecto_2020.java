package graphicInterface;

import businessLogic.Logic;
import data.*;

import static data.DataBase.myArrayListProduction;


import java.io.IOException;
import java.util.Scanner;

//no
public class Proyecto_2020 {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logic logic = new Logic();


    static void menumain() throws IOException {
        System.out.println("**********************             MENU PRINCIPAL             **********************");
        System.out.println("                              ***1.Iniciar Sesion ***");
        System.out.println("                              ***2.Registrarse    ***");
        System.out.println("                              ***3.Cerrar programa***");
        System.out.print("\nSeleccione una de las opciones: ");
        int val = scanner.nextInt();
        scanner.nextLine();
        boolean check;
        switch (val) {
            case 1:
                check = logic.CheckSignIn();
                while (!check) {
                    System.out.print("¿Desea volver al menu principal?Si/No: ");
                    String back = scanner.nextLine();
                    if (back.equalsIgnoreCase("Si")) {
                        menumain();
                        check = true;
                    } else if (back.equalsIgnoreCase("No")) {
                        check = logic.CheckSignIn();
                    } else {
                        System.out.print("Valor no valido. Intente de nuevo.");
                    }
                }
                controlPanel();
                break;

            case 2:
                logic.SignUp();
                menumain();
                break;

            case 3:
                System.out.println("***");
                System.out.println("¡Esperamos que vuelva pronto!");
                System.out.println("***");
                DataBase.WriteArchive();
                System.exit(0);
                break;

            default:
                System.out.println("Valor no valido. Intente de nuevo");
                menumain();
        }

    }


    public static void controlPanel() throws IOException {
        System.out.println("**********************             PANEL DE CONTROL             **********************");
        System.out.println("                            ***  1.Crear producción     ***");
        System.out.println("                            ***  2.Gestionar producción ***");
        System.out.println("                            ***  3.Crear registro       ***");
        System.out.println("                            ***  4.Cerrar sesión        ***");
        int val = scanner.nextInt();
        switch (val) {
            case 1:
                Production newProduction = new Production();
                myArrayListProduction.pushBack(newProduction);
                manageMenu();
                break;
            case 2:
                manageMenu();
                break;
            case 3:
                reg();
                break;
            case 4:
                menumain();
                break;
            default:
                System.out.println("Valor no valido. Intente de nuevo");
                controlPanel();
                break;
        }
    }

    public static void reg() throws IOException {
        System.out.println("**********************             CREAR REGISTRO             **********************");
        scanner.nextLine();
        System.out.println("Buscar nombre de proceso:");
        String namep = scanner.nextLine();
        boolean test = true;
        for (int i = 0; i < myArrayListProduction.getSize(); i++) {
            if (myArrayListProduction.getItem(i).getName().equalsIgnoreCase(namep)) {
                myArrayListProduction.getItem(i).print(i);
                Boolean check = false;
                while (!check) {
                    System.out.print("¿Desea generar un archivo txt con el registro?Si/No: ");
                    String back = scanner.nextLine();
                    if (back.equalsIgnoreCase("Si")) {
                        DataBase.printTXT(i);
                        check = true;
                        test = false;
                        controlPanel();
                    } else if (back.equalsIgnoreCase("No")) {
                        test = false;
                        controlPanel();
                    } else {
                        System.out.print("Valor no valido. Intente de nuevo.");
                    }
                }

                break;
            }
        }
        if (test)
            System.out.println("--------La producción no fue encontrada--------");
        controlPanel();
    }

    public static void manageMenu() throws IOException {
        System.out.println("Seleccione la producción que desea gestionar:");
        for (int i = 0; i < myArrayListProduction.getSize(); i++) {
            System.out.print(i + 1 + ". ");
            myArrayListProduction.getItem(i).printBasicSummary();
        }
        System.out.println();
        System.out.println("0. Regresar al panel de control");
        int selection = scanner.nextInt();
        if (selection < 0 || selection > myArrayListProduction.getSize()) {
            System.out.println("Selección inválida, por favor intente nuevamente.");
            manageMenu();
        } else if (selection == 0) {
            controlPanel();
        } else {
            int selectedProduction = selection - 1;
            boolean repeatMenu = true;
            while (repeatMenu) {
                if (myArrayListProduction.getItem(selectedProduction).isActive()) {
                    myArrayListProduction.getItem(selectedProduction).printBasicSummary();
                    System.out.println("Seleccione que acción desea realizar con esta producción:");
                    System.out.println("1. Ver resumen");
                    System.out.println("2. Completar etapa actual");
                    System.out.println("0. Regresar a la selección de producción");
                    selection = scanner.nextInt();
                    //System.out.println(selection);
                    switch (selection) {
                        case 1:
                            myArrayListProduction.getItem(selectedProduction).printSummary();
                            break;
                        case 2:
                            System.out.println("Case 2");
                            myArrayListProduction.getItem(selectedProduction).nextStage();
                            if (myArrayListProduction.getItem(selectedProduction).isFinished()) {
                                repeatMenu = false;
                            }
                            manageMenu();
                            break;
                        case 0:
                            manageMenu();
                            break;
                        default:
                            System.out.println("Entrada inválida, por favor intente nuevamente.");
                            break;
                    }
                } else {
                    myArrayListProduction.getItem(selectedProduction).printBasicSummary();
                    System.out.println("Seleccione que acción desea realizar con esta producción:");
                    System.out.println("1. Iniciar producción");
                    System.out.println("0. Regresar a la selección de producción");
                    selection = scanner.nextInt();
                    System.out.println(selection);
                    switch (selection) {
                        case 1:
                            myArrayListProduction.getItem(selectedProduction).start();
                            break;
                        case 0:
                            manageMenu();
                            break;
                        default:
                            System.out.println("Entrada inválida, por favor intente nuevamente.");
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.print("************");
        System.out.print("Bienvenido al Software de gestión de producción con enfoque en la calidad del producto");
        System.out.println("************\n\n");

        System.out.println("Recuerde que la CALIDAD y EFICIENCIA en su produccion permiten atraer mas clientes.");
        System.out.println("Por ello creamos este software, deje que SGP garantice la seguridad y satisfaccion de sus clientes.\n");
        System.out.println("************\n");
        DataBase.loadArchive();
        menumain();

        //DataBase.reach("Nombredelaproduccion", "Informes"); forma de buscar una produccion en la base de datos
        //DataBase.eliminar("Nombredelaproducion"; Para eliminar un archivo


    }

}
