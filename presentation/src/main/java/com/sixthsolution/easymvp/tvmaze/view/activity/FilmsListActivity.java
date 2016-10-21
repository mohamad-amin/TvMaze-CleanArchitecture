package com.sixthsolution.easymvp.tvmaze.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sixthsolution.easymvp.tvmaze.R;
import com.sixthsolution.easymvp.tvmaze.internal.di.HasComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.ActivityComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerActivityComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerDataComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DataComponent;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;
import com.sixthsolution.easymvp.tvmaze.view.fragment.FilmsListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmsListActivity extends BaseActivity implements
        HasComponent<ActivityComponent>,
        NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initializeInjector();
        setupToolbar();

        if (savedInstanceState == null) {
            launchHome();
        }

    }

    private void initializeInjector() {

        DataComponent dataComponent = DaggerDataComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();

        this.activityComponent = DaggerActivityComponent.builder()
                .dataComponent(dataComponent)
                .activityModule(getActivityModule())
                .build();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void launchHome() {
        navigationView.setCheckedItem(R.id.nav_shows);
        addFragment(R.id.frame_container, new FilmsListFragment());
    }

    private void launchPeople() {
        // Todo
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        closeDrawer();

        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_shows:
                launchHome();
                return true;
            case R.id.nav_people:
                launchPeople();
                return true;
            default:
                return true;
        }

    }

    @Override
    public ActivityComponent getComponent() {
        return activityComponent;
    }
}
