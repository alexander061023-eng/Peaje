import java.util.Random;

public class CabinaPeaje implements Runnable {

    public static int totalRecaudadoGlobal = 0;

    private String nombre;
    private int vehiculosAtendidos;
    private int vehiculosPorAtender;
    private Random random = new Random();

    public CabinaPeaje(String nombre, int vehiculosPorAtender) {
        this.nombre = nombre;
        this.vehiculosPorAtender = vehiculosPorAtender;
        this.vehiculosAtendidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }

    @Override
    public void run() {
        for (int i = 0; i < vehiculosPorAtender; i++) {
            try {
                int tiempo = 500 + random.nextInt(1001);
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpida.");
                return;
            }

            vehiculosAtendidos++;
            totalRecaudadoGlobal += 50;

            System.out.println(nombre + " atendio el vehiculo " + vehiculosAtendidos);
        }
    }
}