package Giulio_Marra.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String name){
        super("Attenzione!!! L'utente "+name + " non esiste mi dispiace");
    }
}
