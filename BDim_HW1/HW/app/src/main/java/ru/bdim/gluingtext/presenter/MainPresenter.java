package ru.bdim.gluingtext.presenter;

import ru.bdim.gluingtext.model.Model;
import ru.bdim.gluingtext.view.MainView;

public class MainPresenter {

    private MainView mainView;
    private Model model;

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
        this.model = new Model();
    }

    public void glueText(String text) {
        model.setText(model.getText() + text);
        mainView.onBtnGlueClick(model.getText());
    }
}
