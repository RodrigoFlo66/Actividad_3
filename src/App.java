
public class App {
    static Demanda demanda;
    static TiempoEntrega entrega;
    static double[] dataDemanda, dataTimpoEntrega; 

    public static void main(String[] args) {
        demanda = new Demanda();
        entrega = new TiempoEntrega();
        // Generar una muestra de demanda
        int iteraciones = 12;
        dataDemanda = new double[iteraciones];
        dataTimpoEntrega = new double[iteraciones];
        for (int i = 0; i < iteraciones; i++) {
            dataDemanda[i] =  demanda.generarDemanda(i);//usar i solo para 12 meses
            dataTimpoEntrega[i] =  entrega.generarTiempoEntrega();
        }
        demanda.getDataDemanda(dataDemanda);
        demanda.generaHistograma("Histograma de la demanda", dataDemanda);
        entrega.generaHistograma("Histograma de tiempo de entrega", dataTimpoEntrega);
    }
}
