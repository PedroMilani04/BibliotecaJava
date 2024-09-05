package POOII.BibliotecaJava;


public class ReservaRecibo {
    private Livro livro;
    private UsuarioBiblioteca usuario;
    
    public ReservaRecibo(Livro livro, UsuarioBiblioteca usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public UsuarioBiblioteca getUsuario() {
        return usuario;
    }
    
}
