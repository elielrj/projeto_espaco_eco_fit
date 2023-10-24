
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import model.bo.Pais;
import view.TelaBuscaPais;
import view.TelaCadastroPais;


public class ControllerPais implements ActionListener{
    
    TelaCadastroPais telaBuscaPais = new TelaCadastroPais();
    public static int codigo;
    
    public ControllerPais(TelaCadastroPais telaBuscaPais){
       
        this.telaBuscaPais = telaBuscaPais;
        
        this.telaBuscaPais.getNovo().addActionListener(this);
        this.telaBuscaPais.getBuscar().addActionListener(this);
        this.telaBuscaPais.getCancelar().addActionListener(this);
        this.telaBuscaPais.getGravar().addActionListener(this);
        this.telaBuscaPais.getSair().addActionListener(this);
             
        Ativa(true);
        LimpaEstadoComponentes(false);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBuscaPais.getNovo()){            
            Ativa(false);
            LimpaEstadoComponentes(true);            
            this.telaBuscaPais.getjTextFieldId().setEnabled(false);
            codigo = 0;
        }        
        else if(e.getSource() == this.telaBuscaPais.getCancelar()){
            Ativa(true);
            LimpaEstadoComponentes(false);
        }
        else if(e.getSource() == this.telaBuscaPais.getGravar()){            
            //montar objeto a persistir
            Pais pais = new Pais();           
            
            pais.setNome(this.telaBuscaPais.getjTextFieldNome().getText());
            pais.setName(this.telaBuscaPais.getjTextFieldName().getText());
            pais.setStatus(this.telaBuscaPais.getjComboBoxStatus().getSelectedItem().equals("Sim"));
            
            if(codigo == 0){
                service.ServicePais.Incluir(pais);
            }else{
                pais.setId(Integer.parseInt(this.telaBuscaPais.getjTextFieldId().getText()));
                service.ServicePais.Atualizar(pais);
            }
            Ativa(true);
            LimpaEstadoComponentes(false);
        }        
        if(e.getSource() == this.telaBuscaPais.getBuscar()){
           
            codigo =0;
            TelaBuscaPais telaBuscaPais = new TelaBuscaPais(null, true);
            ControllerBuscaPais controllerBuscaPaisRelatorio = new ControllerBuscaPais(telaBuscaPais);
            telaBuscaPais.setVisible(true);
            
            
           
            
            if(codigo != 0){
                Ativa(false);
                LimpaEstadoComponentes(true);
                
                Pais pais = new Pais();
                pais = service.ServicePais.Buscar(codigo);
                
                this.telaBuscaPais.getjTextFieldId().setText(pais.getId() + "");
                this.telaBuscaPais.getjTextFieldNome().setText(pais.getNome());
                this.telaBuscaPais.getjTextFieldName().setText(pais.getName());
                this.telaBuscaPais.getjComboBoxStatus().setSelectedItem(pais.getStatus());
                
                this.telaBuscaPais.getjTextFieldId().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaBuscaPais.getSair()){
            this.telaBuscaPais.dispose();
        }

    }
    
    public void Ativa(boolean estadoBotoes){
        this.telaBuscaPais.getNovo().setEnabled(estadoBotoes);
        this.telaBuscaPais.getCancelar().setEnabled(!estadoBotoes);
        this.telaBuscaPais.getGravar().setEnabled(!estadoBotoes);
        this.telaBuscaPais.getBuscar().setEnabled(estadoBotoes);
        this.telaBuscaPais.getSair().setEnabled(estadoBotoes);        
    }
    
    public void LimpaEstadoComponentes(boolean estadoCompo){
        Component[] componentes = this.telaBuscaPais.getjPanelDados().getComponents(); //verificar
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
