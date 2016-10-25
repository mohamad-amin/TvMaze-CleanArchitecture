package com.sixthsolution.easymvp.domain.entity;


import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
@Parcel
public class FilmLink {

    FilmUrl self, previousEpisode;

    @ParcelConstructor
    public FilmLink(FilmUrl self, FilmUrl previousEpisode) {
        this.self = self;
        this.previousEpisode = previousEpisode;
    }

    public FilmUrl getSelf() {
        return self;
    }

    public void setSelf(FilmUrl self) {
        this.self = self;
    }

    public FilmUrl getPreviousEpisode() {
        return previousEpisode;
    }

    public void setPreviousEpisode(FilmUrl previousEpisode) {
        this.previousEpisode = previousEpisode;
    }

}
