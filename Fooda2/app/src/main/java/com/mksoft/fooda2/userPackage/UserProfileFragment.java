package com.mksoft.fooda2.userPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mksoft.fooda2.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class UserProfileFragment extends Fragment {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(userId);
        viewModel.getUser().observe(this, user -> {
            // Update UI.
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.user_profile, container, false);
        return rootView;
    }
}