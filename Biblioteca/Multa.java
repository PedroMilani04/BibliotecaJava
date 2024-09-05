package Biblioteca;
import java.time.LocalDate;

public class Multa{
    //atributos da multa
    protected String codMulta;
    protected String idUsuario;
    protected LocalDate dataExpedicao;
    protected double valor;
    protected boolean paga;
    

    //construtor
    public Multa(String codMulta, String idUsuario, double valor, boolean paga) {
        this.codMulta = codMulta;
        this.idUsuario = idUsuario;
        this.dataExpedicao = LocalDate.now();
        this.valor = valor;
        this.paga = false;
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
    public String getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario){
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
    public boolean getPaga(){
        return paga;
    }
    public boolean setPaga(boolean paga){
        this.paga = paga;
    }
    
    // Método para mostrar as informações da Multa
    public void exibirDados() {
        System.out.println("codMulta: "+codMulta+"idUsuario: "+idUsuario+"valor: "+valor+"paga: "+paga+"dataExpedicao: "+dataExpedicao);
    }
}
