
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaEstado;
import model.bo.Estado;

public class ControllerBuscaEstado implements ActionListener{
    
    TelaBuscaEstado telaBuscaEstado;
     
    
    public ControllerBuscaEstado(TelaBuscaEstado telaBuscaEstado){
        this.telaBuscaEstado = telaBuscaEstado;
        
        
        this.telaBuscaEstado.getBotaoCarregar().addActionListener(this);
        this.telaBuscaEstado.getBotaoSair().addActionListener(this);
        
        //fazer a carga inicial do jtable
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEstado.getjTable1().getModel();
        
        for (Estado estadoDaLista : service.ServiceEstado.Buscar()) {
            tabela.addRow(new Object[]{
                
                estadoDaLista.getId(),
                estadoDaLista.getNome(),
                estadoDaLista.getSigla(),
                
                estadoDaLista.getPais().toString(),
                estadoDaLista.getRegiao().toString(),
                estadoDaLista.getStatus()
            });
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.telaBuscaEstado.getBotaoCarregar()){
           
           ControllerEstado.codigo = (int) this.telaBuscaEstado.getjTable1().getValueAt(this.telaBuscaEstado.getjTable1().getSelectedRow(),0);
           this.telaBuscaEstado.dispose();
       }
       if(e.getSource() == this.telaBuscaEstado.getBotaoSair()){
           this.telaBuscaEstado.dispose();
       }
    }
    
    
}
