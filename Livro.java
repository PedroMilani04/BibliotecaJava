public class Livro{
    private String titulo;
    private String autor;
    private String isbn; 
    private boolean disponibilidade;

    public Livro(){
        this.disponibilidade = true;
    }

    public Livro(String titulo, String autor, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponibilidade = true;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getIsbn(){
        return isbn;
    }

    public boolean getDisponibilidade(){
        return disponibilidade;
    }
}