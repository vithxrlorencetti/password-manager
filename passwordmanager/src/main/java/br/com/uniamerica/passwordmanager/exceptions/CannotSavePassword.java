package br.com.uniamerica.passwordmanager.exceptions;

public class CannotSavePassword extends RuntimeException{

    public CannotSavePassword() {
        super("Não foi possível salvar a senha.");
    }

    public CannotSavePassword(String msg) {
        super(msg);
    }
}
