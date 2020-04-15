package ru.bdim.pictures.main.presenter;

import android.content.res.Resources;
import android.util.Log;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.bdim.pictures.R;
import ru.bdim.pictures.main.view.MainView;
import ru.bdim.pictures.model.Constants;
import ru.bdim.pictures.model.Model;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Model model;

    public MainPresenter(){
        model = new Model(R.array.pictures);
    }

    public int getPictures(){
        return model.getArrayId();
    }

    public void setChoice(int position) {
        int f = model.increase(position);
        Log.d(Constants.TAG, String.format("№%d - %d", position, f));
        getViewState().showPicture(model.getArrayId(), position);
    }

    public void initData(Resources res) {
        model.initArray(res.getIntArray(model.getArrayId()).length);
    }
}