package com.github.rakickayakaterina.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rakickayakaterina.mycalculator.logic.Calculator;
import com.github.rakickayakaterina.mycalculator.logic.ICalculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String INCORRECT_INPUT = "Incorrect input";
    private ICalculator mCalculator = new Calculator();

    private EditText mInputFirstOp;
    private EditText mInputSecondOp;

    private TextView mOutputTextView;

    private View mAddButton;
    private View mSubButton;
    private View mMulButton;
    private View mDivButton;

    public void setCalculator(final ICalculator pCalculator) {
        mCalculator = pCalculator;
    }

    @Override
    public void onClick(final View pView) {
        try {

            final Double op1 = Double.valueOf(mInputFirstOp.getText().toString());
            final Double op2 = Double.valueOf(mInputSecondOp.getText().toString());

            Double result = 0.0;
            switch (pView.getId()) {
                case R.id.add_button:
                    result = mCalculator.add(op1, op2);
                    break;
                case R.id.sub_button:
                    result = mCalculator.sub(op1, op2);
                    break;
                case R.id.mul_button:
                    result = mCalculator.mul(op1, op2);
                    break;
                case R.id.div_button:
                    result = mCalculator.div(op1, op2);
                    break;
            }
            mOutputTextView.setText(String.valueOf(result));
        } catch (final Exception e) {
            mOutputTextView.setText(INCORRECT_INPUT);
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void setEnabledButtons(final boolean pIsEnabled) {
        mAddButton.setEnabled(pIsEnabled);
        mSubButton.setEnabled(pIsEnabled);
        mMulButton.setEnabled(pIsEnabled);
        mDivButton.setEnabled(pIsEnabled);
    }

    private void initView() {
        mInputFirstOp = (EditText) findViewById(R.id.inputFirstOp_edit_text);
        mInputSecondOp = (EditText) findViewById(R.id.inputSecondOp_edit_text);

        mAddButton = findViewById(R.id.add_button);
        mAddButton.setOnClickListener(this);
        mSubButton = findViewById(R.id.sub_button);
        mSubButton.setOnClickListener(this);
        mMulButton = findViewById(R.id.mul_button);
        mMulButton.setOnClickListener(this);
        mDivButton = findViewById(R.id.div_button);
        mDivButton.setOnClickListener(this);
        mOutputTextView = (TextView) findViewById(R.id.output__text_view);

        mInputFirstOp.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(final CharSequence pCharSequence, final int pI, final int pI1, final int pI2) {

            }

            @Override
            public void onTextChanged(final CharSequence pCharSequence, final int pI, final int pI1, final int pI2) {
                final boolean enabled = pCharSequence.length() > 0 && mInputSecondOp.getText().length() > 0;
                setEnabledButtons(enabled);

            }

            @Override
            public void afterTextChanged(final Editable pEditable) {

            }
        });
        mInputSecondOp.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(final CharSequence pCharSequence, final int pI, final int pI1, final int pI2) {

            }

            @Override
            public void onTextChanged(final CharSequence pCharSequence, final int pI, final int pI1, final int pI2) {
                final boolean enabled = pCharSequence.length() > 0 && mInputFirstOp.getText().length() > 0;
                setEnabledButtons(enabled);
            }

            @Override
            public void afterTextChanged(final Editable pEditable) {

            }
        });
    }

}
