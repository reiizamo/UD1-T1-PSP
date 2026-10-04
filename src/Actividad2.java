import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {
        int opcion = 1;
        try (Scanner sc = new Scanner(System.in)){
            do{
                menu();
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Valor no valido");
                    sc.next();
                }

                switch (opcion) {
                    case 1:
                        bloc_notas();
                        break;
                    case 2:
                        calculadora();
                        break;
                    case 3:
                        administrador();
                        break;
                    case 0:
                        System.out.println("Cerrando Programa...");
                        break;
                    default:
                        System.out.println("Valor no valido");
                        break;
                }
            

            }while (opcion != 0);
            System.out.println("Chaoo");
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("Menú: Escoge una opción.");
        System.out.println("=============================");
        System.out.println("1. Bloc de notas");
        System.out.println("2. Calculadora");
        System.out.println("3. Administrador de tareas");
        System.out.println("0. salir");
        System.out.println("=============================");
    }

    public static void bloc_notas(){
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        try {
            Process blocProcess = pb.start();
            System.out.println("PID del bloc de notas: " + blocProcess.pid());
            System.out.println("BLOC DE NOTAS > " + (blocProcess.isAlive()? "Estoy vivito y coleando" : "Más muerto que una pasa"));
        } catch (IOException e) {
            System.out.println("No se puedo iniciar el proceso");
            System.out.println(e.getMessage());
        }
    }

    public static void calculadora(){
        ProcessBuilder pb = new ProcessBuilder("calc.exe");
        try {
            Process calcProcess = pb.start();
            System.out.println("PID del bloc de notas: " + calcProcess.pid());
            System.out.println("CALCULADORA > " + (calcProcess.isAlive()? "Estoy vivito y coleando" : "Más muerto que una pasa"));
        } catch (IOException e) {
            System.out.println("No se puedo iniciar el proceso");
            System.out.println(e.getMessage());
        }
    }

    public static void administrador(){
        ProcessBuilder pb = new ProcessBuilder("taskmgr.exe");
        try {
            Process taskProcess = pb.start();
            System.out.println("PID del bloc de notas: " + taskProcess.pid());
            System.out.println("ADMINISTRADOR DE TAREAS > " + (taskProcess.isAlive()? "Estoy vivito y coleando" : "Más muerto que una pasa"));
        } catch (IOException e) {
            System.out.println("No se puedo iniciar el proceso");
            System.out.println(e.getMessage());
        }
    }
}

