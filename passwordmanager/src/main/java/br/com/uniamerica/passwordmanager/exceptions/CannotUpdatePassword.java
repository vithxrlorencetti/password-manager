package br.com.uniamerica.passwordmanager.exceptions;

public class CannotUpdatePassword extends RuntimeException{

    public CannotUpdatePassword() {
        super("Não foi possível atualizar a senha.");
    }
}
