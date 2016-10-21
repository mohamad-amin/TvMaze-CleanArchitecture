package com.sixthsolution.easymvp.tvmaze.view.base;

import com.sixthsolution.easymvp.domain.entity.Film;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public interface FilmDetailView extends BaseView {

    void showFilm(Film film);

}
