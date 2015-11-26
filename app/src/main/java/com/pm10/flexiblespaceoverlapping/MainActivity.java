package com.pm10.flexiblespaceoverlapping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    SampleAdapter sampleAdapter;
    LinearLayoutManager linearLayoutManager;

    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sampleAdapter = new SampleAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(sampleAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        users = new ArrayList<>();
        addDummy(30);
        sampleAdapter.resetAll(users);
    }

    void addDummy(int count) {
        for (int i = 0; i <= count; i++) {
            users.add(new User("name" + String.valueOf(i), "age" + String.valueOf(i)));
        }
    }
}
