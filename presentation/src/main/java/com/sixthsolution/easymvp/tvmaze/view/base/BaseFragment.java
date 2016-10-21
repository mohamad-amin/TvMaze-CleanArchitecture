package com.sixthsolution.easymvp.tvmaze.view.base;

import android.support.v4.app.Fragment;

import com.sixthsolution.easymvp.tvmaze.internal.di.HasComponent;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
public class BaseFragment extends Fragment {

    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }

}
