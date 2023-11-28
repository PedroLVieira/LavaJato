public class Conta {
    private String tipo;
    private double valor;
    private double totalluz;
    private double totalagua;

    private double faturamento = 0;

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public double getTotalluz() {
        return totalluz;
    }

    public void setTotalluz(double totalluz) {
        this.totalluz = totalluz;
    }

    public double getTotalagua() {
        return totalagua;
    }

    public void setTotalagua(double totalagua) {
        this.totalagua = totalagua;
    }

    public Conta(){}

    public Conta(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void adicionarGastoLuz(double valor){
        System.out.println("Sua conta de luz era de " + totalluz + "R$");
        totalluz = totalluz + valor;
        verificaLuz();
    }
    public void adicionarGastoAgua(double valor){
        System.out.println("Sua conta de água era de " + totalagua+ "R$");
        totalagua = totalagua + valor;
        verificaAgua();
    }

    public void adicionarFaturamento(double valor){
        faturamento = getFaturamento() + valor;
    }
    public void verificaAgua(){
        System.out.println("O total da sua conta de água é de R$" + totalagua);
    }

    public void verificaLuz(){
        System.out.println("O total da sua conta de água é de R$" + totalluz);
    }


}





