
package model.bo;

public class Bairro {
    
    private int id;
    private String nome;
    private Cidade cidade;
    private boolean status;
    
    public Bairro() {
    }

    public Bairro(int id, String nome, Cidade cidade, boolean status) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
                getNome() + " - " +
                getCidade().toString()
                ;
    }

    
    

    
    
}
