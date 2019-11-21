package com.pristyn.care.newmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pristyn.care.newmvvm.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //replace with fragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new ProjectListFragment())
                    .commit();

        }
    }
}
