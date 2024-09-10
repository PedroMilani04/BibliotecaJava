package Biblioteca;
import java.util.ArrayList; 

public class Catalogo {
	protected ArrayList<No> catalogo= new ArrayList<No>();;
	
	public void inserirLivros(String titulo, String autor, String isbn){
		for(int i=0; i<catalogo.size(); i++){
			if(isbn==catalogo.get(i).livros.get(0).getIsbn()){
				int tombo=catalogo.size()-1;
				Livro livro = new Livro(titulo, autor, isbn, tombo);
				int dispo=catalogo.get(i).getDisponivel()+1;
				
				catalogo.add(livro,dispo, catalogo.get(i).getEmprestimo());	
				return;			
			}

		}
		catalogo.add(new Livro(titulo, autor, isbn, 0), 1,0);
		return;
	}
	
	public boolean excluirLivro(String isbn){
		for(int i=0; i<catalogo.size();i++){
			if(isbn==catalogo.get(i).livros.get(0).getIsbn()){
				catalogo.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean devolverLivro(String isbn, int tombo){
		for(int i=0; i<catalogo.size();i++){
			if(isbn==catalogo.get(i).livros.get(0).getIsbn()){
				for(int j=0; j<catalogo.get(i).livros.size(); j++){
					if(tombo==catalogo.get(i).livros.get(j).getTombo()){
						catalogo.get(i).livros.get(j).setDisponibilidade(DISPONIVEL);
						if(catalogo.get(i).getEmprestimo()>=0){
							int emprestimo=catalogo.get(i).getEmprestimo()-1;
							catalogo.get(i).setEmprestimo(emprestimo);	
						}
						if(catalogo.get(i).getDisponivel()<catalogo.get(i).livros.size()){
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
			if(isbn==catalogo.get(i).livros.get(0).getIsbn()){
				if(catalogo.get(i).getDisponivel()>0){
					return DISPONIVEL;
				}
				return RESERVADO;
			}
		}

	}
}