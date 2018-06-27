/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author kmlnd
 */
public class DVD {
    private String Title;
    private String ReleaseDate;
    private String MPAArating;
    private String DirectorsName;
    private String Studio;
    private String UserRatingOrNote;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public String getMPAArating() {
        return MPAArating;
    }

    public void setMPAArating(String MPAArating) {
        this.MPAArating = MPAArating;
    }

    public String getDirectorsName() {
        return DirectorsName;
    }

    public void setDirectorsName(String DirectorsName) {
        this.DirectorsName = DirectorsName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public String getUserRatingOrNote() {
        return UserRatingOrNote;
    }

    public void setUserRatingOrNote(String UserRatingOrNote) {
        this.UserRatingOrNote = UserRatingOrNote;
    }
    
    
}
