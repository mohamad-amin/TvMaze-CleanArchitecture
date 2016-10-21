package com.sixthsolution.easymvp.tvmaze.view.base;

import com.sixthsolution.easymvp.domain.entity.Film;

import java.util.List;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public interface FilmsListView extends BaseView {

    void showFilms(List<Film> films);

}
