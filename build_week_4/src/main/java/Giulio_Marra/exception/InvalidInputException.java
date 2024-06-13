package Giulio_Marra.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String str){
        super("L'input per la stringa "+str+" non è valida :(");
    }
}
