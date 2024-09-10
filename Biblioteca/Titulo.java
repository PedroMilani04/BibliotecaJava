package Biblioteca;

import java.util.ArrayList;

public class Titulo {
	protected ArrayList<Livro> livros;
	protected int disponivel;
	protected int emprestimo;

	Titulo(ArrayList<Livro> livros, int disponivel, int emprestimo){
		this.livros=livros;
		this.disponivel=disponivel;
		this.emprestimo=emprestimo;
	}
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
    

