package com.residwi.tugassubmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.residwi.tugassubmission.adapter.TourAdapter;
import com.residwi.tugassubmission.model.Tour;
import com.residwi.tugassubmission.model.ToursData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_tour;
    private ArrayList<Tour> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("Tempat Wisata");

        rv_tour = findViewById(R.id.rv_tours);
        rv_tour.setHasFixedSize(true);

        list.addAll(ToursData.getListData());
        rv_tour.setLayoutManager(new LinearLayoutManager(this));
        TourAdapter listTourAdapter = new TourAdapter(list);
        rv_tour.setAdapter(listTourAdapter);


        listTourAdapter.setOnItemClickCallback(new TourAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Tour data) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_TOUR_PHOTO, data.getPhoto());
                detailIntent.putExtra(DetailActivity.EXTRA_TOUR_NAME, data.getName());
                detailIntent.putExtra(DetailActivity.EXTRA_TOUR_DETAIL, data.getDetail());
                startActivity(detailIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AboutActivity.class);
        this.startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
