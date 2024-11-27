package Biblioteca;

import java.util.ArrayList; 

public class Catalogo {
	protected ArrayList<Titulo> catalogo;
        
        private static Catalogo instancia;

    // Construtor privado para evitar instância externa
    private Catalogo() {
    }

    // Método para obter a instância única
    public static synchronized Catalogo getInstancia() {
        if (instancia == null) {
            instancia = new Catalogo();
        }
        return instancia;
    }

	private Titulo busca(int posicao){
		return catalogo.get(posicao);
	}

	private int tamanhoCatalogo(){
		return catalogo.size();
	}

	private void deletarLivroCatalogo(int posicao){
		catalogo.remove(posicao);
	}

	private void adicionarNo(Titulo no){
		catalogo.add(no);
	}
	
        public int disponivel(Livro livro)
        {
            for(Titulo titulo : catalogo)
            {
                if(titulo.compararIsbn(livro.getIsbn()))
                {
                    return titulo.getDisponivel();
                }
            }
            return 0;
        }
        
	public void inserirLivros(String titulo, String autor, String isbn){
		for(int i=0; i<tamanhoCatalogo(); i++){
			if(busca(i).compararIsbn(isbn)){
				int tombo=busca(i).criarTombo();
				Livro livro = new Livro(titulo, autor, isbn, tombo);
				int dispo=busca(i).getDisponivel()+1;
				busca(i).adicionarLivros(livro);
				busca(i).setDisponivel(dispo);	
				return;			
			}

		}
		Livro livro = new Livro(titulo, autor, isbn, 0);
		int dispo=1;
		int emprestimo=0;
		Titulo novoNo= new Titulo(livro, dispo, emprestimo); // Titulo está recebendo arrayList Livro
		adicionarNo(novoNo);
		return;
	}
	
	public boolean excluirLivro(String isbn, int tombo){
		for(int i=0; i<tamanhoCatalogo();i++){
			if(busca(i).compararIsbn(isbn)){
				int copias=busca(i).tamanhoLivros();
				if(copias==1){
					deletarLivroCatalogo(i);
				}
				busca(i).deletarLivro(tombo);
				return true;
			}
		}
		return false;
	}

	public boolean devolverLivro(String isbn, int tombo){
		for(int i=0; i<tamanhoCatalogo();i++){ //percorre o catálogo comparando o isbn (rg) do livro
			if(busca(i).compararIsbn(isbn)){
				for(int j=0; j<busca(i).tamanhoLivros(); j++){ // caso tenha achado, busca o tompo dele pra mudar a disponibilidade
					if(tombo==busca(i).buscarTombo(j)){
						busca(i).mudarDisponibilidade(j, EnumDisponibilidade.DISPONIVEL); //muda disponibilidade
						if(busca(i).getEmprestimo()>=0){  //caso tenha mais um de um livro emprestado, temos que aumentar em um a quantidade de livos disponivel e diminuir a de livros emprestados
							int emprestimo=busca(i).getEmprestimo()-1;
							busca(i).setEmprestimo(emprestimo);	
						}
						int disponivel = busca(i).getDisponivel()+1; //aumenta em um a disponibilidade
						busca(i).setDisponivel(disponivel);
						return true;
					}
				}
			}
		}
		return false;
	}
	public EnumDisponibilidade getLivro(String isbn){
		for(int i=0; i<tamanhoCatalogo();i++){
			if(busca(i).compararIsbn(isbn)){
				if(busca(i).getDisponivel()>0){
					return EnumDisponibilidade.DISPONIVEL;
				}
				return EnumDisponibilidade.RESERVADO;
			}
		}
		return null;

	}

	public void exibirLivrosIsbn(String isbn){
		for(int i=0; i<tamanhoCatalogo();i++){
			if(busca(i).compararIsbn(isbn)){
				busca(i);	
			}
		}
	}

	public void exibirLivrosNome(String nome){
		for(int i=0; i<tamanhoCatalogo();i++){
			if(busca(i).compararNome(nome)){
				busca(i);
			}
		}
	}
	public void exibirLivrosAutor(String autor){
		for(int i=0; i<tamanhoCatalogo();i++){
			if(busca(i).compararAutor(autor)){
				busca(i);
			}
		}
	}

	public void exibirLivrosGenero(ArrayList<EnumGeneros> genero){
		for(int i=0; i<genero.size(); i++){
			for(int j=0; j<tamanhoCatalogo();j++){
				if(genero.get(i)==busca(j).procurarGeneros()){
					imprimir(busca(j));
				}
			}
		}
	}

	public static ReservaRecibo reservarLivro(Livro livro, UsuarioBiblioteca usuario)
    {
        return GerenciamentoReserva.AdicionarReservaLivro(livro,usuario);
    }

}