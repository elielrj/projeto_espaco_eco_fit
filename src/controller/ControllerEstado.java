
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.bo.Estado;
import model.bo.Pais;
import model.bo.Regiao;
import view.TelaBuscaEstado;
import view.TelaCadastroEstado;


public class ControllerEstado implements ActionListener{
    
    TelaCadastroEstado telaCadastroEstado = new TelaCadastroEstado();
    public static int codigo;
    
    public ControllerEstado(TelaCadastroEstado telaCadastroEstado){
        this.telaCadastroEstado = telaCadastroEstado;
        
        this.telaCadastroEstado.getjButtonNovo().addActionListener(this);
        this.telaCadastroEstado.getjButtonBuscar().addActionListener(this);
        this.telaCadastroEstado.getjButtonCancelar().addActionListener(this);
        this.telaCadastroEstado.getjButtonGravar().addActionListener(this);
        this.telaCadastroEstado.getjButtonSair().addActionListener(this);
             
        Ativa(true);
        LimpaEstadoComponentes(false);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroEstado.getjButtonNovo()){            
            Ativa(false);
            LimpaEstadoComponentes(true);            
            this.telaCadastroEstado.getjTextFieldId().setEnabled(false);
            codigo = 0;
        }        
        else if(e.getSource() == this.telaCadastroEstado.getjButtonCancelar()){
            Ativa(true);
            LimpaEstadoComponentes(false);
        }
        else if(e.getSource() == this.telaCadastroEstado.getjButtonGravar()){            
            //montar objeto a persistir
            Estado estado = new Estado();           
            estado.setNome(this.telaCadastroEstado.getjTextFieldNome().getText());
            estado.setSigla(this.telaCadastroEstado.getjTextFieldSigla().getText());
            estado.setPais((Pais) this.telaCadastroEstado.getjComboBoxPais().getSelectedItem());
            estado.setRegiao((Regiao) this.telaCadastroEstado.getjComboBoxRegiao().getSelectedItem());
            estado.setStatus((boolean) this.telaCadastroEstado.getJComboBoxStatus().getSelectedItem().equals("Sim"));
            
            if(codigo == 0){
                service.ServiceEstado.Incluir(estado);
            }else{
                estado.setId(Integer.parseInt(this.telaCadastroEstado.getjTextFieldId().getText()));
                service.ServiceEstado.Atualizar(estado);
            }
            Ativa(true);
            LimpaEstadoComponentes(false);
        }        
        if(e.getSource() == this.telaCadastroEstado.getjButtonBuscar()){
           
            codigo = 0;
            
            
            TelaBuscaEstado telaBuscaEstado = new TelaBuscaEstado(null, true);            
            ControllerBuscaEstado controllerBuscaEstado = new ControllerBuscaEstado(telaBuscaEstado);
            telaBuscaEstado.setVisible(true);//verificarControllerBuscaEstado
            
            
           
            
            if(codigo != 0){
                Ativa(false);
                LimpaEstadoComponentes(true);
                Estado estado = new Estado();
                estado = service.ServiceEstado.Buscar(codigo);
                
                this.telaCadastroEstado.getjTextFieldId().setText(estado.getId()+"");
                this.telaCadastroEstado.getjTextFieldNome().setText(estado.getNome());
                this.telaCadastroEstado.getjTextFieldSigla().setText(estado.getSigla());
                
                this.telaCadastroEstado.getjComboBoxPais().setSelectedItem(estado.getPais().getNome());
                this.telaCadastroEstado.getjComboBoxRegiao().setSelectedItem(estado.getRegiao().getNome());
                this.telaCadastroEstado.getJComboBoxStatus().setSelectedItem(estado.getStatus());
                
                this.telaCadastroEstado.getjTextFieldId().setEnabled(false); 
            }
        }
        
        if(e.getSource() == this.telaCadastroEstado.getjButtonSair()){
            this.telaCadastroEstado.dispose();
        }

    }
 
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void Ativa(boolean estadoBotoes){
        this.telaCadastroEstado.getjButtonNovo().setEnabled(estadoBotoes);
        this.telaCadastroEstado.getjButtonCancelar().setEnabled(!estadoBotoes);
        this.telaCadastroEstado.getjButtonGravar().setEnabled(!estadoBotoes);
        this.telaCadastroEstado.getjButtonBuscar().setEnabled(estadoBotoes);
        this.telaCadastroEstado.getjButtonSair().setEnabled(estadoBotoes);        
    }
    
    public void LimpaEstadoComponentes(boolean estadoCompo){
        Component[] componentes = this.telaCadastroEstado.getjPanelDados().getComponents(); //verificar!
        for(Component componente : componentes){
            if(componente instanceof JTextField){
                ((JTextField)componente).setText("");
                componente.setEnabled(estadoCompo);
            }
        
            if(componente instanceof JFormattedTextField){
                ((JFormattedTextField) componente).setText("");
                componente.setEnabled(estadoCompo);
            }
            
            if(componente instanceof JComboBox){
                ((JComboBox) componente).setSelectedItem(0);
                componente.setEnabled(estadoCompo);
            }
            
        } 
    }
    
    
    
}
