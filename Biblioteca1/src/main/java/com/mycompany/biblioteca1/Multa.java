package com.mycompany.biblioteca1;
import java.time.LocalDate;
import java.util.ArrayList;

public class Multa implements Subject{
    //atributos da multa
    protected String codMulta;
    protected String idUsuario;
    protected LocalDate dataExpedicao;
    protected double valor;
    protected boolean isPaga;
    private ArrayList<Observer> observers = new ArrayList<>();


    //construtor
    public Multa(String codMulta, String idUsuario, double valor, boolean isPaga) {
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
    public boolean getisPaga(){
        return isPaga;
    }
    public boolean setisPaga(boolean isPaga){
        this.isPaga = isPaga;
        return true;
    }
    
    // Métodos de Subject
    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(Multa multa) {
        for (Observer observer : observers) {
            observer.notificarMulta(multa);
        }
    }
    
    //método para gerar uma multa
    public  Multa gerarMulta(EmprestimoLivro emprestimoLivro) {
        if (emprestimoLivro.isEmprestimoAtrasado()) {
            LocalDate dataExpedicao = LocalDate.now();
            valorMulta = 3.5;
            codMulta = "M-" + emprestimoLivro.getUsuario() + "-" + dataAtual.toString();
            Multa multa = new Multa(codMulta, emprestimoLivro.getIdUsuario(), valorMulta, false);

            notificarObservers(multa);

            return multa;
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
