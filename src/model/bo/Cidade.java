
package model.bo;


public class Cidade {

private int id;
private String nome;
private Estado estado;
private boolean status;

    public Cidade() {
    }

    public Cidade(int id, String nome, Estado estado, boolean status) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.status = status;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return 
                getNome() +
                " - " +
                getEstado().toString();
    }

    
    

}
