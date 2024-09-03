public class Livro{
    private String titulo;
    private String autor;
    private int isbn; 
    //private int quantPag;

    public Livro(){
        
    }

    public Livro(String titulo, String autor, int isbn, int quantPag){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        //this.quantPag = quantPag;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setIsbn(int isbn){
        this.isbn = isbn;
    }

    /*public void setQuantPag(int quantPag){
        this.quantPag = quantPag;
    }*/

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getIsbn(){
        return isbn;
    }

    /*public int getQuantPag(){
        return quantPag;
    }*/
}