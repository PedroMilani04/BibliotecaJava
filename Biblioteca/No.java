package Biblioteca;

import java.util.ArrayList;

public class No {
	protected ArrayList<Livro> livros = new ArrayList<Livro>();
	protected int disponivel;
	protected int emprestimo;
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	public int getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}
	public int getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(int emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}
    

