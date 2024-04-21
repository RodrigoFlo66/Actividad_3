import java.util.Random;
import org.jfree.ui.RefineryUtilities;
public class Demanda {
    static Random random = new Random();
    // Definir la distribución de probabilidad empírica
    private static final int[] valores = {35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60};
    private static final double[] probabilidades = {0.010, 0.015, 0.020, 0.020, 0.022, 0.023, 0.025, 0.027, 0.028, 0.029, 0.035, 0.045, 0.060, 0.065, 0.070, 0.080, 0.075, 0.070, 0.065, 0.060, 0.050, 0.040, 0.030, 0.016, 0.015, 0.005};
    private static final double[] factoresEstacionales = {1.20, 1.00, 0.90, 0.80, 0.80, 0.70, 0.80, 0.90, 1.00, 1.20, 1.30, 1.40};
    public int generarDemanda(int mes) {
        double R = random.nextDouble();
        // Obtener el factor estacional correspondiente al mes
        double factorEstacional = factoresEstacionales[mes];
        //Ajustar R segun el factor estacional
        R *= factorEstacional;
        if(R>1)
            return 61;
        // Calcular la demanda basada en la distribución acumulativa
        double acumulada = 0.0;
        for (int i = 0; i < probabilidades.length; i++) {
            acumulada += probabilidades[i];
            if (R <= acumulada) {
                return valores[i];
            }
        }
        return generarDemanda(mes);
    }
    public int generarDemanda() {
        double R = random.nextDouble();
        // Calcular la demanda basada en la distribución acumulativa
        double acumulada = 0.0;
        for (int i = 0; i < probabilidades.length; i++) {
            acumulada += probabilidades[i];
            if (R <= acumulada) {
                return valores[i];
            }
        }
        return generarDemanda();
    }
    public void generaHistograma(String titulo, double[] data){
        Histograma demo = new Histograma(titulo, data);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
    public void getDataDemanda(double[] data){
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
}
