package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/18/16.
 */
@Parcel
public class Person {

    int id;
    String name;
    FilmImageUrl image;

    @ParcelConstructor
    public Person(int id, String name, FilmImageUrl image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

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
