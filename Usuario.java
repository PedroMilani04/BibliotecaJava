package POOII.BibliotecaJava;

public class Usuario {
    protected static int nextID = 1;
    protected String nome;
    protected String email;
    protected String CPF;
    protected int ID; //ID n segnifica o numero de usuarios cadastrados, mas sim o numero de usuarios criados, pode haver eliminacao de usuarios


    public Usuario(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        // if(CPF.length() != 11){
        //     throw new IllegalArgumentException("CPF inválido"); //Bloqueia a criação do objeto por invalidez de CPF
        // }
        this.CPF = CPF;
        this.ID = nextID++;
    }

    public Usuario(){

    }

    public String getCpf(){
        return CPF;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getID(){
        return ID;
    }

    public void setCpf(String CPF){
        if(CPF.length() != 11){
            throw new IllegalArgumentException("CPF inválido"); //Bloqueia a modificação, caso seja necessario, por invalidez de CPF
        }
        this.CPF = CPF;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(int ID){ //Usar somente para teste, provavelmente dará 
        this.ID = ID;           //erro caso seja usado em produção
    }

}
