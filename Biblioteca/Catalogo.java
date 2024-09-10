package Biblioteca;
import java.util.ArrayList; 

public class Catalogo {
	protected ArrayList<Titulo> catalogo;
	
	public void inserirLivros(String titulo, String autor, String isbn){
		for(int i=0; i<catalogo.size(); i++){
			if(catalogo.get(i).getLivros().get(0).getIsbn().equals(isbn)){
				int tombo=catalogo.size()-1;
				Livro livro = new Livro(titulo, autor, isbn, tombo);
				int dispo=catalogo.get(i).getDisponivel()+1;
				catalogo.get(i).getLivros().add(livro);
				catalogo.get(i).setDisponivel(dispo);	
				return;			
			}

		}
		Livro livro = new Livro(titulo, autor, isbn, 0);
		int dispo=1;
		int emprestimo=0;
		Titulo novoNo= new Titulo(livro, dispo, emprestimo);
		catalogo.add(novoNo);
		return;
	}
	
	public boolean excluirLivro(String isbn){
		for(int i=0; i<catalogo.size();i++){
			if(catalogo.get(i).getLivros().get(0).getIsbn().equals(isbn)){
				int copias=catalogo.get(i).getLivros().size();
				if(copias==1){
					catalogo.remove(i);
				}
				catalogo.get(i).getLivros().remove(copias-1);
				return true;
			}
		}
		return false;
	}

	public boolean devolverLivro(String isbn, int tombo){
		for(int i=0; i<catalogo.size();i++){
			if(catalogo.get(i).getLivros().get(0).getIsbn().equals(isbn)){
				for(int j=0; j<catalogo.get(i).getLivros().size(); j++){
					if(tombo==catalogo.get(i).getLivros().get(j).getTombo()){
						catalogo.get(i).getLivros().get(j).setDisponibilidade(EnumDisponibilidade.DISPONIVEL);
						if(catalogo.get(i).getEmprestimo()>=0){
							int emprestimo=catalogo.get(i).getEmprestimo()-1;
							catalogo.get(i).setEmprestimo(emprestimo);	
						}
						if(catalogo.get(i).getDisponivel()<catalogo.get(i).getLivros().size()){
						int disponivel = catalogo.get(i).getDisponivel()+1;
						catalogo.get(i).setDisponivel(disponivel);
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	public EnumDisponibilidade getLivro(String isbn){
		for(int i=0; i<catalogo.size();i++){
			if(catalogo.get(i).getLivros().get(0).getIsbn().equals(isbn)){
				if(catalogo.get(i).getDisponivel()>0){
					return EnumDisponibilidade.DISPONIVEL;
				}
				return EnumDisponibilidade.RESERVADO;
			}
		}
		return null;

	}

	public void exibirLivrosIsbn(String isbn){
		for(int i=0; i<catalogo.size();i++){
			if(isbn==catalogo.get(i).getLivros().get(0).getIsbn()){
				catalogo.get(i);	
			}
		}
	}

	public void exibirLivrosNome(String nome){
		for(int i=0; i<catalogo.size();i++){
			if(catalogo.get(i).getLivros().get(0).getTitulo().equals(nome)){
				catalogo.get(i);
			}
		}
	}
	public void exibirLivrosAutor(String autor){
		for(int i=0; i<catalogo.size();i++){
			if(catalogo.get(i).getLivros().get(0).getAutor().equals(autor)){
				catalogo.get(i);
			}
		}
	}

	public static ReservaRecibo reservarLivro(Livro livro, UsuarioBiblioteca usuario)
    {
        return GerenciamentoReserva.AdicionarReservaLivro(livro,usuario);
    }

}