import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Atraccion relampago = new Atraccion("Relámpago", 40);
        Atraccion motoBala = new Atraccion("Moto Bala", 35);
        Atraccion rascacielos = new Atraccion("Rascacielos", 60);

        // ArrayList para llevar un registro de boletos y atracciones
        ArrayList<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(relampago);
        atracciones.add(motoBala);
        atracciones.add(rascacielos);

        ArrayList<Boleto> boletosVendidos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú de Parque de Diversiones:");
            System.out.println("1. Ver atracciones disponibles");
            System.out.println("2. Vender boletos");
            System.out.println("3. Ver boletos vendidos y disponibles");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Atracciones Disponibles:");
                    for (int i = 0; i < atracciones.size(); i++) {
                        System.out.println((i + 1) + ". " + atracciones.get(i).getNombre());
                    }
                    break;
                case 2:
                    System.out.print("Seleccione una atracción (1-" + atracciones.size() + "): ");
                    int opcionAtraccion = scanner.nextInt();
                    if (opcionAtraccion >= 1 && opcionAtraccion <= atracciones.size()) {
                        Atraccion atraccionSeleccionada = atracciones.get(opcionAtraccion - 1);
                        System.out.print("Ingrese la cantidad de boletos a vender: ");
                        int cantidadBoletos = scanner.nextInt();
                        if (atraccionSeleccionada.venderBoletos(cantidadBoletos)) {
                            boletosVendidos.add(new Boleto(atraccionSeleccionada.getNombre(), cantidadBoletos));
                            System.out.println("Venta exitosa.");
                        } else {
                            System.out.println("No hay suficientes boletos disponibles para esta atracción.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 3:
                    System.out.println("Boletos Vendidos y Disponibles:");
                    for (Atraccion atraccion : atracciones) {
                        System.out.println(atraccion.getNombre() + ": Vendidos - " + atraccion.getBoletosVendidos() +
                                ", Disponibles - " + (atraccion.getCapacidad() - atraccion.getBoletosVendidos()));
                    }
                    System.out.println("Registro de Boletos Vendidos:");
                    for (Boleto boleto : boletosVendidos) {
                        System.out.println("Atracción: " + boleto.getAtraccion() + ", Cantidad: " + boleto.getCantidad());
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        System.out.println("¡Gracias por visitar el Parque de Diversiones!");
    }

}