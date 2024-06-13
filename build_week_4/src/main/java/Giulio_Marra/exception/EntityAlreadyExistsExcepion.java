package Giulio_Marra.exception;

public class EntityAlreadyExistsExcepion extends RuntimeException{
    public EntityAlreadyExistsExcepion(String entityName){
        super("L'entità "+entityName+" esiste già");
    }
}
