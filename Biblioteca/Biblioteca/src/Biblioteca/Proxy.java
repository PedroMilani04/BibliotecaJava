package Biblioteca;

public class Proxy {
    protected Cadastro cad = new Cadastro();

    public Proxy(){
        //Construtor vazio
    }

    public Usuario verificacaoEmail(String email, String senha){
        if(Cadastro.verificarEmailESenha(email, senha)){
            Usuario usu = Cadastro.returnUsuarioEmail(email); //Pego o usuário com o email
            return usu; //Retorno o usuário caso a senha e email estejam corretos
        }
        System.out.println("Email ou senha incorretos"); //Não posso falar qual está incorreto para não dar brecha para hackers
        return null;
    }

    public Usuario verificacaoNickname(String nickname, String senha){
        if(Cadastro.verificarNicknameESenha(nickname, senha)){
            Usuario usu = Cadastro.returnUsuarioNickname(nickname); //Pego o usuário com o nickname
            return usu; //Retorno o usuário caso a senha e nickname estejam corretos
        }
        System.out.println("Nickname ou senha incorretos"); //Não posso falar qual está incorreto para não dar brecha para hackers
        return null;
    }
}