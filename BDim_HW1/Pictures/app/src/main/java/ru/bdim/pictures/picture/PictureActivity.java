package ru.bdim.pictures.picture;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.SyncStateContract;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import ru.bdim.pictures.R;
import ru.bdim.pictures.model.Constants;

public class PictureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Intent intent = getIntent();
        if (intent != null){
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            ImageView image = findViewById(R.id.img_picture);
            TypedArray imageArray = getResources().obtainTypedArray(intent.getIntExtra(Constants.ARRAY, -1));
            int i = imageArray.getResourceId(intent.getIntExtra(Constants.INDEX, 0), -1);
            imageArray.recycle();
            Picasso.with(this).load(i).into(image);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}