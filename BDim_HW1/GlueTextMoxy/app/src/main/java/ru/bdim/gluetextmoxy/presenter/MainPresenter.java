package ru.bdim.gluetextmoxy.presenter;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.bdim.gluetextmoxy.model.Model;
import ru.bdim.gluetextmoxy.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Model model;

    public MainPresenter(){
        model = new Model();
    }

    public void glueText(String text) {
        model.setText(model.getText() + text);
        getViewState().onBtnGlueClick(model.getText());
    }
}