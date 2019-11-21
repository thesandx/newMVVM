package com.pristyn.care.newmvvm.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ProjectListViewModel extends ViewModel {
     MutableLiveData<String> name;


    public ProjectListViewModel(/*@NonNull Application application*/) {
        //super(application);
        name = new MutableLiveData<>();
        name.setValue("Sandeep");
    }
    // TODO: Implement the ViewModel

    public LiveData<String> getName() {
        return name;
    }

    public void onButtonClick(String string) {
        setName(string);
    }

    public void setName(String name) {
        this.name.setValue(name);
    }
}
