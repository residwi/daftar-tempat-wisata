package com.residwi.tugassubmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TOUR_PHOTO = "tour_photo";
    public static final String EXTRA_TOUR_NAME = "tour_name";
    public static final String EXTRA_TOUR_DETAIL = "tour_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setActionBarTitle("Detail Wisata");

        ImageView tour_photo = findViewById(R.id.tour_photo);
        TextView tour_name = findViewById(R.id.tour_name);
        TextView tour_detail = findViewById(R.id.tour_detail);
        String name = getIntent().getStringExtra(EXTRA_TOUR_NAME);
        String detail = getIntent().getStringExtra(EXTRA_TOUR_DETAIL);
        int photo = getIntent().getIntExtra(EXTRA_TOUR_PHOTO, 0);

        Drawable drawablePhoto = ContextCompat.getDrawable(this, photo);

        tour_name.setText(name);
        tour_detail.setText(detail);
        tour_photo.setImageDrawable(drawablePhoto);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
