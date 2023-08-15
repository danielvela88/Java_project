package MaestrosBenitoJuarez;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ListaMaestros extends JFrame {

    private JPanel panel;
    private JButton boton1;
    private JLabel etiqueta1, etiqueta2;
    private JTextArea areaTexto1;

    public ListaMaestros() {
        setTitle("Aqui esta toda la lista de Maestros");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        panelPrincipal();
        menu();
    }

    private void panelPrincipal() {
        panel = new JPanel();
        panel.setBackground(new Color(33, 33, 33));
        panel.setSize(1200, 700);
        panel.setLayout(null);
        getContentPane().add(this.panel);
    }
    
    private void menu() {
        JLabel texto = new JLabel("Hola, aqui puedes ver a cada uno de los Maestros");
        texto.setBounds(340, 20, 590, 50);
        texto.setFont(new Font("Arial", Font.PLAIN, 23));
        texto.setForeground(Color.magenta);
        panel.add(texto);
        
        etiqueta1 = new JLabel("Nombre              Apellido1           Apellido2            F_nacimiento     CURP          "+"\t"+"                                Domicilio");
        etiqueta1.setBounds(45, 60, 900, 50);
        etiqueta1.setFont(new Font("Arial", Font.PLAIN, 11));
        etiqueta1.setForeground(new Color(33, 184, 250));
        panel.add(etiqueta1);
        
        etiqueta2 = new JLabel(" Telefono            Correo_electronico                     Sexo                  Salario");
        etiqueta2.setBounds(710, 60, 900, 50);
        etiqueta2.setFont(new Font("Arial", Font.PLAIN, 11));
        etiqueta2.setForeground(new Color(33, 184, 250));
        panel.add(etiqueta2);
        
        
        
        //Aqui aparecen toda las lista de los maestros
        areaTexto1 = new JTextArea();
        areaTexto1.setBounds(45, 100, 1100, 400);
        areaTexto1.setEditable(false);
        areaTexto1.setForeground(new Color(255,255,250));
        areaTexto1.setBackground(new Color(33,33,33));
        areaTexto1.setBorder(BorderFactory.createLineBorder(new Color(30, 184, 250), 1, false));
        panel.add(areaTexto1);
        
        
        
        
        String usuario = "root";
        String contraseña = "";
        
        String resultado = "";
        String sentencia = "SELECT * FROM maestro;";

        try {
            String server = "jdbc:mysql://localhost:3306/maestros";
            Connection conexion = DriverManager.getConnection(server, usuario, contraseña);
            Statement consulta = conexion.createStatement();

            
            ResultSet rs = consulta.executeQuery(sentencia);
            while (rs.next()) {
               resultado += rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getString(9) + " \t" + rs.getInt(10)  +"\n";
            }
            
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay registros de maestros");
            } else {
                areaTexto1.setText(resultado);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }



        boton1 = new JButton("Regresar");
        boton1.setBounds(530, 600, 120, 40);
        boton1.setBackground(new Color(30, 184, 250));
        panel.add(boton1);
        
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
    
}
