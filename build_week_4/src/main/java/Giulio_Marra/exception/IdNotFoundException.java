package Giulio_Marra.exception;

public class IdNotFoundException extends  RuntimeException{
    public IdNotFoundException(long id){
        super("Il record con l'id " + id + " non è stato trovato mi dispiace :(");
    }
}
