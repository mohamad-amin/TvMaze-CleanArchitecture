package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
@Parcel
public class Producer {

    int id;
    String name;
    Country country;

    @ParcelConstructor
    public Producer(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
