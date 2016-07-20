package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMenuPrincipal extends JFrame {

    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao, miCaixaOpcao, miRadio, miLista;
    public GuiMenuPrincipal(){
        inicializarComponentes();
        defenirEventos();
    }
    private void inicializarComponentes(){
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        
        
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnExemplos = new JMenu("Exemplos");
        miSair = new JMenuItem("Sair");
        miBotao = new JMenuItem("Botão");
        miCaixaOpcao = new JMenuItem("Caixa de Opção");
        miRadio = new JMenuItem("Botão de Rádio");
        miLista = new JMenuItem("Lista");
        mnArquivo.setMnemonic('A');
        mnExemplos.setMnemonic('E');
        
        mnArquivo.add(miSair);
        mnExemplos.add(miCaixaOpcao);
        mnExemplos.add(miBotao);
        mnExemplos.add(miRadio);
        mnExemplos.add(miLista);
        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);
        setJMenuBar(mnBarra);        
    }
    private void defenirEventos(){
        miSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miBotao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBotao botao = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(botao);
                contentPane.validate();
            }
        });
        miCaixaOpcao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               GuiCaixaOpcao opcao = new GuiCaixaOpcao();
               contentPane.removeAll();
               contentPane.add(opcao);
               contentPane.validate();
            }
        });
        miRadio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRadio radio = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(radio);
                contentPane.validate();
            }
        });
        miLista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLista lista = new GuiLista();
                contentPane.removeAll();
                contentPane.add(lista);
                contentPane.validate();
            }
        });
        
    }

public static void run(){
    GuiMenuPrincipal frame = new GuiMenuPrincipal();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (tela.width - frame.getSize().width) / 2;
    int y = (tela.height - frame.getSize().height) / 2;
    frame.setLocation(x, y);
    frame.setVisible(true);
}
}