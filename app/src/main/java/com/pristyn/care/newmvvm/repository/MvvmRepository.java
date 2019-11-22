package com.pristyn.care.newmvvm.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pristyn.care.newmvvm.models.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MvvmRepository {

    private static MvvmRepository sInstance;
    Services services;

    private MvvmRepository(){
        //create retrofit here
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Services.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       services = retrofit.create(Services.class);

    }

    //make this a singleton
    public synchronized static MvvmRepository getInstance(){
        if (sInstance==null){
            sInstance = new MvvmRepository();
        }
        return sInstance;
    }


    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        services.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

}
