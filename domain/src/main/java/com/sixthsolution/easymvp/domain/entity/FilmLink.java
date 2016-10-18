package com.sixthsolution.easymvp.domain.entity;

/**
 *   * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 8/27/16.
 */
public class FilmLink {

    private FilmUrl self, previousEpisode;

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
