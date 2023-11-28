import java.util.Scanner;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Admin> administradores = new ArrayList<>();
        ArrayList<Double> gastos = new ArrayList<>();
        ArrayList<Double> faturamentos = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        String escolha_Programa = "N";
        String clear;

        //CRIAÇÃO DO LAÇO DO SISTEMA

        while(escolha_Programa.equals("N")){

            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("BEM VINDO À CENTRAL DE ATENDIMENTO\n\n" +
                    "1 - ENTRAR\n2 - CADASTRAR-SE\n");
            int firstChoice = input.nextInt();

            //ESCOLHA DO USER (ADMIN) PARA ENTRAR EM CONTA EXISTENTE OU  CADASTRAR-SE
            switch (firstChoice){
                case 1:
                    //INFORMAÇÕES DO ADMIN
                    if (administradores.size() == 0){
                        System.out.println("NÃO FOI POSSÍVEL ENTRAR, NÃO HÁ CONTA CADASTRADA.");
                        break;
                    } else {

                    }



                    System.out.println("OLÁ, ADMINISTRADOR! O QUE DESEJA FAZER?\n1 - CADASTRAR CLIENTE\n2 - GERENCIAR CLIENTE\n3 - " +
                            "GERENCIAR LAVAJATO");
                    int cadastro = input.nextInt();


                    //ESTRUTURA DE DECISÃO PARA CONTROLAR O QUE ACONTECE DENTRO DA CONTA DO ADMIN
                    if(cadastro == 1) {
                        //CADASTRO DE ENDEREÇO DO CLIENTE

                        input.nextLine();
                        System.out.println("Cidade do cliente: ");
                        String cidade = input.nextLine();
                        input.nextLine();


                        //INFORMAÇÕES DE CADASTRO DO CLIENTE

                        System.out.println("\nInformações documentais do cliente---\n ");
                        System.out.println("Cliente: ");
                        String nomeCliente = input.nextLine();

                        System.out.println("Id do cliente: ");
                        int id = input.nextInt();


                        //INSTANCIANDO OBJETOS DO TIPO CLIENTE

                        Endereco end1 = new Endereco(cidade, "-", "-", 0);
                        CartaoFidelidade cartao1 = new CartaoFidelidade();
                        Cliente cliente1 = new Cliente(nomeCliente, "admin1", end1,id, cartao1);
                        clientes.add(cliente1);


                    } else if (cadastro == 2){

                        //INICIALIZAÇÃO DO SISTEMA ADMIN

                        System.out.println("\nLOGADO COMO ADM-=-=-=-=-=-=-\n");
                        System.out.println("-=-=-=-=-=-=-=-=-=-\n" +
                                "1 - ZERAR PONTUAÇÃO\n2 - ADICIONAR PONTUAÇÃO\n");
                        try {int esc_pontuacao = input.nextInt();
                        if (esc_pontuacao == 1){
                            administradores.get(0).zerarPontuacao(clientes.get(0));

                        }
                        else{

                            administradores.get(0).adicionarPontuacao(clientes.get(0));

                        }
                        } catch (IndexOutOfBoundsException a) {
                            System.out.println("Não há nenhum cliente cadastrado.");
                        }


                    } else {
                        System.out.println("-=-=-=-=-=-=-=-=-=-\n" +
                                "1 - ADICIONAR GASTOS\n\n2 - ADICIONAR FATURAMENTO\n");
                        int caso = input.nextInt();
                        switch (caso){
                            case 1:
                                gastos.add(administradores.get(0).adicionarGastos());
                                break;
                            case 2:
                                faturamentos.add(administradores.get(0).adicionarLavagem());
                                break;
                            default:
                                throw new IllegalStateException("Valor inesperado: " + caso);
                        }
                    }
                    break;
                case 2:
                    //INPUTS PARA CADASTRO DO ADMINISTRADOR

                    System.out.println("=-=-=-==-=- CADASTRO DE ADMINISTRADOR ==-=-=-=-\n\n");
                    input.nextLine();
                    System.out.println("Nome: ");
                    String nomeAdm = input.nextLine();
                    input.nextLine();
                    System.out.println("\nSenha: ");
                    String senhaAdm = input.nextLine();
                    input.nextLine();
                    System.out.println("\nNome do lavajato: ");
                    String nomeLavajato = input.nextLine();
                    input.nextLine();


                    // INSTANCIAMENTO DO CADASTRO DO ADMINISTRADOR

                    Conta contaAdm = new Conta("corrente", 0);
                    Endereco lavajato2 = new Endereco("Paulista", "Centro", "Presidente Veridico", 45);
                    Admin administrador = new Admin(lavajato2, senhaAdm, nomeAdm, nomeLavajato, contaAdm);
                    administradores.add(administrador);
                    break;


                default:
                    System.out.println("OPÇÃO FORA DE MARGEM.");

            }

            //Limpando buffer do teclado para não obstruir os inputs
            clear = input.nextLine();



            System.out.println("Gostaria de encerrar o programa? [S/N]\n");
            escolha_Programa = input.nextLine().toUpperCase();
        }
        int quebra = 1;
        do{
            System.out.println("\n1 - VERIFICAR GASTOS\n2 - VERIFICAR FATURAMENTO\n3 - LUCRO\n4 - RESUMO\n5 - SAÍDA");
            int final_ans = input.nextInt();
            switch (final_ans) {
                case 1:
                    double soma = 0;
                    for (int i = 0; i < gastos.size(); i++) {
                        soma += gastos.get(i);
                    }

                    System.out.println("GASTOS - " + soma);
                    break;
                case 2:
                    double faturamento = 0;
                    for (int i = 0; i < faturamentos.size(); i++) {
                        faturamento += faturamentos.get(i);
                    }
                    System.out.println("FATURAMENTO: R$" + faturamento);
                    break;

                case 3:
                    double fat = 0;
                    double gas = 0;
                    for (int i = 0; i < faturamentos.size(); i++) {
                        fat += faturamentos.get(i);
                    }
                    for (int i = 0; i < gastos.size(); i++) {
                        gas += gastos.get(i);
                    }
                    System.out.println("Lucro: R$" + (fat - gas));
                    break;
                case 4:
                    System.out.println("-=-=-=-=- ADMINISTRADOR RESPONSÁVEL: \n");
                    System.out.println("Nome: " + administradores.get(0).getNome() +
                            "\nSenha: " + administradores.get(0).getSenha() +
                            "\nNome do lavajato: " + administradores.get(0).getLavajato() + "\n");

                    for (Cliente c : clientes) {
                        c.status();
                    }
                    System.out.println("=-=-=-=-=-=-=-=-=");
                    double somas = 0;
                    for (int i = 0; i < gastos.size(); i++) {
                        somas += gastos.get(i);
                    }

                    break;
                case 5:
                    quebra = 0;
                    break;
            }
        } while(quebra != 0);
        System.out.println("\n\nSISTEMA ENCERRADO, V0LTE SEMPRE!");

    }
}
