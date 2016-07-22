package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiCombo extends JPanel{
    private JLabel lbEstado, lbCidades;
    private Button btVerificar;
    private JComboBox cbEstados, cbCidades;
    private String[] estados;    

    public GuiCombo(){
    estados = addEstados();
   
    inicializarComponentes();
    defenirEventos();
    
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbEstado = new JLabel("Estados:");
        lbCidades = new JLabel("Cidades:");
        cbEstados = new JComboBox(estados);
        cbCidades = new JComboBox();
        btVerificar = new Button("Verificar");
        cbCidades.setEnabled(false);
        lbEstado.setBounds(25,15,150,25);
        lbCidades.setBounds(25,75,150,25);
        cbEstados.setBounds(25,40,150,25);
        cbCidades.setBounds(25,100,150,25);
        btVerificar.setBounds(25,140,100,25);
        add(lbEstado);
        add(cbEstados);
        add(btVerificar);
        add(cbCidades);
        add(lbCidades);
    }

    private void defenirEventos() {
        btVerificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "Index: "+cbEstados.getSelectedIndex() 
                       +"\nItem: "+ cbEstados.getSelectedItem()
                       +"\n Index Cidade: " + cbCidades.getSelectedIndex()
                       +"\n Intem Cidade: " + cbCidades.getSelectedItem());
            }
        });
        cbEstados.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               cbCidades.setEnabled(true);
               cbCidades.removeAllItems();
               String estado = String.valueOf(cbEstados.getSelectedItem());
               String[] cidsRN = {"","Natal", "Parnamirim"};
               String[] cidsCE = {"","Fortaleza", "Canoa Quebrada"};
               String[] cidsRJ = {"","Rio de Janiero", "Niteroi"};
               if(estado.equals("RN")){
               for(int i=0; i<cidsRN.length; i++){
               cbCidades.addItem(cidsRN[i]);
               }
               }
               if(estado.equals("CE")){
               for(int i=0; i<cidsCE.length; i++){
               cbCidades.addItem(cidsCE[i]);
               }
               }
               if(estado.equals("RJ")){
               for(int i=0; i<cidsRJ.length; i++){
               cbCidades.addItem(cidsRJ[i]);
               }
               }
            }
        });
        
    }
    private String[] addEstados() {
       String[] est = {"","RN","CE","RJ"};
       return est;
    }

    
}
