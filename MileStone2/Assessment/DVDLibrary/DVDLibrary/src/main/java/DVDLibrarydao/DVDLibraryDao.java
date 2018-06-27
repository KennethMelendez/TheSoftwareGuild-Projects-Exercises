/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrarydao;

import DVDLibrarydto.DVD;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface DVDLibraryDao {
    /*DATA ACCESS OBJECT*/
    
    /**
     * 
     * 
     * @param Title
     * @param dvd
     * @return 
     */
    DVD addDVD(String Title, DVD dvd)
            throws DVDLibraryDaoException;
    
    
     /**
     * 
     * @param Title
     * @return 
     */
    DVD removeDVD(String Title)
            throws DVDLibraryDaoException;
    
     /**
     * 
     * @param Title
     * @param ReleaseDate
     * @param MPAArating
     * @param DirectorsName
     * @param Studio
     * @param UserRatingOrNote
     * @return 
     */
    DVD editDVD(String Title,String ReleaseDate,String MPAArating,String DirectorsName,String Studio,String UserRatingOrNote );
    
    
     /**
     * 
     * @return 
     */
    List<DVD> displayAllDVDs()
            throws DVDLibraryDaoException;
    
    
    
    
     /**
     * 
     * @param Title
     * @return 
     */
    DVD searchDVD(String Title)
            throws DVDLibraryDaoException;
    
    
    
    /**
     * 
     * @param Title
     * @param ReleaseDate
     * @param MPAArating
     * @param DirectorsName
     * @param Studio
     * @param UserRatingOrNote
     * @return 
     */
    DVD showInfo(String Title);
}
