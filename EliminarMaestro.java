package MaestrosBenitoJuarez;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class EliminarMaestro extends JFrame {

    private JPanel panel;
    private JButton boton1, boton2;
    private JLabel etiqueta1;
    private JTextField entrada1;
    
    private String curpMaestro = "";
    

    public EliminarMaestro() {
        setTitle("Eliminar a un Maestro ");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        panelPrincipal();
        menu();
    }

    private void panelPrincipal() {
        panel = new JPanel();
        panel.setBackground(new Color(33, 33, 33));
        panel.setSize(900, 700);
        panel.setLayout(null);
        getContentPane().add(this.panel);
    }

    private void menu() {
        JLabel texto = new JLabel("Eliminar la CURP un maestro ");
        texto.setBounds(330, 40, 500, 50);
        texto.setFont(new Font("Arial", Font.PLAIN, 23));
        texto.setForeground(Color.magenta);
        panel.add(texto);

        etiqueta1 = new JLabel("Ingresa CURP");
        etiqueta1.setBounds(250, 120, 190, 30);
        etiqueta1.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta1.setForeground(new Color(30, 184, 250));
        panel.add(etiqueta1);

        entrada1 = new JTextField();
        entrada1.setBounds(420, 120, 250, 30);
        entrada1.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada1.setForeground(Color.white);
        entrada1.setBackground(new Color(46, 46, 46));
        entrada1.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada1);
        

        boton1 = new JButton("Eliminar");
        boton1.setBounds(310, 300, 120, 40);
        boton1.setBackground(new Color(30, 184, 250));
        panel.add(boton1);

        boton2 = new JButton("Regresar");
        boton2.setBounds(470, 300, 120, 40);
        boton2.setBackground(new Color(245, 134, 7));
        panel.add(boton2);
        
        //poner un evento al boton para que extraiga el texto de la entrada1 
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Toolkit.getDefaultToolkit().beep();
                curpMaestro = entrada1.getText();

                String usuario = "root";
                String contraseña = "";

                try {
                    String server = "jdbc:mysql://localhost:3306/maestros";
                    Connection conexion = DriverManager.getConnection(server, usuario, contraseña);
                    Statement consulta = conexion.createStatement();

                    String sentencia = "DELETE FROM maestro WHERE curp = '" + curpMaestro + "';";
                    int filasAfectadas = consulta.executeUpdate(sentencia);

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "Maestro eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el maestro");
                    }

                } catch (Exception error) {
                    System.err.println(error.getMessage());
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                }

            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //Esto cierra solo la esta misma ventana
            }
        });

    }

}
