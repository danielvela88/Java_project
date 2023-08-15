package MaestrosBenitoJuarez;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VentanaPrincipal extends JFrame {

    private JPanel panel;
    private JButton boton1, boton2, boton3, boton4, boton5;
    private JLabel etiqueta1;

    public VentanaPrincipal() {
        setTitle("Maestros de Escuela 'Benito juares' ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        iniciarComponentes(); //En este metodo estan los demas metodos
    }

    public void iniciarComponentes() {
        panelPrincipal();
        menu();
    }

    public void panelPrincipal() {
        panel = new JPanel();
        panel.setBackground(new Color(33, 33, 33));
        panel.setSize(900, 700);
        panel.setLayout(null);
        getContentPane().add(this.panel); //Añadir panel a la ventana
    }

    //Dentro de este metodo van todos los componentes
    public void menu() {
        etiqueta1 = new JLabel("Base de datos de Maestros de Escuela Benito Juarez");
        etiqueta1.setForeground(Color.white);
        etiqueta1.setBounds(280, 10, 400, 40);
        panel.add(etiqueta1);

        boton1 = new JButton("Ver lista de  Maestros");
        boton1.setBounds(300, 50, 160, 80);
        boton1.setBackground(new Color(242, 195, 75));
        panel.add(boton1);

        boton2 = new JButton("Agregar Maestro");
        boton2.setBounds(300, 140, 160, 80);
        panel.add(boton2);
        boton2.setBackground(new Color(242, 195, 75));

        boton3 = new JButton("Eliminar Maestro");
        boton3.setBounds(300, 230, 160, 80);
        boton3.setBackground(new Color(242, 195, 75));
        panel.add(boton3);

        boton4 = new JButton("Editar Datos Maestro");
        boton4.setBounds(300, 320, 160, 80);
        boton4.setBackground(new Color(242, 195, 75));
        panel.add(boton4);
        
        boton5 = new JButton("Salir");
        boton5.setBounds(300, 410, 160, 80);
        boton5.setBackground(new Color(242, 195, 75));
        panel.add(boton5);

        //Eventos para cada boton
        //Evento para boton "Lista de maestros"
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListaMaestros(); //Abre ventana "Lista Maestros"
            }
        });
        
        //Evento para boton "Agregar maestros"
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarMaestro(); //Abre ventana "AgregarMaestro"
            }
        });

        //Eventos para boton "Eliminar maestros"
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarMaestro(); //Abre la ventana "Eliminar Maestro" 
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditarMaestro(); //Abre la ventana "Editar maestro"
            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  //Cierra solo esta misma ventana
            }
        });

    }

    public static void main(String[] args) {
        new VentanaPrincipal(); //Llama esta ventana
    }

}

