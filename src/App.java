import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de iteraciones: ");
        int iteraciones = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()
        double[] dataCostos = new double[iteraciones];
        int[] dataQ = new int[iteraciones];
        int[] dataR = new int[iteraciones];
        Tabla tabla = new Tabla();
        for(int i = 0; i< iteraciones; i++){
            Montecarlo algMontecarlo = new Montecarlo();
            algMontecarlo.algoritmoMontecarlo();
            if(i<3)
                algMontecarlo.generaTablaMensual();
            dataCostos[i] = algMontecarlo.generaCostoAnual();
            dataQ[i] = algMontecarlo.getQ();
            dataR[i] = algMontecarlo.getR();
        }
        tabla.crearTabla(dataCostos, dataQ, dataR);
    }
}
