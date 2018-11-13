package practica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JPanel contentPane;
    public JTextField  textoListar;
    public JLabel textoConectar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ClienteFTP c = new ClienteFTP();
        c.conectar("192.168.1.59", "formacion", "formacion");
    }

    /**
     * Create the frame.
     */
    public Menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMenFtp = new JLabel("Menú FTP");
        lblMenFtp.setBounds(192, 6, 61, 16);
        contentPane.add(lblMenFtp);

        //---------------------BOTONES------------------------------------------------------------

        //Botón Conectar--------------------------------------------------------------------------

        final JButton conectar = new JButton("Conectar");
        conectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP c = new ClienteFTP();
                c.conectar("192.168.1.59", "formacion", "formacion");
                JLabel labelConectar = new JLabel("Conexión");
                labelConectar.setBounds(175, 40, 61, 16);
                contentPane.add(labelConectar);
                labelConectar.setText("Estableciendo conexión");

            }
        });
        conectar.setBounds(0, 35, 117, 29);
        contentPane.add(conectar);

        //Botón Listar----------------------------------------------------------------------------

        JButton listar = new JButton("Listar ficheros");
        listar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP l = new ClienteFTP();
                l.listarFicheros();
                JLabel labelListar = new JLabel("Listar");
                labelListar.setBounds(162, 81, 213, 16);
                contentPane.add(labelListar);
                labelListar.setText("Listando ficheros por consola");

            }
        });
        listar.setBounds(0, 76, 117, 29);
        contentPane.add(listar);

        //Botón Subir------------------------------------------------------------------------------

        JButton subir = new JButton("Subir Fichero");
        subir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP s = new ClienteFTP();
                s.subirFichero("/Users/antonio/Desktop/ficheroPrueba3.txt",
                        "ficheroPrueba3.txt",
                        "/home/formacion/");
                JLabel labelSubir = new JLabel("Subir");
                labelSubir.setBounds(162, 122, 227, 16);
                contentPane.add(labelSubir);
                labelSubir.setText("Fichero subido a la máquina");
            }
        });
        subir.setBounds(0, 117, 117, 29);
        contentPane.add(subir);

        //Botón Directorio Actual-------------------------------------------------------------------

        JButton diractual = new JButton("Directorio Actual");
        diractual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP dir = new ClienteFTP();
                dir.directorioActual();
                JLabel labeldir = new JLabel("Directorio");
                labeldir.setBounds(225, 163, 287, 16);
                contentPane.add(labeldir);
                labeldir.setText("Mostrando directorio");
            }
        });
        diractual.setBounds(0, 158, 213, 29);
        contentPane.add(diractual);

        //Botón Cambiar Directorio Padre--------------------------------------------------------------

        JButton cambiardirpadre = new JButton("Cambiar directorio Padre");
        cambiardirpadre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP padre = new ClienteFTP();
                padre.cambiarADirectorioPadre();
                JLabel labelPadre = new JLabel("Directorio Padre");
                labelPadre.setBounds(225, 204, 251, 16);
                contentPane.add(labelPadre);
                labelPadre.setText("Se cambió al directorio padre");
            }
        });
        cambiardirpadre.setBounds(0, 199, 213, 29);
        contentPane.add(cambiardirpadre);

        //Botón Cambiar Directorio-------------------------------------------------------------------

        JButton cambiardir = new JButton("Cambiar Directorio");
        cambiardir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP directorio = new ClienteFTP();
                directorio.cambiarDirectorio("/home");
                JLabel labelDir = new JLabel("Cambiar directorio");
                labelDir.setBounds(225, 245, 251, 16);
                contentPane.add(labelDir);
                labelDir.setText("Se cambió al directorio: " + directorio);
            }
        });
        cambiardir.setBounds(0, 240, 213, 29);
        contentPane.add(cambiardir);

        //Botón Desconectar--------------------------------------------------------------------------

        JButton desconectar = new JButton("Desconectar");
        desconectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP desconexion = new ClienteFTP();
                desconexion.desconectar();
                JLabel labeldesconectar = new JLabel("Desconexión");
                labeldesconectar.setBounds(225, 286, 251, 16);
                contentPane.add(labeldesconectar);
                labeldesconectar.setText("Se paro la conexión");
            }
        });
        desconectar.setBounds(0, 281, 213, 29);
        contentPane.add(desconectar);

        //Botón Borrar Fichero-----------------------------------------------------------------------

        JButton borrar = new JButton("Borrar Fichero");
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteFTP borrado = new ClienteFTP();
                borrado.borrarFichero("/home/formacion/ficheroPrueba3.txt");
                JLabel borrar = new JLabel("Borrar");
                borrar.setBounds(225, 327, 251, 16);
                contentPane.add(borrar);
                borrar.setText("Se borró el archivo");
            }
        });
        borrar.setBounds(0, 322, 213, 29);
        contentPane.add(borrar);


    }
}
