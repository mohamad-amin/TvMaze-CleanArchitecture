package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
@Parcel
public class FilmRating {

    double average;

    @ParcelConstructor
    public FilmRating(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
