package ru.bdim.gluingtext.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.bdim.gluingtext.R;
import ru.bdim.gluingtext.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;

    private TextView txtText;
    private EditText etxEnter;

    private static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT, txtText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtText.setText(savedInstanceState.getString(TEXT));
    }

    @Override
    public void onBtnGlueClick(String text) {
        txtText.setText(text);
        etxEnter.setText("");
    }
}