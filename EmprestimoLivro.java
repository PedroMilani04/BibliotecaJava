package Classe2o3;

import java.time.LocalDate;

public class EmprestimoLivro {
    private String livro;
    private String usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public EmprestimoLivro(String livro, String usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public void calcularMulta(int diasAtrasados) {
        //
    }

    public void exibirDetalhesEmprestimo() {
        //
    }

    public boolean isEmprestimoAtrasado() {
        return LocalDate.now().isAfter(dataDevolucao);
    }
}
