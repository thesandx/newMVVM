package com.pristyn.care.newmvvm.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pristyn.care.newmvvm.R;
import com.pristyn.care.newmvvm.databinding.ProjectListFragmentBinding;

public class ProjectListFragment extends Fragment {

    private ProjectListViewModel mViewModel;
    ProjectListFragmentBinding binding;



    public static ProjectListFragment newInstance() {
        return new ProjectListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ProjectListFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);
        // TODO: Use the ViewModel

        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewmodel(mViewModel);
//        mViewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                binding.tvName.setText(s);
//            }
//        });
    }

}
