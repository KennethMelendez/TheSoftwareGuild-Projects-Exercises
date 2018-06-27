/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dao;

/**
 *
 * @author kmlnd
 */
public interface AuditDao {

    public void writeAuditEntry(String entry) throws PersistenceException;
    
}
