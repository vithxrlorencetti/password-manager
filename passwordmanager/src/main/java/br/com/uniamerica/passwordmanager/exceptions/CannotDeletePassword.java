package br.com.uniamerica.passwordmanager.exceptions;

public class CannotDeletePassword extends RuntimeException{

    public CannotDeletePassword() {
        super("Não foi possível deletar a senha.");
    }
}
