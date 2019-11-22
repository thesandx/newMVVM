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
import com.pristyn.care.newmvvm.databinding.ProjectListFragmentBinding;
import com.pristyn.care.newmvvm.models.Project;

import java.util.List;

public class ProjectListFragment extends Fragment {

    private ProjectListViewModel mViewModel;
    ProjectAdapter projectAdapter;
    ProjectListFragmentBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ProjectListFragmentBinding.inflate(inflater, container, false);
        projectAdapter = new ProjectAdapter();
        binding.projectList.setAdapter(projectAdapter);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewmodel(mViewModel);
        observeViewModel(mViewModel);
//        mViewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                binding.tvName.setText(s);
//            }
//        });
    }


//for observing the change in projectList
    private void observeViewModel(ProjectListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(getViewLifecycleOwner(), new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
//                    binding.setIsLoading(false);
                    projectAdapter.setProjectList(projects);
                }
            }
        });
    }


}
