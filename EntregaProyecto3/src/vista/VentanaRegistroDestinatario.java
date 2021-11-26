package vista;

import entidades.RegistroD;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import modelo.RegistroDestinatario;

public class VentanaRegistroDestinatario extends JDialog {

    private Container contenedor;
    private JPanel panelDatos, panelBotones;
    private JLabel lNumpaquete, lDia, lMes, lAno, lNombre, lCalleyCarrera, lTelefono, lCodPostal, lNumVivienda;
    private JTextField tNombre, tCalleyCarrera, tTelefono, tNumVivienda, tAno;
    private JFormattedTextField ftNumpaquete;
    private JComboBox cbCodPostal;
    private JSpinner jsDia, jsMes;
    private JButton bGuardar, bBuscar, bELiminar, bCancelar;
    private String nombre;
    private final RegistroDestinatario modelo;

    public VentanaRegistroDestinatario(JFrame owner, boolean modal) {
        super(owner, modal);
        this.modelo = new RegistroDestinatario();
        this.initComponentes();
        this.setTitle("Registro de Destinatarios - Delybe Upar - Ventana de registro");
        //this.pack();
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());

        this.initPanelDatos();
        this.initPanelBotones();

    }

    public void initPanelDatos() {

        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(10, 2, 5, 5));

        this.lNumpaquete = new JLabel("Num Paquete: ");
        this.lDia = new JLabel("Fecha Aprox de Entrega: Dia");
        this.lMes = new JLabel("Mes: ");
        this.lAno = new JLabel("Año: ");
        this.lNombre = new JLabel("Nombre: ");
        this.lCalleyCarrera = new JLabel("Calle/Carrera: ");
        this.lTelefono = new JLabel("Telefono: ");
        this.lCodPostal = new JLabel("Codigo Postal: ");
        this.lNumVivienda = new JLabel("Num Vivienda: ");

        try {
            MaskFormatter MascaraNumPaquete = new MaskFormatter("#######");
            this.ftNumpaquete = new JFormattedTextField(MascaraNumPaquete);
        } catch (ParseException ex) {
        }

        SpinnerNumberModel modeloJSDia = new SpinnerNumberModel(1, 1, 31, 1);
        this.jsDia = new JSpinner(modeloJSDia);

        SpinnerNumberModel modeloJSMes = new SpinnerNumberModel(1, 1, 12, 1);
        this.jsMes = new JSpinner(modeloJSMes);

        this.tAno = new JTextField(null);
        this.tNombre = new JTextField(null);
        this.tCalleyCarrera = new JTextField(null);
        this.tTelefono = new JTextField(null);
        this.cbCodPostal = new JComboBox();
        this.cbCodPostal.addItem("200001");
        this.cbCodPostal.addItem("200002");
        this.cbCodPostal.addItem("200003");
        this.cbCodPostal.addItem("200004");
        this.cbCodPostal.addItem("200005");
        this.cbCodPostal.addItem("200007");
        this.cbCodPostal.addItem("200008");
        this.cbCodPostal.addItem("200009");
        this.cbCodPostal.addItem("200017");
        this.cbCodPostal.addItem("200018");

        this.tNumVivienda = new JTextField(null);

        this.panelDatos.add(this.lNumpaquete);
        this.panelDatos.add(this.ftNumpaquete);

        this.panelDatos.add(this.lDia);
        this.panelDatos.add(this.jsDia);

        this.panelDatos.add(this.lMes);
        this.panelDatos.add(this.jsMes);

        this.panelDatos.add(this.lAno);
        this.panelDatos.add(this.tAno);

        this.panelDatos.add(this.lNombre);
        this.panelDatos.add(this.tNombre);

        this.panelDatos.add(this.lCalleyCarrera);
        this.panelDatos.add(this.tCalleyCarrera);

        this.panelDatos.add(this.lTelefono);
        this.panelDatos.add(this.tTelefono);

        this.panelDatos.add(this.lCodPostal);
        this.panelDatos.add(this.cbCodPostal);

        this.panelDatos.add(this.lNumVivienda);
        this.panelDatos.add(this.tNumVivienda);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);

    }

    public void initPanelBotones() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4, 1, 5, 5));

        this.bGuardar = new JButton("Guardar");
        this.bCancelar = new JButton("Cancelar");
        this.bELiminar = new JButton("Eliminar");

        panel.add(this.bGuardar);
        this.bGuardar.addActionListener(new clickBotonGuardar());
        panel.add(this.bELiminar);
        this.bELiminar.addActionListener(new clickBotonEliminar());
        panel.add(this.bCancelar);
        this.bCancelar.addActionListener(new clickBotonCancelar());

        this.panelBotones = new JPanel();
        this.panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelBotones.setLayout(new FlowLayout());

        this.panelBotones.add(panel);

        this.contenedor.add(this.panelBotones, BorderLayout.EAST);

    }

    public RegistroD leerDatos() {

        RegistroD r = new RegistroD();
        Object numPaquete = this.ftNumpaquete.getValue();
        if (numPaquete != null) {
            r.setNumPaquete(Integer.valueOf(this.ftNumpaquete.getValue().toString())); // por ser JFormattedTextField
        } else {
            r.setNumPaquete(0);
        }

        r.setDia(Integer.valueOf(this.jsDia.getValue().toString()));
        r.setMes(Integer.valueOf(this.jsMes.getValue().toString()));
        r.setAno(Integer.valueOf(this.tAno.getText()));
        r.setNombre(this.tNombre.getText());
        r.setCalleYCarrera(this.tCalleyCarrera.getText());
        r.setTelefono(this.tTelefono.getText());
        r.setCodPostal(Integer.valueOf(this.cbCodPostal.getSelectedItem().toString()));
        r.setNumVivienda(Double.valueOf(this.tNumVivienda.getText()));
        return r;
    }

    public void guardar() {

        RegistroD r = this.leerDatos();

        try {
            this.modelo.registrar(r);
            VentanaEmergente.msgConfirmacion("Registro Exitoso", "El registro fue exitoso", JOptionPane.INFORMATION_MESSAGE, this);

        } catch (IOException ex) {
            VentanaEmergente.msgConfirmacion("Excepcion", ex.getMessage(), JOptionPane.ERROR_MESSAGE, this);

        } catch (NullPointerException ne) {
            VentanaEmergente.msgConfirmacion("Validacion", ne.getMessage(), JOptionPane.ERROR_MESSAGE, this);
        }

    }

    //escuchador evento click para boton guardar
    class clickBotonGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Click en guardar");
            guardar();
        }

    }

    class clickBotonEliminar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    class clickBotonCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
