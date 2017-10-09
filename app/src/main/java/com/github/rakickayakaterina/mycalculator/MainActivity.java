package com.github.rakickayakaterina.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mInputEditText;
    private TextView mOutputTextView;
    private View mEvaluateButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void initView(){
        mInputEditText = (EditText) findViewById(R.id.input_edit_text);
        mEvaluateButton = findViewById(R.id.evaluate_button);
        mEvaluateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }

        });
        mOutputTextView = (TextView) findViewById(R.id.output__text_view);
    }
}
