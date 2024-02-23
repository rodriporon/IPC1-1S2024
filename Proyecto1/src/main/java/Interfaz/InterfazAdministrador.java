package Interfaz;

import org.example.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

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

        tabbedPane.addTab("Doctores", panelDoctores);
        getContentPane().add(tabbedPane);
    }
}
