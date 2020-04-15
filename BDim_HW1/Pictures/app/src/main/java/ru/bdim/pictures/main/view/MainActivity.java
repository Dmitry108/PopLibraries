package ru.bdim.pictures.main.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.bdim.pictures.model.Constants;
import ru.bdim.pictures.picture.PictureActivity;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.bdim.pictures.R;
import ru.bdim.pictures.main.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private PicturesRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.initData(getResources());
        initRecycler();
    }

    private void initRecycler() {
        RecyclerView recycler = findViewById(R.id.rcw_viewer);
        recycler.setHasFixedSize(true);
        adapter = new PicturesRecyclerAdapter(getResources(), presenter.getPictures());
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recycler.setLayoutManager(manager);
        adapter.setListener(new PicturesRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                presenter.setChoice(position);
            }
        });
        recycler.setAdapter(adapter);
    }

    @Override
    public void showPicture(int array, int index) {
        Intent intent = new Intent(MainActivity.this, PictureActivity.class);
        intent.putExtra(Constants.INDEX, index);
        intent.putExtra(Constants.ARRAY, array);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.setListener(null);
    }
}