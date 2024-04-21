import java.util.Random;

public class Inventario {
    private static final int MESES_EN_UN_ANIO = 12;
    private double[] inventario, dataDemanda;
    private String[] dataEntrega;
    private int ordenOptima, reordenOptimo;
    static boolean seOrdeno = false;
    Random random = new Random();

    public Inventario(int inventarioInicial, int ordenOptima, int reordenOptimo) {
        this.ordenOptima = ordenOptima;
        this.reordenOptimo = reordenOptimo;
        this.inventario = new double[MESES_EN_UN_ANIO + 1]; // +1 para el mes 0
        this.inventario[0] = inventarioInicial; // Inventario inicial para el mes 0
        this.dataDemanda = new double[MESES_EN_UN_ANIO];
        this.dataEntrega = new String[MESES_EN_UN_ANIO+1];
    }

    public void simularInventario(Demanda deman, TiempoEntrega entrega) {
        for (int mes = 1; mes <= MESES_EN_UN_ANIO; mes++) {
            // Generar demanda para el mes actual
            int demanda = deman.generarDemanda(mes-1);
            //Verificar si llegamos al mes donde nos llega la orden.
            double inv = inventario[mes];
            double optimo = ordenOptima+0.0;
            if(inv==optimo)
                seOrdeno=false;
            // Calcular inventario para el mes actual
            double inventarioActualDouble = inventario[mes] + inventario[mes - 1] - demanda;
            int inventarioActual = (int) Math.round(inventarioActualDouble);
            if(!seOrdeno)
                if (inventarioActual < reordenOptimo) {
                dataEntrega[mes]="Se pide";
                seOrdeno = true;
                // Realizar una orden si el inventario es menor que el punto de reorden
                int tiempoEntrega = entrega.generarTiempoEntrega();
                int mesLlegadaOrden = mes + tiempoEntrega;
                    if (mesLlegadaOrden <= MESES_EN_UN_ANIO) {
                    dataEntrega[mesLlegadaOrden] = "Llega";
                    inventario[mesLlegadaOrden] += ordenOptima; 
                    }
                }
            dataDemanda[mes-1] = demanda;
            inventario[mes] = inventarioActual;
        }
    }
    public double[] getInventario() {
        return inventario;
    }
    public double[] getDataDemanda() {
        return dataDemanda;
    }
    public String[] getDataEntrega() {
        return dataEntrega;
    }
}

