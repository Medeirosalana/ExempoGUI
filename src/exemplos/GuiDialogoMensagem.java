package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiDialogoMensagem extends JPanel {
    private JComboBox cbCaixas;

    public GuiDialogoMensagem() {
        inicializarComponentes();
    defenirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        String[] cbCaixasItens = {"Pergunta", "Informação", "Alerta", "Erro"};
        cbCaixas = new JComboBox(cbCaixasItens);
        
        cbCaixas.setBounds(25,40,150,25);
        add(cbCaixas);
    }

    private void defenirEventos() {
        cbCaixas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (cbCaixas.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(null,"Estou aprendendo java?", "Pergunta", JOptionPane.QUESTION_MESSAGE);
                        break;
                    case 1:
                         JOptionPane.showMessageDialog(null,"Gravação ok", "Informação", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                         JOptionPane.showMessageDialog(null,"Cuidado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 3:
                         JOptionPane.showMessageDialog(null,"Ocorreu algum erro", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                
                }
            }
        });
    }
   
    
}
