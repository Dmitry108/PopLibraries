package ru.bdim.gluetextmoxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.bdim.gluetextmoxy.R;
import ru.bdim.gluetextmoxy.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView{

    @InjectPresenter
    MainPresenter presenter;

    private TextView txtText;
    private EditText etxEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtText = findViewById(R.id.txt_text);
        etxEnter = findViewById(R.id.etx_enter);
        Button btnGlue = findViewById(R.id.btn_ok);
        btnGlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.glueText(etxEnter.getText().toString());
            }
        });
    }

    @Override
    public void onBtnGlueClick(String text) {
        txtText.setText(text);
        etxEnter.setText("");
    }
}