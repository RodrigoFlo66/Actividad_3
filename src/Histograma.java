import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.ui.ApplicationFrame;


public class Histograma extends ApplicationFrame {

    public Histograma(String title, double[] data) {
        super(title);
        // Crear un conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Demanda", data, 50); // El último argumento es el número de bins
        // Crear el histograma
        JFreeChart chart = ChartFactory.createHistogram(
                title,
                "Valor",
                "Frecuencia",
                dataset
        );
        // Crear un panel para mostrar el histograma
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}
