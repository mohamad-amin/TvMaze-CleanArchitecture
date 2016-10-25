package com.sixthsolution.easymvp.domain.entity;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
@Parcel
public class FilmUrl {

    String href;

    @ParcelConstructor
    public FilmUrl(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}