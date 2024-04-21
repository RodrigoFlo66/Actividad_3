import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tabla {
    public void crearTabla(double[] inventario, double [] demanda, String[] entrega) {
        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Mes");
        modelo.addColumn("Demanda");
        modelo.addColumn("Inventario");
        modelo.addColumn("Envío");

        // Llenar el modelo con los datos de inventario y demanda
        for (int i = 0; i < inventario.length; i++) {
            if(i==0)
                modelo.addRow(new Object[]{i, 0, inventario[i], entrega[i]}); 
            else
                modelo.addRow(new Object[]{i, demanda[i-1], inventario[i], entrega[i]});
        }

        // Crear la tabla con el modelo
        JTable tabla = new JTable(modelo);

        // Crear un contenedor para la tabla (en este caso, JFrame)
        JFrame frame = new JFrame("Tabla de Inventario y Demanda");
        frame.add(new JScrollPane(tabla)); // Agregar la tabla a un JScrollPane para permitir el desplazamiento

        // Configurar el JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}

