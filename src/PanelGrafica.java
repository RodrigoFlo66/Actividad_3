
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PanelGrafica extends JPanel {
    public PanelGrafica(double[] dataInventario) {
        iniciarPanel();
        definirGrafica(dataInventario);
    }
    /**
     * Inicia el panel.
     */
    public void iniciarPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
    }

    /**
     * Define la gráfica del inventario vs. tiempo.
     *
     * @param dataInventario Arreglo de datos del inventario para cada mes.
     */
    public void definirGrafica(double[] dataInventario) {
        XYSeries series = new XYSeries("Gráfica Inventario VS Tiempo");
        for (int i = 0; i < dataInventario.length; i++) {
            series.add(i + 1, dataInventario[i]); // Suma 1 a i para comenzar desde el mes 1
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Inventario VS Tiempo",
                "Meses",
                "Inventario",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
    }
}
