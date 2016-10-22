package com.sixthsolution.easymvp.tvmaze.view.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sixthsolution.easymvp.tvmaze.app.AppController;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.ApplicationComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DataComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.ActivityModule;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/19/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Adds a {@link Fragment} to this activity's lay4out.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected AppController getAppController() {
        return (AppController) getApplication();
    }

    protected DataComponent getDataComponent() {
        return getAppController().getDataComponent();
    }

    protected ApplicationComponent getApplicationComponent() {
        return getAppController().getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
