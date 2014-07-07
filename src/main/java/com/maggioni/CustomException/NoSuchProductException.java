package com.maggioni.CustomException;

/**
 * http://javarevisited.blogspot.de/2014/06/how-to-create-custom-exception-in-java.html
 *
 * @author maggioni
 */
public class NoSuchProductException extends RuntimeException {

    private int productId;

    public NoSuchProductException() {
        super();
    }

    public NoSuchProductException(String message, int productId) {
        super(message);
        this.productId = productId;
    }

    public NoSuchProductException(String message, int productId, Throwable cause) {
        super(message, cause);
        this.productId = productId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " for productId :" + productId;
    }

    public int getProductId() {
        return productId;
    }
    
}
