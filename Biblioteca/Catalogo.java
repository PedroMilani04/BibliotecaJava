package Biblioteca;
import java.util.ArrayList; 

public class Catalogo {
	protected ArrayList<No> catalogo;
	
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
		No novoNo= new No(livro, dispo, emprestimo);
		catalogo.add(novoNo);
		return;
	}
	
	public boolean excluirLivro(String isbn){
		for(int i=0; i<catalogo.size();i++){
			if(catalogo.get(i).getLivros().get(0).getIsbn().equals(isbn)){
				catalogo.remove(i);
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
			if(isbn==catalogo.get(i).getLivros().get(0).getIsbn()){
				if(catalogo.get(i).getDisponivel()>0){
					return EnumDisponibilidade.DISPONIVEL;
				}
				return EnumDisponibilidade.RESERVADO;
			}
		}
		return null;

	}
}