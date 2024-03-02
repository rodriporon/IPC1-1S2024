package Interfaz;

import org.example.Doctor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterfazAdministrador extends JFrame {
    private JTabbedPane tabbedPane;

    public InterfazAdministrador(List<Doctor> doctores) {
        initComponents(doctores);
    }

    private void initComponents(List<Doctor> doctores) {
        setTitle("Administrador");
        setSize(1200, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        // Crear pesta;a de Doctores

        JPanel panelDoctores = new JPanel(new BorderLayout());
        JTable tablaDoctores = new JTable();

        JLabel tituloPanelDoctores = new JLabel("Listado Doctores");
        tituloPanelDoctores.setHorizontalAlignment(SwingConstants.CENTER);
        panelDoctores.add(tituloPanelDoctores, BorderLayout.NORTH);

        DefaultTableModel modeloTablaDoctores = new DefaultTableModel();
        modeloTablaDoctores.addColumn("Codigo");
        modeloTablaDoctores.addColumn("Nombres");
        modeloTablaDoctores.addColumn("Apellidos");

        for (Doctor doctor : doctores) {
            modeloTablaDoctores.addRow(new Object[]{doctor.getCodigo(), doctor.getNombres(), doctor.getApellidos()});
        }
        tablaDoctores.setModel(modeloTablaDoctores);
        JScrollPane scrollPaneDoctores = new JScrollPane(tablaDoctores);
        panelDoctores.add(scrollPaneDoctores, BorderLayout.CENTER);

        JPanel panelGraficaEspecialidadesDoctores = new JPanel();

        Map<String, Integer> topEspecialidades = obtenerTopEspecialidades(doctores);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String especialidad : topEspecialidades.keySet()) {
            dataset.setValue(topEspecialidades.get(especialidad), "Especialidades", especialidad);
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Top de especialidades de Doctores",
                "Especialidad",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);

        panelGraficaEspecialidadesDoctores.add(chartPanel);

        panelDoctores.add(panelGraficaEspecialidadesDoctores, BorderLayout.SOUTH);

        JPanel panelBotonesDoctores = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnNuevoDoctor = new JButton("Registrar doctor");
        panelBotonesDoctores.add(btnNuevoDoctor);

        JButton btnActualizarDoctor = new JButton("Actualizar doctor");
        panelBotonesDoctores.add(btnActualizarDoctor);

        JButton btnEliminarDoctor = new JButton("Eliminar doctor");
        panelBotonesDoctores.add(btnEliminarDoctor);

        panelDoctores.add(panelBotonesDoctores, BorderLayout.EAST);

        tabbedPane.addTab("Doctores", panelDoctores);
        getContentPane().add(tabbedPane);
    }

    private Map<String, Integer> obtenerTopEspecialidades(List<Doctor> doctores) {
        Map<String, Integer> conteoEspecialidades = new HashMap<>();
        for (Doctor doctor : doctores) {
            String especialidad = doctor.getEspecialidad();
            conteoEspecialidades.put(especialidad, conteoEspecialidades.getOrDefault(especialidad, 0) + 1);
        }
        return conteoEspecialidades;
    }
}
