package br.com.uniamerica.passwordmanager.exceptions;

public class PasswordNotFound extends RuntimeException{

    public PasswordNotFound() {
        super("Senha não encontrada no banco de dados.");
    }
}
