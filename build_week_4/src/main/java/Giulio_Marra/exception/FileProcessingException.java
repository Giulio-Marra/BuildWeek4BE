package Giulio_Marra.exception;

public class FileProcessingException extends  RuntimeException{
    public FileProcessingException(String nameFile){
        super("Errore durante l'elaborazione del file "+nameFile);
    }
}
