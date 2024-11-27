package Biblioteca;

import java.util.ArrayList;

public class Titulo {
	private ArrayList<Livro> livros;
	private int disponivel;
	private int emprestimo;

	Titulo(Livro livro, int disponivel, int emprestimo){
		if(this.livros==null){
			this.livros = new ArrayList<Livro>();
		}
		this.livros.add(livro);
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
	public void addLivro(Livro livro){
		livros.add(livro);
	}

	private Livro busca(int posicao){
		return livros.get(posicao);
	}

	public void mudarDisponibilidade(int posicao, EnumDisponibilidade disponibilidade){
		busca(posicao).setDisponibilidade(disponibilidade);
	}

	public boolean compararIsbn(String isbn){
		if(getLivros().get(0).getIsbn().equals(isbn)){
			return true;
		}
		return false;
	}

	public boolean compararNome(String nome){
		if(getLivros().get(0).getTitulo().equals(nome)){
			return true;
		}
		return false;
	}

	public boolean compararAutor(String autor){
		if(getLivros().get(0).getAutor().equals(autor)){
			return true;
		}
		return false;
	}

	public int criarTombo(){
		return getLivros().size()-1;
	}
	
	public void adicionarLivros(Livro livro){
		getLivros().add(livro);
	}

	public int buscarTombo(int posicao){
		return getLivros().get(posicao).getTombo();
	}

	public void deletarLivro(int tombo){
		getLivros().remove(tombo);
	}

	public int tamanhoLivros(){
		return getLivros().size();
	}

	public String procurarGeneros(ArrayList genero){
		// for(int i=0; i<tamanhoLivros(); i++){
		// 	for(int j=0; j<genero.size(); j++){
		// 		if(=genero.get(j)){
		// 			return true;
		// 		}
		// 	}
		// }
		return getLivros().getGenero();
	}

	public int procurarDisponivel(){
		for(int j=0; j<tamanhoLivros(); j++){
			if(busca(j).getDisponibilidade().equals(EnumDisponibilidade.DISPONIVEL)){
				return busca(j).getTombo();
			}
		}
		return -1;
		
	}

}    