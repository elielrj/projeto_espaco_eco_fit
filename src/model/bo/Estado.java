
package model.bo;

public class Estado {
    
    private int id;
    private String nome;
    private String sigla;
    private Pais pais;
    private Regiao regiao;
    private boolean status;

    public Estado(int id, String nome, String sigla, Pais pais, Regiao regiao, boolean status) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
        this.regiao = regiao;
        this.status = status;
    }
    

    

    public Estado() {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
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
                "/" +
                getSigla() + 
                " - "+
                getPais().toString()
                ;
    }

    
    
    


 

    
    
    
}
