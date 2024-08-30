package POOII.BibliotecaJava;


public class UsuarioBiblioteca extends Usuario {


    //preciso criar um array de emprestimos

    public UsuarioBiblioteca(String nome, String email, String CPF){
        super(nome, email, CPF);
    }

    public int getID(){
        return ID;
    }

    //exibir emprestimos
    //exibir multas

    // public void procurarLivro(String titulo){
    //     System.out.println("Procurando livro: " + titulo);
    //     if(titulo == l.titulo){
    //         System.out.println("Livro encontrado: " + l.titulo
    //                             + "\nAutor: " + l.autor
    //                             + "\nAno: " + l.isbn);
    //     }
    // }
    
}
