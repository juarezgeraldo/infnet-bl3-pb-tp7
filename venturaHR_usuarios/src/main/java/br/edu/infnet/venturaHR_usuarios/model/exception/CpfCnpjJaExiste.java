package br.edu.infnet.venturaHR_usuarios.model.exception;

public class CpfCnpjJaExiste extends RuntimeException{
    public CpfCnpjJaExiste(String msg){
        super(msg);
    }
}
