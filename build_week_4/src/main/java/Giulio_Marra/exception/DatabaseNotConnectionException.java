package Giulio_Marra.exception;

public class DatabaseNotConnectionException extends RuntimeException{
    public DatabaseNotConnectionException(String dbName){
        super("Impossibile connettersi al database: "+dbName);
    }
}
