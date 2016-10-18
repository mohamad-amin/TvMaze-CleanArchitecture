package com.sixthsolution.easymvp.domain.entity;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/18/16.
 */
public class Person {

    private int id;
    private String name;
    private FilmImageUrl image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilmImageUrl getImage() {
        return image;
    }

    public void setImage(FilmImageUrl image) {
        this.image = image;
    }

}
