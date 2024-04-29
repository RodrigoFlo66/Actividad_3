import java.util.Random;
import org.jfree.ui.RefineryUtilities;
public class TiempoEntrega {
    static Random random = new Random();
    // Definir la distribución de probabilidad para el tiempo de entrega
    private static final int[] meses = {1, 2, 3};
    private static final double[] probabilidades = {0.30, 0.40, 0.30};

    public int generarTiempoEntrega() {
        double randomValue = random.nextDouble();
        // Calcular el tiempo de entrega basado en la distribución acumulativa
        double acumulada = 0.0;
        for (int i = 0; i < probabilidades.length; i++) {
            acumulada += probabilidades[i];
            if (randomValue <= acumulada) {
                return meses[i];
            }
        }
        return generarTiempoEntrega();
    }
    public void generaHistograma(String titulo, double[] data){
        Histograma demo = new Histograma(titulo, data);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
    
}
