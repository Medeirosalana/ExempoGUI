package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiCaixaOpcao extends JPanel {

    private JCheckBox ckIngles, ckInformatica;
    private JButton btVerificar, btMarcar, btDesmarcar;
    
    public GuiCaixaOpcao(){
     inicializarComponentes();
        definirEventos();
    }
    private void inicializarComponentes(){
        setLayout(null);
        ckIngles = new JCheckBox("Ingles");
        ckInformatica = new JCheckBox("Informatica");
        btVerificar = new JButton("Verificar");
        btMarcar = new JButton("Marcar");
        btDesmarcar = new JButton("Desmarcar");
        ckIngles.setBounds(15, 15, 100, 25);
        ckInformatica.setBounds(15,40,100,25);
        btVerificar.setBounds(20, 70, 100, 20);
        btMarcar.setBounds(20,100,100,20);
        btDesmarcar.setBounds(20, 130, 100, 20);
        add(ckIngles);
        add(ckInformatica);
        add(btVerificar);
        add(btMarcar);
        add(btDesmarcar);
    }
    private void definirEventos(){
    btVerificar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String selecao = "Selecionados: ";
            if(ckIngles.isSelected()){
            selecao += "\nIngles";
            }
            if(ckInformatica.isSelected()){
            selecao += "\nInformatica";            
            }
            JOptionPane.showMessageDialog(null, selecao);
        }
    });
    btMarcar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ckIngles.setSelected(true);
            ckInformatica.setSelected(true);
        }
    });
    btDesmarcar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ckIngles.setSelected(false);
            ckInformatica.setSelected(false);
        }
    });
    }
}
