/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.servicelayer;

/**
 *
 * @author kmlnd
 */
public class RemoveOrderException extends Exception {

    public RemoveOrderException(String message) {
        super(message);
    }

    public RemoveOrderException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
