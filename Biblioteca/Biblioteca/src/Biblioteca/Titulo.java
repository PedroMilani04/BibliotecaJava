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

	public String getNome(){
		return getLivros().get(0).getTitulo();
	}

	public void mudarDisponibilidade(int posicao, EnumDisponibilidade disponibilidade){
		busca(posicao).setDisponibilidade(disponibilidade);
	}

	public boolean compararIsbn(String isbn){
		if(pegarISBN().equals(isbn)){
			return true;
		}
		return false;
	}

	public boolean compararNome(String nome){
		if(getNome().equals(nome)){
			return true;
		}
		return false;
	}

	public boolean compararAutor(String autor){
		if(buscarAutor().equals(autor)){
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

	public int tamanhoGeneros(){
		return getLivros().get(0).getGeneros().size();
	}

	public EnumGeneros pegarGenero(int posicao){
		return getLivros().get(0).getGeneros().get(posicao);
	}

	public String pegarISBN(){
		return getLivros().get(0).getIsbn();
	}

	public String buscarAutor(){
		return getLivros().get(0).getAutor();
	}

	public boolean procurarGeneros(ArrayList<EnumGeneros> generos){
		for(int i=0; i<generos.size(); i++){
			for(int j=0; j<tamanhoGeneros(); j++){
				if(generos.get(i)==pegarGenero(j)){
					return true;
				}
			}
		}
		return false;
		
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