
public class App {
    public static void main(String[] args) {
        //valores inventario
        int inventarioInicial = 150;
        int ordenOptima = 200;
        int reordenOptimo = 100;

        Demanda demanda = new Demanda();
        TiempoEntrega entrega = new TiempoEntrega();
        Inventario inventario = new Inventario(inventarioInicial, ordenOptima, reordenOptimo);
        Tabla tabla = new Tabla();
        //datos
        double[] dataDemanda, dataTimpoEntrega, dataInventario; 
        String[] dataEntrega;
        // Generar una muestra de demanda
        int iteraciones = 12;
        dataDemanda = new double[iteraciones];
        dataTimpoEntrega = new double[iteraciones];
        for (int i = 0; i < iteraciones; i++) {
            dataDemanda[i] =  demanda.generarDemanda(i);//usar i solo para 12 meses
            dataTimpoEntrega[i] =  entrega.generarTiempoEntrega();
        }
        inventario.simularInventario(demanda, entrega);
        dataDemanda = inventario.getDataDemanda();
        dataInventario = inventario.getInventario();
        dataEntrega = inventario.getDataEntrega();
        tabla.crearTabla(dataInventario, dataDemanda, dataEntrega);
        //demanda.generaHistograma("Histograma de la demanda", dataDemanda);
        //entrega.generaHistograma("Histograma de tiempo de entrega", dataTimpoEntrega);
    }
}
