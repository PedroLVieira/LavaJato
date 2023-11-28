public class Pessoa {
    private String nome;
    private Endereco endereco;
    protected String senha;

    public Pessoa(){};

    public Pessoa(Endereco endereco, String senha, String nome) {
        this.endereco = endereco;
        this.senha = senha;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
