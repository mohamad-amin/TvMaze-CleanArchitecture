package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/18/16.
 */
@Parcel
public class People {

    double score;
    Person person;

    @ParcelConstructor
    public People(double score, Person person) {
        this.score = score;
        this.person = person;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
