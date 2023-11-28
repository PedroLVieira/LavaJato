import com.sun.jdi.Value;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.ArrayList;
public class Admin extends Pessoa{
    private String lavajato;

    private Conta conta;

    public Admin(){}

    public String getLavajato() {
        return lavajato;
    }

    public void setLavajato(String lavajato) {
        this.lavajato = lavajato;
    }

    public Admin(String lavajato, Conta conta) {
        this.lavajato = lavajato;
        this.conta = conta;
    }

    public Admin(Endereco endereco, String senha, String nome, String lavajato, Conta conta) {
        super(endereco, senha, nome);
        this.lavajato = lavajato;
        this.conta = conta;
    }

    Scanner input = new Scanner(System.in);
    public void status(Admin admin){
        System.out.println("Nome: " + this.getNome()+ "\nFaturamento: " + this.getConta().getFaturamento());
        System.out.println("Conta de luz: " + this.getConta().getTotalluz());
        System.out.println("Conta de agua" + this.getConta().getTotalagua());

    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void verificarGastos() {

        System.out.println("Você deseja acessar qual tipo de conta a pagar?\nDigite 1 para luz, 2 para água ou 3 para todas as contas a pagar.");
        int tipo = input.nextInt();
        if (tipo == 1) {
            System.out.println("-=-=-=-=-=-=-=-=-\n");
            conta.verificaLuz();
        } else if (tipo == 2) {
            System.out.println("-=-=-=-=-=-=-=-=-\n");
            conta.verificaAgua();
        } else {
            System.out.println("-=-=-=-=-=-=-=-=-\n");
            conta.verificaLuz();
            System.out.println("\n");
            conta.verificaAgua();
        }
    }



    public double adicionarLavagem(){
        System.out.println("Insira qual tipo de lavagem foi feita.\ndigite 1 para carro Pequeno.\ndigite 2 para carro Médio.\ndigite 3 para carro Grande.\ndigite 4 para Moto.");
        int tipo = input.nextInt();
        if (tipo == 1){
            conta.adicionarFaturamento(15);
            System.out.println("Lavagem adicionada ao sistema.");
            return 15;
        } else if (tipo == 2){
            conta.adicionarFaturamento(20);
            System.out.println("Lavagem adicionada ao sistema.");
            return 20;
        } else if (tipo == 3){
            conta.adicionarFaturamento(25);
            System.out.println("Lavagem adicionada ao sistema.");
            return 25;
        } else if (tipo == 4){
            conta.adicionarFaturamento(10);
            System.out.println("Lavagem adicionada ao sistema.");
            return 10;
        } else {
            return 0;
        }
    }

    public double adicionarGastos(){
        System.out.println("Insira qual tipo de gasto você quer adicionar.\ndigite 1 para Água\ndigite 2 para Luz.");
        int tipo = input.nextInt();
        System.out.println("Agora insira o valor a ser adiciondo na conta de gastos.");
        double valor = input.nextDouble();
        if (tipo == 1){
            conta.adicionarGastoAgua(valor);
        } else {
            conta.adicionarGastoLuz(valor);
        }
        return valor;
    }

    public void adicionarCliente(){

    }

    public void adicionarPontuacao(Cliente cliente){

        if (cliente.getCartaoFidelidade().getPontuacao() < 7){
            cliente.getCartaoFidelidade().setPontuacao(cliente.getCartaoFidelidade().getPontuacao()+1);
            System.out.println("Você ganhou um ponto no cartão fidelidade!");
            System.out.println("Você tem atualmente: " + cliente.getCartaoFidelidade().getPontuacao() + " pontos.");
        } else{
            System.out.println("O cliente ganhou uma lavagem grátis");
        }

    }

    public void zerarPontuacao(Cliente cliente){
        if(cliente.getCartaoFidelidade().getPontuacao() == 0){
            System.out.println("Seu cartão fidelidade será zerado, volte mais vezes para ganhar novamente sua lavagem grátis.");
        } else {
            cliente.getCartaoFidelidade().setPontuacao(0);
            System.out.println("Você recebeu um novo cartão, obrigado pela lavagem.");

        }
    }
}
