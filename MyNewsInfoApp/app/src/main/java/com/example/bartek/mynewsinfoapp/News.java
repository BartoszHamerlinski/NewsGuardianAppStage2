package com.example.bartek.mynewsinfoapp;

import java.util.Date;

public class News {

    /**
     * Title of the news
     */
    private final String newsTitle;

    /**
     * Section name of the news
     */
    private final String newsSectionName;

    /**
     * Author name of the news
     */
    private final String newsAuthorName;
    /**
     * Publication date of the news story.
     */
    private final Date publicationDate;
    /**
     * Website URL of the news
     */
    private final String newsUrl;


    public News (String title, String section, String author, String url, Date date){
        newsTitle = title;
        newsSectionName = section;
        newsAuthorName = author;
        newsUrl = url;
        publicationDate = date;
    }
    /**
     * Returns the magnitude of the news.
     */
    public String getTitle() {
        return newsTitle;
    }

    /**
     * Returns the section name of the news.
     */
    public String getSectionName() {
        return newsSectionName;
    }

    /**
     * Returns the author of the news.
     */
    public String getAuthorName() {
        return newsAuthorName;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return newsUrl;
    }

    public Date getDate(){
        return publicationDate;
    }

}
