package Biblioteca;

public class Login<T> {
    protected Proxy proxy = new Proxy();

    public Login(){
        //Construtor vazio
    }

    public T loginEmail(String email, String senha){
        Usuario usu = proxy.verificacaoEmail(email, senha);
        if(usu != null){
            System.out.println("Login efetuado com sucesso");
            if(usu instanceof UsuarioBiblioteca){
                return (UsuarioBiblioteca)usu;
            }
            else{
                return (Bibliotecario)usu;
            }
        }
        else{
            System.out.println("Email ou senha incorretos");
            return null;
        }
    }

    public Login loginNickname(String nickname, String senha){
        Usuario usu = proxy.verificacaoNickname(nickname, senha);
        if(usu != null){
            System.out.println("Login efetuado com sucesso");
            return this;
        }
        else{
            System.out.println("Nickname ou senha incorretos");
            return null;
        }
    }


    
}
