package model.bo;

public class Aluno extends Pessoa {
    
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String dataDeNascimento;
    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(int id, String nome, String rg, String cpf, String dataDeNascimento, String complemento, String telefone1, String telefone2, String email, String observacao, Endereco endereco) {
        super(complemento, telefone1, telefone2, email, observacao);
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return  
                this.getId() + " - Dt Nasc " +
                
                this.getDataDeNascimento() + " - End  " + 
                this.getEndereco().toString();
    }


    
    
    
}
