
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemMenuRegistro, itemMenuRegistroD, itemMenuConsulta,itemMenuRegistroPaquetes,itemMenuConsultaD, itemMenuConsultaP;

    public VentanaPrincipal() {

        this.initComponentes();
        this.setTitle("Aplicacion Trasportadora - Delivery – Upar - Ventana Principal");
        //this.setSize(300, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void initComponentes() {

        this.barraMenu = new JMenuBar();
        this.setJMenuBar(this.barraMenu);

        this.menu = new JMenu("Opciones");
        this.barraMenu.add(this.menu);

        this.itemMenuRegistro = new JMenuItem("Registrar");
        this.itemMenuRegistro.addActionListener(this);
        this.menu.add(this.itemMenuRegistro);

        this.itemMenuConsulta = new JMenuItem("Consulta");
        this.itemMenuConsulta.addActionListener(this);
        this.menu.add(itemMenuConsulta);
        
        this.itemMenuRegistroD = new JMenuItem("Registro Destinatario");
        this.itemMenuRegistroD.addActionListener(this);
        this.menu.add(itemMenuRegistroD);
        
        this.itemMenuConsultaD = new JMenuItem("Consulta Destinatario");
        this.itemMenuConsultaD.addActionListener(this);
        this.menu.add(itemMenuConsultaD);
        
        this.itemMenuRegistroPaquetes = new JMenuItem("Registro Paquetes");
        this.itemMenuRegistroPaquetes.addActionListener(this);
        this.menu.add(itemMenuRegistroPaquetes);
        
        this.itemMenuConsultaP = new JMenuItem("Consulta Paquetes Registrados");
        this.itemMenuConsultaP.addActionListener(this);
        this.menu.add(itemMenuConsultaP);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.itemMenuRegistro) {

            VentanaRegistroRemitente registro = new VentanaRegistroRemitente(this, true);

        } else if (e.getSource() == this.itemMenuConsulta) {

            VentanaConsulta consulta = new VentanaConsulta(this, true);
            
        } else if (e.getSource() == this.itemMenuRegistroD) {
            VentanaRegistroDestinatario registro = new VentanaRegistroDestinatario(this, true);
            
         } else if (e.getSource() == this.itemMenuConsultaD) {
            VentanaConsultaDestinatario consulta = new VentanaConsultaDestinatario(this, true);
        }
        else if (e.getSource() == this.itemMenuRegistroPaquetes) {
            VentanaRegistroPaquetes registro = new VentanaRegistroPaquetes(this, true);
        }   
            else if(e.getSource() == this.itemMenuConsultaP) {
            VentanaConsultaPaquetes consulta = new VentanaConsultaPaquetes(this, true);
            
            

    }

}
}
