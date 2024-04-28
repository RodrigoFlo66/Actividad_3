public class Montecarlo{
static final int iteraciones = 12;
             double[] dataDemanda = new double[iteraciones];
             double[] dataTimpoEntrega = new double[iteraciones];
             double[] dataCosto=new double[iteraciones+1];
             double[] dataInventario=new double[iteraciones+1];
             String[] dataEntrega=new String[iteraciones+1];
             Tabla tabla = new Tabla();
             int q = 0;
            int r = 0;
    public void algoritmoMontecarlo() { 
            q = generarValorAleatorio();
            r = generarValorAleatorio();
            generaSimulacion(150, q, r);
    }
    public void generaSimulacion(int inventarioInicial,int ordenOptima,int reordenOptimo){
        Demanda demanda = new Demanda();
            TiempoEntrega entrega = new TiempoEntrega();
            Inventario inventario = new Inventario(inventarioInicial, ordenOptima, reordenOptimo);
            for (int i = 0; i < iteraciones; i++) {
                dataDemanda[i] =  demanda.generarDemanda(i);//usar i solo para 12 meses
                dataTimpoEntrega[i] =  entrega.generarTiempoEntrega();
            }
            inventario.simularInventario(demanda, entrega);
            dataDemanda = inventario.getDataDemanda();
            dataInventario = inventario.getInventario();
            dataEntrega = inventario.getDataEntrega();
            inventario.generateDataCosto();
            dataCosto = inventario.getDataCosto();
    }
    public  double generaCostoAnual(){
        double costoAnual = 0;
        for (double c : dataCosto) {
            costoAnual += c;
        }
        return costoAnual;
    }
    private  int generarValorAleatorio() {
        return (int) (Math.random() * 21) * 5 + 100; // Generar valores aleatorios entre 100 y 200 en incrementos de 5
    }    
    public void generaTablaMensual(){
        tabla.crearTabla(dataInventario, dataDemanda, dataEntrega, dataCosto, q, r);
    }
    public int getQ(){
        return q;
    }
    public int getR(){
        return r;
    }
}