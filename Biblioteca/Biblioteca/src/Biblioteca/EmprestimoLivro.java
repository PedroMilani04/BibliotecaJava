package Biblioteca;

import java.time.LocalDate;

public class EmprestimoLivro {
    private Livro livro;
    private UsuarioBiblioteca usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public EmprestimoLivro(Livro livro, UsuarioBiblioteca usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public int getIdUsuario()
    {
        return usuario.getID();
    }
    
    public UsuarioBiblioteca getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBiblioteca usuario) {
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
    
    public void exibirDetalhesEmprestimo() {
        //
    }

    public boolean isEmprestimoAtrasado() {
        return LocalDate.now().isAfter(dataDevolucao);
    }
}
