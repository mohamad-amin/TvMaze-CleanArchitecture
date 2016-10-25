package com.sixthsolution.easymvp.tvmaze.internal.di.component;

import com.sixthsolution.easymvp.tvmaze.internal.di.module.ActivityModule;
import com.sixthsolution.easymvp.tvmaze.view.activity.FilmDetailActivity;
import com.sixthsolution.easymvp.tvmaze.view.adapter.FilmListAdapter;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;
import com.sixthsolution.easymvp.tvmaze.view.fragment.FilmsListFragment;

import dagger.Component;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Component(
        modules = ActivityModule.class,
        dependencies = DataComponent.class
)
public interface ActivityComponent {

    void inject(FilmsListFragment fragment);
    void inject(FilmDetailActivity activity);

    BaseActivity provideBaseActivity();

}
