public class Livro{
    private String titulo;
    private String autor;
    private String isbn; 
    private int tombo;
    private EnumDisponibilidade disponibilidade;
    private ArrayList<EnumGeneros> generos;
        
    
    public Livro(){
        this.disponibilidade = EnumDisponibilidade.DISPONIVEL;
        this.generos = ArrayList<>();
    }

    public Livro(String titulo, String autor, String isbn, int tombo){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.tombo = tombo;
        this.disponibilidade = EnumDisponibilidade.DISPONIVEL;
        this.generos = ArrayList<>();
    }

    public Livro(String titulo, String autor, String isbn, int tombo, ArrayList<EnumGeneros> generos){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.tombo = tombo;
        this.disponibilidade = EnumDisponibilidade.DISPONIVEL;
        this.generos = generos;
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

    public void setTombo(int tombo){
        this.tombo = tombo;
    }

    public void setDisponibilidade(EnumDisponibilidade disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public void addGenero(EnumGeneros genero){
        generos.add(genero);
    }

    public boolean removeGenero(EnumGeneros genero){
        for(int i=0; i<generos.size(); i++){
            if(generos.get(i).equals(genero)){
                generos.remove(genero);
                return true;
            }
        }
        return false;
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

    public int getTombo(){
        return tombo;
    }

    public EnumDisponibilidade getDisponibilidade(){
        return disponibilidade;
    }

    public ArrayList<EnumGeneros> getGeneros(){
        return generos;
    }

}