package exceptions;

/**
 * Excepción personalizada lanzada cuando una solución no ha sido implementada
 */
public class NotImplementedException extends UnsupportedOperationException {

    /**
     * Constructor. Lanza una excepción con el mensaje "Intenta
     * resolverlo"
     */
    public NotImplementedException() {
        super("Intenta resolverlo");
    }

    /**
     * Constructor. Lanza una excepción con el mensaje recibido por parámetro
     * 
     * @param message el mensaje a lanzar
     */
    public NotImplementedException(String message) {
        super(message);
    }
}
