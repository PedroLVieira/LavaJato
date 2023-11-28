public class Cliente extends Pessoa{
    private int id;
    private CartaoFidelidade cartaoFidelidade;

    public Cliente(){};

    public Cliente(String nome, String senha, Endereco end, int id, CartaoFidelidade cartaoFidelidade ) {
        super(end, senha, nome);
        this.id = id;
        this.cartaoFidelidade = cartaoFidelidade;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CartaoFidelidade getCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(CartaoFidelidade cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }
    public void realizarCadastro(Pessoa pessoa){
        System.out.println("Cadastro realizado com sucesso " + pessoa.getNome() + " com ID de numero " + getId());
    }

    public void verificarCartaoFidelidade(CartaoFidelidade cartao, Admin admin){
        if (cartao.getPontuacao() == 7){
            System.out.println("Você ganhou uma lavagem grátis");
            admin.zerarPontuacao(this);
        } else{
            System.out.println("Você ja tem " + cartao.getPontuacao() + "lavagens, faltam " + (7 - cartao.getPontuacao()) + "lavagens para ganhar sua lavagem grátis.");
        }
    }

    public void status() {
        System.out.println("Cliente: "+ super.getNome() +"\n" +"Endereço: "+ super.getEndereco().getCidade() +"\n" + "Pontuação do cartão: " + this.getCartaoFidelidade().getPontuacao() + "\n"
                + "Id do cliente: " + this.getId());
    }
}
