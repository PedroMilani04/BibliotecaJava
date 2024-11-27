package com.mycompany.bibliotecafinal;
// Gerencimaneto Reserva: possui metodos statics para que o usuario utilize
// sendo possivel as seguintes funcionalidades
//
// 1- AdicionarReservaLivro
// cria e retorna um recibo para o usuario, parametros livro e usuario respectivamente
// existe medidas para cuidar de livros reservados e nao reservados, sempre retornando
// um recibo e adicionando um usuario a Reserva do livro em questao
//
// 2- RemoverReservaLivro
// literalmente remove um livro da reserva junto com os usuarios, tomar cuidado com isso kk
//
// 3- RetirarReservaUsandoRecibo
// retorna true ou false, parametro o recibo
// --se for true, o usuario eh removido do arrayUsuarios da reserva, que gerencia um
// livro, entao tomar cuidado que ele sera retirado apos a utilizacao
//
// --se for false, nada acontece lol


// Reserva: cuida de livros individualmente, gerenciando os usuarios e o tempo tambem
// porem como nao possui um sistema de prioridade no momento, o tempo eh indiferente
// para possiveis funcionalidades futuras
// nota: um objeto Reserva eh criado para cada livro, logo uma reserva possui apenas
// um livro e nada mais


// ReservaRecibo: so pra ter ctz q o usuario reservou, os recibos estao dentro dos usuarios


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
    
    
    public void setDisponibilidade( EnumDisponibilidade disponibilidade){
        livro.setDisponibilidade(disponibilidade);
    }
}
