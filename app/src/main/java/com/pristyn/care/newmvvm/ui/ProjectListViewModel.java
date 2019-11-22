package com.pristyn.care.newmvvm.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pristyn.care.newmvvm.models.Project;
import com.pristyn.care.newmvvm.repository.MvvmRepository;

import java.util.List;


public class ProjectListViewModel extends ViewModel {
     private final LiveData<List<Project>> projectListObservable;


    public ProjectListViewModel(/*@NonNull Application application*/) {
        //super(application);
        projectListObservable = MvvmRepository.getInstance().getProjectList("Google");
    }
    // TODO: Implement the ViewModel

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
