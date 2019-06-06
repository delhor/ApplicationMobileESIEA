package com.example.daoud.app_3aufa_elhor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.daoud.app_3aufa_elhor.retrofitgerrit.Controller;
import com.example.daoud.app_3aufa_elhor.retrofitgerrit.Country;
import com.example.daoud.app_3aufa_elhor.retrofitgerrit.OnItemClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        Controller controller = new Controller(this);
        controller.start();

    }

    public void displayCountryList(List<Country> countryList) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(countryList, new OnItemClickListener() {
            @Override
            public void onItemClick(Country item) {
                intentExtra(item);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }


    public void intentExtra(Country item){
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        intent.putExtra("capital",item.getCapital() );
        intent.putExtra("population", item.getPopulation());
        intent.putExtra("region", item.getRegion());

        startActivity(intent);
    }


}