package Biblioteca;


public class Proxy {
    protected Cadastro cad = new Cadastro();

    public Proxy(){
        //Construtor vazio
    }

    public Usuario verificacaoEmail(String email, String senha){
        if(cad.ht_email_for_cad.containsKey(email)){
            if(cad.ht_email_for_cad.get(email).getSenha().equals(senha)){ //Pego um cadastro com a função inicial e dps pego a senha do cadastro
                Usuario usu = cad.returnUsuarioEmail(email); //Pego o usuário com o email
                return usu; //Retorno o usuário caso a senha e email estejam correto
            }
        }
            System.out.println("Email ou senha incorretos"); //Não posso falar qual está incorreto para não dar brecha para hackers
            return null;
    }

    public Usuario verificacaoNickname(String nickname, String senha){
        if(cad.ht_nickname_for_cad.containsKey(nickname)){
            if(cad.ht_nickname_for_cad.get(nickname).getSenha().equals(senha)){ //Pego um cadastro com a função inicial e dps pego a senha do cadastro
                Usuario usu = cad.returnUsuarioNickname(nickname); //Pego o usuário com o nickname
                return usu; //Retorno o usuário caso a senha e nickname estejam correto
            }
        }
            System.out.println("Nickname ou senha incorretos"); //Não posso falar qual está incorreto para não dar brecha para hackers
            return null;
    }

    
}
