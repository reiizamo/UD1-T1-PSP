import java.io.IOException;

public class Actividad1 {
    public static void main(String[] args) {
        System.out.println("PID del Padre: " + ProcessHandle.current().pid());

        ProcessBuilder pb = new ProcessBuilder("ping", "-n", "10", "127.0.0.1"); // Como pides que el proceso dure varios segundos use este comando.

        try {
            Process proceso = pb.start();
            System.out.println("PID del hijo: " + proceso.pid());
            System.out.println("HIJO > " + (proceso.isAlive()? "Estoy vivo" : "Me morí"));
            Thread.sleep(5000);
            System.out.println("HIJO > " + (proceso.isAlive()? "Estoy vivo" : "Me morí"));
            if (proceso.isAlive()){
                proceso.destroy();
                System.out.println("HIJO > Como estaba vivo me mataron.");
            }
            proceso.waitFor();
            System.out.println("Proceso Completamente Finalizado...");

            Process proceso2 = pb.start();
            proceso2.waitFor();
            System.out.println("HIJO2 > código de salida: " + proceso2.exitValue());
            if (proceso2.exitValue() == 0){
                System.out.println("Terminado correctamente...");
            }

        
        } catch (IOException e) {
            System.out.println("No se ha podido iniciar el proceso.");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido el proceso.");
            System.out.println(e.getMessage());
        }
    }
}