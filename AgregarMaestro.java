package MaestrosBenitoJuarez;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AgregarMaestro extends JFrame {

    //Componente de la interfaz grafica
    private JPanel panel;
    private JButton boton1, boton2;
    private JLabel texto, etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6, etiqueta7, etiqueta8, etiqueta9, etiqueta10;
    private JTextField entrada1, entrada2, entrada3, entrada4;
    
    private JTextField entrada5, entrada6, entrada7, entrada8, entrada9, entrada10;

    //Datos para la base de datos
    //Dates for the database
    private String usuario = "root";
    private String contraseña = "";

    //Variables para guardar datos de los maestros
    //Variables for save dates of the teachers
    private String nombre = "";
    private String apellido1 = "";
    private String apellido2 = "";
    private String fecha_nacimiento = "";
    private String curp = "";
    private String domicilio = "";
    private String telefono = "";
    private String correo = "";
    private String sexo = "";
    private String salarioTexto = "";
    private int salario = 0;

    public AgregarMaestro() {
        setTitle("Agregar nuevo Maestro ");
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

    public void menu() {

        texto = new JLabel("Rellena los campos con los datos correspondientes");
        texto.setFont(new Font("Arial", Font.PLAIN, 23));
        texto.setForeground(Color.magenta);
        texto.setBounds(160, 5, 580, 50);
        panel.add(texto);

        etiqueta1 = new JLabel("Nombre");
        etiqueta1.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta1.setForeground(new Color(30, 184, 250));
        etiqueta1.setBounds(170, 100, 150, 30);
        panel.add(etiqueta1);

        etiqueta2 = new JLabel("Primer apellido");
        etiqueta2.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta2.setForeground(new Color(30, 184, 250));
        etiqueta2.setBounds(170, 140, 200, 30);
        panel.add(etiqueta2);

        etiqueta3 = new JLabel("Segundo apellido ");
        etiqueta3.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta3.setForeground(new Color(30, 184, 250));
        etiqueta3.setBounds(170, 180, 200, 30);
        panel.add(etiqueta3);

        etiqueta4 = new JLabel("Fecha de nacimiento");
        etiqueta4.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta4.setForeground(new Color(30, 184, 250));
        etiqueta4.setBounds(170, 220, 200, 30);
        panel.add(etiqueta4);

        etiqueta5 = new JLabel("CURP ");
        etiqueta5.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta5.setForeground(new Color(30, 184, 250));
        etiqueta5.setBounds(170, 260, 150, 30);
        panel.add(etiqueta5);

        etiqueta6 = new JLabel("Domicilio");
        etiqueta6.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta6.setForeground(new Color(30, 184, 250));
        etiqueta6.setBounds(170, 300, 150, 30);
        panel.add(etiqueta6);

        etiqueta7 = new JLabel("Telefono");
        etiqueta7.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta7.setForeground(new Color(30, 184, 250));
        etiqueta7.setBounds(170, 340, 150, 30);
        panel.add(etiqueta7);

        etiqueta8 = new JLabel("Correo electronico");
        etiqueta8.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta8.setForeground(new Color(30, 184, 250));
        etiqueta8.setBounds(170, 380, 200, 30);
        panel.add(etiqueta8);

        etiqueta9 = new JLabel("Sexo");
        etiqueta9.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta9.setForeground(new Color(30, 184, 250));
        etiqueta9.setBounds(170, 420, 150, 30);
        panel.add(etiqueta9);

        etiqueta10 = new JLabel("Salario");
        etiqueta10.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta10.setForeground(new Color(30, 184, 250));
        etiqueta10.setBounds(170, 460, 150, 30);
        panel.add(etiqueta10);

        //Entradas de texto---------------------------------------------------------
        entrada1 = new JTextField();
        entrada1.setBounds(400, 100, 250, 30);
        entrada1.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada1.setForeground(Color.white);
        entrada1.setBackground(new Color(46, 46, 46));
        entrada1.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));  //boton3.setBorder(BorderFactory.createLineBorder(Color.green, 3, true));
        panel.add(entrada1);

        entrada2 = new JTextField();
        entrada2.setBounds(400, 140, 250, 30);
        entrada2.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada2.setForeground(Color.white);
        entrada2.setBackground(new Color(46, 46, 46));
        entrada2.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada2);

        entrada3 = new JTextField();
        entrada3.setBounds(400, 180, 250, 30);
        entrada3.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada3.setForeground(Color.white);
        entrada3.setBackground(new Color(46, 46, 46));
        entrada3.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada3);

        entrada4 = new JTextField();
        entrada4.setBounds(400, 220, 250, 30);
        entrada4.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada4.setForeground(Color.white);
        entrada4.setBackground(new Color(46, 46, 46));
        entrada4.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada4);

        entrada5 = new JTextField();
        entrada5.setBounds(400, 260, 250, 30);
        entrada5.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada5.setForeground(Color.white);
        entrada5.setBackground(new Color(46, 46, 46));
        entrada5.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada5);

        entrada6 = new JTextField();
        entrada6.setBounds(400, 300, 250, 30);
        entrada6.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada6.setForeground(Color.white);
        entrada6.setBackground(new Color(46, 46, 46));
        entrada6.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada6);

        entrada7 = new JTextField();
        entrada7.setBounds(400, 340, 250, 30);
        entrada7.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada7.setForeground(Color.white);
        entrada7.setBackground(new Color(46, 46, 46));
        entrada7.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada7);

        entrada8 = new JTextField();
        entrada8.setBounds(400, 380, 250, 30);
        entrada8.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada8.setForeground(Color.white);
        entrada8.setBackground(new Color(46, 46, 46));
        entrada8.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada8);

        entrada9 = new JTextField();
        entrada9.setBounds(400, 420, 250, 30);
        entrada9.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada9.setForeground(Color.white);
        entrada9.setBackground(new Color(46, 46, 46));
        entrada9.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada9);

        entrada10 = new JTextField();
        entrada10.setBounds(400, 460, 250, 30);
        entrada10.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada10.setForeground(Color.white);
        entrada10.setBackground(new Color(46, 46, 46));
        entrada10.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada10);

        boton1 = new JButton("Guardar");
        boton1.setBounds(250, 600, 120, 40);
        boton1.setBackground(new Color(30, 184, 250));
        panel.add(boton1);

        boton2 = new JButton("Regresar");
        boton2.setBounds(500, 600, 120, 40);
        boton2.setBackground(new Color(245, 134, 7));
        panel.add(boton2);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre = entrada1.getText();
                apellido1 = entrada2.getText();
                apellido2 = entrada3.getText();
                fecha_nacimiento = entrada4.getText();
                curp = entrada5.getText();
                domicilio = entrada6.getText();
                telefono = entrada7.getText();
                correo = entrada8.getText();
                sexo = entrada9.getText();

                salarioTexto = entrada10.getText(); //Obtenemos texto de la etiqueta
                salario = Integer.parseInt(salarioTexto); //convertimos el texto a entero

                try {
                    String server = "jdbc:mysql://localhost:3306/maestros";
                    Connection conexion = DriverManager.getConnection(server, usuario, contraseña);
                    Statement consulta = conexion.createStatement();

                    String sentencia = "INSERT INTO maestro (nombre, apellido1, apellido2, fecha_nacimiento, curp, domicilio, telefono, correo_e, sexo, salario) VALUES ('" + nombre + "', '" + apellido1 + "','" + apellido2 + "','" + fecha_nacimiento + "','" + curp + "','" + domicilio + "','" + telefono + "','" + correo + "','" + sexo + "', " + salario + ");";
                    int filasAfectadas = consulta.executeUpdate(sentencia);

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario");
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
                dispose(); //Esto cierra la ventana AgregarMaestro
            }
        });

    }

}

/*
        radioBoton1 = new JRadioButton("Hombre");
        radioBoton1.setBounds(340, 460, 120, 30);
        radioBoton1.setFont(new Font("Arial", Font.PLAIN, 20));
        radioBoton1.setBackground(new Color(33, 33, 33));
        radioBoton1.setForeground(new Color(194, 26, 255));
        panel.add(radioBoton1);

        radioBoton2 = new JRadioButton("Mujer");
        radioBoton2.setBounds(460, 460, 120, 30);
        radioBoton2.setFont(new Font("Arial", Font.PLAIN, 20));
        radioBoton2.setBackground(new Color(33, 33, 33));
        radioBoton2.setForeground(new Color(194, 26, 255));
        panel.add(radioBoton2);

        ButtonGroup grupoRadios = new ButtonGroup(); // Esto es para que solo se marque uno a la vez
        grupoRadios.add(radioBoton1);
        grupoRadios.add(radioBoton2);

 */

