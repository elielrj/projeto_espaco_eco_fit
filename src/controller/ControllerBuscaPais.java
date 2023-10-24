
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaPais;
import model.bo.Pais;

public class ControllerBuscaPais implements ActionListener{
    
    TelaBuscaPais telaBuscaPais;
     
    
    public ControllerBuscaPais(TelaBuscaPais telaBuscaPais){
        this.telaBuscaPais = telaBuscaPais;
        
        
        this.telaBuscaPais.getBotaoCarregar().addActionListener(this);
        this.telaBuscaPais.getBotaoSair().addActionListener(this);
        
        //fazer a carga inicial do jtable
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPais.getTabelaPais().getModel();
        
        for (Pais paisDaLista : service.ServicePais.Buscar()) {
            tabela.addRow(new Object[]{
                paisDaLista.getId(),
                paisDaLista.getName(),
                paisDaLista.getName(),
                paisDaLista.getStatus()
            });
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.telaBuscaPais.getBotaoCarregar()){
           
           ControllerPais.codigo = (int) this.telaBuscaPais.getTabelaPais().getValueAt(this.telaBuscaPais.getTabelaPais().getSelectedRow(),0);
           this.telaBuscaPais.dispose();
       }
       if(e.getSource() == this.telaBuscaPais.getBotaoSair()){
           this.telaBuscaPais.dispose();
       }
    }
    
    
}
