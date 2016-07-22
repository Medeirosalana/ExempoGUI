package exemplos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiAreaTexto extends JPanel {
   private JButton btLimpar;
   private  JTextField tfTexto;
  
   private JTextArea taTexto;
   private JScrollPane cbBarra;
   private static String novaLinha = "\n";
   public GuiAreaTexto(){
   inicializarComponentes();
   defenirEventos();
   }

    private void inicializarComponentes() {
        setLayout(null);
        btLimpar = new JButton("Limpar");
        tfTexto = new JTextField(5);        
        taTexto = new JTextArea(5,20);
        taTexto.setEditable(false);
        cbBarra = new JScrollPane(taTexto);       
        tfTexto.setBounds(25,15,150,25);        
        btLimpar.setBounds(25,170,100,25);
        cbBarra.setBounds(25,45,300,120);
        add(btLimpar);       
        add(tfTexto);
        add(cbBarra);
    }

    private void defenirEventos() {
        tfTexto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                taTexto.append(tfTexto.getText() + novaLinha);
                taTexto.setCaretPosition(taTexto.getDocument().getLength());
                tfTexto.setText("");
            }
        });
        btLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfTexto.setText("");
                taTexto.setText("");
                tfTexto.requestFocus();
            }
        });
               
    }
    
}
