package exemplos;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GuiGrade extends JPanel{
    private JPanel pnPrincipal, pnTable;
    private JButton btRemover, btAdicionar;
    private JScrollPane ScrollTable;
    private JTable table;
    private JLabel lbNumero, lbTotal, lbProduto, lbPrecoUnitario, lbQuantidade;
    private JTextField tfNumero, tfTotal, tfProduto, tfPrecoUnitario, tfQuantidade;
    DecimalFormat df = new DecimalFormat("#,###.00");
    

    public GuiGrade() {
        inicializarComponentes();
        defenirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        pnPrincipal = new JPanel();
        pnTable = new JPanel(new BorderLayout());
        btRemover = new JButton("Remover");
        btAdicionar = new JButton("Adicionar");
        ScrollTable = new JScrollPane();        
        lbNumero = new JLabel("Número do Pedido");
        lbTotal = new JLabel("Total do Pedido:");
        lbProduto = new JLabel("Produto");
        lbPrecoUnitario = new JLabel("Preço Unitario");
        lbQuantidade = new JLabel("Quantidade");
        tfNumero = new JTextField();
        tfTotal = new JTextField();
        tfProduto = new JTextField();
        tfPrecoUnitario = new JTextField();
        tfQuantidade = new JTextField();
        tfTotal.setEditable(false);
        tfTotal.setHorizontalAlignment(JTextField.RIGHT);
        lbProduto.setBounds(15,40,100,25);
        lbQuantidade.setBounds(225,40,100,25);
        lbPrecoUnitario.setBounds(310,40,100,25);
        lbNumero.setBounds(15,10,120,25);
        lbTotal.setBounds(278,360,100,25);
        tfProduto.setBounds(15,65,200,25);
        tfQuantidade.setBounds(225,65,50,25);
        tfPrecoUnitario.setBounds(310,65,80,25);
        tfNumero.setBounds(130,10,50,25);
        tfTotal.setBounds(375,360,100,25);
        btAdicionar.setBounds(15,100,100,22);
        btRemover.setBounds(150,100,100,22);
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0,0,500,400);
        pnPrincipal.add(lbNumero);
        pnPrincipal.add(lbTotal);
        pnPrincipal.add(lbProduto);
        pnPrincipal.add(lbQuantidade);
        pnPrincipal.add(lbPrecoUnitario);
        pnPrincipal.add(tfNumero);
        pnPrincipal.add(tfTotal);
        pnPrincipal.add(tfProduto);
        pnPrincipal.add(tfQuantidade);
        pnPrincipal.add(tfPrecoUnitario);
        pnTable.setBorder(new TitledBorder("Itens do Pedido"));
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        pnPrincipal.add(btAdicionar);
        pnPrincipal.add(btRemover);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Produto",
        "Qtd","P Unit","Total"},0){@Override
        public boolean isCellEditable(int row, int col){if (col == 3){return false;}
        return true;}};
        table = new JTable(model);
        DefaultTableCellRenderer alinharDireita = new DefaultTableCellRenderer();
        alinharDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        
        table.getColumnModel().getColumn(1).setCellRenderer(alinharDireita);
        table.getColumnModel().getColumn(2).setCellRenderer(alinharDireita);
        table.getColumnModel().getColumn(3).setCellRenderer(alinharDireita);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ScrollTable.setViewportView(table);
        pnTable.add(ScrollTable);
        add(pnPrincipal);
        pnTable.setBounds(10,130,470,230);
        pnPrincipal.add(pnTable);
    }

    private void defenirEventos() {
        btAdicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfProduto.getText().equals("")||tfQuantidade.getText().equals("")||tfPrecoUnitario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos");  
                return;
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{tfProduto.getText(),tfQuantidade.getText(),tfPrecoUnitario.getText(),
                ""+ df.format(Integer.parseInt(tfQuantidade.getText())* Float.parseFloat(tfPrecoUnitario.getText()))});
                limparCampos();
                calcularTotal();
                
            }
                 });
        
    }

            private void limparCampos() {
                tfProduto.setText("");
                tfQuantidade.setText("1");
                tfPrecoUnitario.setText("");
                tfProduto.requestFocus();
            }

            private void calcularTotal() {
               float total = 0;
               for(int linha = 0; linha<table.getRowCount(); linha++){
               String valor = ""+ table.getValueAt(linha, 3);
               valor = valor.replace(".", "");
               valor = valor.replace(",", ".");
               total += Float.parseFloat(valor);
               }
               tfTotal.setText("" + df.format(total));
            }
   

    
}
