package Biblioteca;
import java.time.LocalDate;

public class Multa{
    //atributos da multa
    protected String codMulta;
    protected int idUsuario;
    protected LocalDate dataExpedicao;
    protected double valor;
    protected boolean isPaga;
    

    //construtor
    public Multa(String codMulta, int idUsuario, double valor, boolean isPaga) {
        this.codMulta = codMulta;
        this.idUsuario = idUsuario;
        this.dataExpedicao = LocalDate.now();
        this.valor = valor;
        this.isPaga = false;
    }

    //getters e setters
    //codMulta
    public String getCodMulta() {
        return codMulta;
    }
    public void setCodMulta(String codMulta) {
        this.codMulta = codMulta;
    }
    //idUsuario
    public int getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    //dataExpedicao
    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }
    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }
    //valor
    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    //paga
    public boolean getisPaga(){
        return isPaga;
    }
    public boolean setisPaga(boolean isPaga){
        this.isPaga = isPaga;
        return true;
    }
    
    //método para gerar uma multa
    public  Multa gerarMulta(EmprestimoLivro emprestimoLivro) {
        if (emprestimoLivro.isEmprestimoAtrasado()) {
            LocalDate dataExpedicao = LocalDate.now();
            double valorMulta = 3.5;
            codMulta = "M-" + emprestimoLivro.getUsuario() + "-" + dataAtual.toString();
            return new Multa(codMulta, emprestimoLivro.getIdUsuario(), valorMulta, false);
        }
        return null;
    }
    
    //método para quitar uma multa
    public void quitarMulta() {
        if (!this.isPaga) {
            this.isPaga = true;
            System.out.println("Multa " + this.codMulta + " foi paga.");
        } else {
            System.out.println("A multa " + this.codMulta + " já está paga.");
        }
    }
    
}
