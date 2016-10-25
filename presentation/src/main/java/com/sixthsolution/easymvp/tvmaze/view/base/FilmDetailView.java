package com.sixthsolution.easymvp.tvmaze.view.base;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public interface FilmDetailView extends BaseView {

    void showType(String type);
    void showRate(double rate);
    void showTitle(String title);
    void showGenres(String genres);
    void showStatus(String status);
    void showSummary(String summary);
    void showRuntime(String runtime);
    void showNetwork(String network);
    void showSchedule(String schedule);
    void showLanguage(String language);

}
