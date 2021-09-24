package br.edu.infnet.venturaHR_usuarios.model.exception;

public class UsuarioJaExiste extends RuntimeException{
    public UsuarioJaExiste(String msg){
        super(msg);
    }
}
