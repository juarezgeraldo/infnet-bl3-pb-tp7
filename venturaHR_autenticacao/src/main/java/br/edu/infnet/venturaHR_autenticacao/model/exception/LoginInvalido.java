package br.edu.infnet.venturaHR_autenticacao.model.exception;

public class LoginInvalido extends RuntimeException{
    public LoginInvalido(String msg){
        super(msg);
    }
}
