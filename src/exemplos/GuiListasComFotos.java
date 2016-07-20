package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiListasComFotos extends JPanel {

    private JList lsFotos;
    private DefaultListModel dlm;
    private ImageIcon imagen;
    private JScrollPane sp;
    private JLabel lbImagem;
    
    public GuiListasComFotos(){
    inicializarComponentes();
    defenirEventos();
    }
    private void inicializarComponentes(){
        setLayout(null);
        
        dlm = new DefaultListModel();
        for(int i = 1; i <= 10; i++){
        dlm.addElement("Fotos" + i);        
        }
        lsFotos = new JList(dlm);
        sp = new JScrollPane(lsFotos);
        imagen = new ImageIcon();
        lbImagem = new JLabel(imagen);
        sp.setBounds(50,40,70,150);
        lbImagem.setBounds(150,30,180,180);
        
        add(sp);
        add(lbImagem);
    }
    private void defenirEventos(){
    
    lsFotos.addListSelectionListener(new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            imagen = new ImageIcon("Imagens/" + lsFotos.getSelectedValue()+ ".gif");
            lbImagem.setIcon(imagen);
        }
    });
    
    }
}
