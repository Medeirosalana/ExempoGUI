package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiRadio extends JPanel {

    private JLabel lbSexo;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup grupo;
    private JButton btVerificar;
    
    public GuiRadio(){
    inicializarComponentes();
    defenirEventos();
    }
    private void inicializarComponentes(){
        setLayout(null);
        lbSexo = new JLabel("Selecione o sexo:");
        rbMasculino = new JRadioButton("Masculino");
        rbFeminino = new JRadioButton("Feminino");
        grupo = new ButtonGroup();
        btVerificar = new JButton("Verificar");
        lbSexo.setBounds(55,10,105,30);
        rbMasculino.setBounds(55,45,100,25);
        rbFeminino.setBounds(55,70,100,25);
        btVerificar.setBounds(55,105,100,20);
        grupo.add(rbMasculino);
        grupo.add(rbFeminino);
        rbMasculino.setSelected(true);
        add(lbSexo);
        add(rbMasculino);
        add(rbFeminino);
        add(btVerificar);
               
    }
     private void defenirEventos(){
     btVerificar.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
             String selecao = "Selecionado: ";
             if(rbMasculino.isSelected()){
             selecao += "Masculino";
             
             }else{
             selecao += "Feminino";
             }
             JOptionPane.showMessageDialog(null,selecao );
         }
     });
     }
}
