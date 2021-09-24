package br.edu.infnet.venturaHR_usuarios.model.exception;

public class UsuarioNaoExiste extends RuntimeException{
    public UsuarioNaoExiste(String msg){
        super(msg);
    }
}
