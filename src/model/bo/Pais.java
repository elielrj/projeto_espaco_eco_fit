

package model.bo;


public class Pais {
    
    private int id;
    private String nome;
    private String name;
    private boolean status;

    public Pais() {
    }
    
    public Pais(int id, String nome, String name, boolean status) {
        this.id = id;
        this.nome = nome;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                getNome()
                ;
    }

    


    
    
    
}
