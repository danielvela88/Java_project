package MaestrosBenitoJuarez;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class EditarMaestro extends JFrame {
    //componentes de la ventana
    private JPanel panel;
    private JButton boton1, boton2;
    private JLabel etiqueta1, etiqueta2;
    private JTextField entrada1, entrada2;
    private JLabel etiqueta3;

    //Variables para datos que introducira el usuario
    private String curpMaestro = "";
    private String nuevoDato = "";
    private int salario;
    private  String opcionSelecionada;

    String usuario = "root";
    String contraseña = "";
    String sentencia;
    
    
    public EditarMaestro() {
        setTitle("Editar Salario de Maestro");
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
        panel.setBackground(new Color(33, 33, 33)); //Color del fondo
        panel.setSize(900, 700); //dimensiones del panel
        panel.setLayout(null); //Establecer layout en nulo
        getContentPane().add(this.panel); //Agregar el panel 
    }

    private void menu() {
        JLabel texto = new JLabel("Aqui puedes actualizar datos de un maestro");
        texto.setBounds(200, 40, 590, 50);
        texto.setFont(new Font("Arial", Font.PLAIN, 23));
        texto.setForeground(Color.magenta);
        panel.add(texto);
        
        //Etiquetas
        etiqueta1 = new JLabel("Ingresa CURP del maestro a editar");
        etiqueta1.setBounds(90, 120, 340, 30);
        etiqueta1.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta1.setForeground(new Color(30, 184, 250));
        panel.add(etiqueta1);
        
        etiqueta2 = new JLabel("Selecciona dato a editar");
        etiqueta2.setBounds(160, 230, 240, 30);
        etiqueta2.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta2.setForeground(new Color(30, 184, 250));
        panel.add(etiqueta2);
        
 
        //Entradas de texto para la CURP
        entrada1 = new JTextField();
        entrada1.setBounds(420, 120, 250, 30);
        entrada1.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada1.setForeground(Color.white);
        entrada1.setBackground(new Color(46, 46, 46));
        entrada1.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada1);
        
        //Items para lista desplegable
        String [] items = {
        "NOMBRE",
        "PRIMER APELLIDO", 
        "SEGUNDO APELLIDO", 
        "FECHA NACIMIENTO",
        "DOMICILIO",
        "TELEFONO",
        "CORREO",
        "SEXO",
        "SALARIO"};
        
        //Agregar la lista desplegable
        JComboBox lista = new JComboBox(items);
        lista.setBounds(420, 230 , 150, 30);
        panel.add(lista);
        
        //Mensaje que se mostrará y actualizará dependiendo el item que se seleccione
        etiqueta3 = new JLabel();
        etiqueta3.setText("Ingresa nuevo nombre");
        etiqueta3.setBounds(100, 480, 320, 30);
        etiqueta3.setFont(new Font("Arial", Font.PLAIN, 20));
        etiqueta3.setForeground(new Color(30, 184, 250));
        panel.add(etiqueta3);
        
        //Entrada de texto, aqui se introducira el dato correspondiente dependiedo el item seleccionado
        entrada2 = new JTextField();
        entrada2.setBounds(440, 480, 250, 30);
        entrada2.setFont(new Font("Arial", Font.PLAIN, 20));
        entrada2.setForeground(Color.white);
        entrada2.setBackground(new Color(46, 46, 46));
        entrada2.setBorder(BorderFactory.createLineBorder(new Color(194, 26, 255), 2, false));
        panel.add(entrada2);
        
        
        
        //Boton ACEPTAR
        boton1  = new JButton("Aceptar");
        boton1.setBounds(260,600,120,40);
        boton1.setBackground(new Color(30, 184, 250));
        panel.add(boton1);

        //Boton REGRESAR
        boton2  = new JButton("Regresar");
        boton2.setBounds(500,600,120,40);
        boton2.setBackground(new Color(245, 134, 7));
        panel.add(boton2);
        
        
        

        //Evento para la lista que se activa cuando se selecciona un item   
        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                //Obtener item seleccionda de la lista
                opcionSelecionada = (String) lista.getSelectedItem();

                if(opcionSelecionada.equals("NOMBRE")){
                    etiqueta3.setText("Ingresa nuevo nombre");
                }
                else if(opcionSelecionada.equals("PRIMER APELLIDO")){
                    etiqueta3.setText("Ingresa nuevo primer apellido");
                    
                }
                else if(opcionSelecionada.equals("SEGUNDO APELLIDO")){
                    etiqueta3.setText("Ingresa nuevo segundo apellido");
                    
                }
                else if(opcionSelecionada.equals("FECHA NACIMIENTO")){
                    etiqueta3.setText("Ingresa nueva fecha de nacimiento");
                    
                }
                else if(opcionSelecionada.equals("DOMICILIO")){
                    etiqueta3.setText("Ingresa nuevo domicilio");
                    
                }
                else if(opcionSelecionada.equals("TELEFONO")){
                    etiqueta3.setText("Ingresa nuevo numero de telefono");
                    
                }
                else if(opcionSelecionada.equals("CORREO")){
                    etiqueta3.setText("Ingresa nuevo correo electronico");
                    etiqueta3.setVisible(true);
                    entrada2.setVisible(true);
                }
                else if(opcionSelecionada.equals("SEXO")){
                    etiqueta3.setText("Ingresa nuevo tipo de sexo");
                    etiqueta3.setVisible(true);
                    entrada2.setVisible(true);
                }
                else if(opcionSelecionada.equals("SALARIO")){
                    etiqueta3.setText("Ingresa nuevo salario");
                    etiqueta3.setVisible(true);
                    entrada2.setVisible(true);
                }
            }
        });



        // Evento para el boton ACEPTAR
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                curpMaestro = entrada1.getText(); // Obtener CURP
                nuevoDato = entrada2.getText(); // Obtener nuevo dato

                // Conexion a la base de datos
                try {
                    String server = "jdbc:mysql://localhost:3306/maestros";
                    Connection conexion = DriverManager.getConnection(server, usuario, contraseña);
                    Statement consulta = conexion.createStatement();

                    // sentencia = "UPDATE maestro SET nombre = " + nuevoDato + " WHERE curp = '" + curpMaestro + "';";
                    if (opcionSelecionada.equals("NOMBRE")) {
                        sentencia = "UPDATE maestro SET nombre = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("PRIMER APELLIDO")) {
                        sentencia = "UPDATE maestro SET apellido1 = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("SEGUNDO APELLIDO")) {
                        sentencia = "UPDATE maestro SET apellido2 = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("FECHA NACIMIENTO")) {
                        sentencia = "UPDATE maestro SET fecha_nacimiento = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("DOMICILIO")) {
                        sentencia = "UPDATE maestro SET domicilio = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("TELEFONO")) {
                        sentencia = "UPDATE maestro SET telefono = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("CORREO")) {
                        sentencia = "UPDATE maestro SET correo_e = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("SEXO")) {
                        sentencia = "UPDATE maestro SET sexo = '" + nuevoDato + "' WHERE curp = '" + curpMaestro + "';";
                    } else if (opcionSelecionada.equals("SALARIO")) {
                        salario = Integer.parseInt(nuevoDato);//convertir Cadena de texto a Entero
                        sentencia = "UPDATE maestro SET salario = " + salario + " WHERE curp = '" + curpMaestro + "';";
                    }

                    int filasAfectadas = consulta.executeUpdate(sentencia);

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "Nombre del maestro actualizada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el maestro");
                    }

                } catch (Exception error) {
                    System.err.println(error.getMessage());
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                }

            }
        });

        //Evento para el boton REGRESAR 
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose(); //Esto cierra solo esta ventana
            }
        });
        
        
    }

    public static void main(String[] args) {
        new EditarMaestro();
    }

}

//Creo que escribir de esta forma es un poco complicado para mi ya que la mesa esta alta y yo chaparro, pero en fin ya me duelen los hombros
//Ahora eh cambiado de posicion y me es mas como escribir pero igual me duelen los hombros, mejor me voy a dormir
//Now I have changed of position and I feel more confortable but my shoulders hurt, better I am going to the bed
