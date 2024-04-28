import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tabla {
    public void crearTabla(double[] costo, int[] q, int[] r) {
        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nro");
        modelo.addColumn("Costo Anual");
        modelo.addColumn("Orden");
        modelo.addColumn("Reorden");

        // Llenar el modelo con los datos de inventario y demanda
        for (int i = 0; i < q.length; i++) {
                modelo.addRow(new Object[]{i,costo[i], q[i], r[i]});
        }
        // Calcular el costo anual mínimo
        double minCosto = costo[0];
        int indexMinCosto = 0;
        for (int i = 1; i < costo.length; i++) {
            if (costo[i] < minCosto) {
                minCosto = costo[i];
                indexMinCosto = i;
            }
        }
        double qOptimo = q[indexMinCosto];
        double rOptimo = r[indexMinCosto];

        // Agregar una fila adicional para mostrar el costo mínimo y los valores óptimos de Q y R
        modelo.addRow(new Object[]{"Valor óptimo: "+indexMinCosto, minCosto, qOptimo, rOptimo});

        // Crear la tabla con el modelo
        JTable tabla = new JTable(modelo);

        // Crear un contenedor para la tabla (en este caso, JFrame)
        JFrame frame = new JFrame("Tabla simulacion de sistema de inventarios");
        frame.add(new JScrollPane(tabla)); // Agregar la tabla a un JScrollPane para permitir el desplazamiento

        // Configurar el JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
    public void crearTabla(double[] inventario, double[] demanda, String[] entrega, double[] costo, int q, int r) {
        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Mes");
        modelo.addColumn("Demanda");
        modelo.addColumn("Inventario");
        modelo.addColumn("Envío");
        modelo.addColumn("Costo");

        // Llenar el modelo con los datos de inventario y demanda
        for (int i = 0; i < inventario.length; i++) {
            if (i == 0)
                modelo.addRow(new Object[]{i, 0, inventario[i], entrega[i], costo[i]});
            else
                modelo.addRow(new Object[]{i, demanda[i - 1], inventario[i], entrega[i], costo[i]});
        }

        // Calcular el costo anual sumando todos los valores en el arreglo costo
        double costoAnual = 0;
        for (double c : costo) {
            costoAnual += c;
        }

        // Agregar una fila adicional para mostrar el costo anual
        modelo.addRow(new Object[]{"Costo Anual", "", "", "", costoAnual});
        modelo.addRow(new Object[]{"q(Orden)", "", "", "", q});
        modelo.addRow(new Object[]{"R(reorden)", "", "", "", r});

        // Crear la tabla con el modelo
        JTable tabla = new JTable(modelo);

        // Crear un contenedor para la tabla (en este caso, JFrame)
        JFrame frame = new JFrame("Tabla simulacion mensual");
        frame.add(new JScrollPane(tabla)); // Agregar la tabla a un JScrollPane para permitir el desplazamiento

        // Configurar el JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}


