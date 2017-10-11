package com.github.rakickayakaterina.mycalculator;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rakickayakaterina.mycalculator.logic.Calculator;
import com.github.rakickayakaterina.mycalculator.logic.ICalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    private ActivityController<MainActivity> mMainActivityController;
    private MainActivity mMainActivity;
    @Mock
    private ICalculator mCalculator;
    EditText mInputFirstOp;
    EditText mInputSecondOp;
    View mAddButton;
    View mSubButton;
    View mMulButton;
    View mDivButton;

    @Before
    public void initialize() {
        mMainActivityController = Robolectric.buildActivity(MainActivity.class).create().start().resume();
        mMainActivity = mMainActivityController.get();
        mInputFirstOp = (EditText) mMainActivity.findViewById(R.id.inputFirstOp_edit_text);
        mInputSecondOp = (EditText) mMainActivity.findViewById(R.id.inputSecondOp_edit_text);
        mAddButton = mMainActivity.findViewById(R.id.add_button);
        mSubButton = mMainActivity.findViewById(R.id.sub_button);
        mMulButton = mMainActivity.findViewById(R.id.mul_button);
        mDivButton = mMainActivity.findViewById(R.id.div_button);
    }

    @Test
    public void testStartState() {

        assertTrue(mInputFirstOp != null);
        assertTrue(mInputSecondOp != null);
        assertTrue(mInputFirstOp.isEnabled());
        assertTrue(mInputSecondOp.isEnabled());
        assertTrue(!mAddButton.isEnabled());
        assertTrue(!mSubButton.isEnabled());
        assertTrue(!mMulButton.isEnabled());
        assertTrue(!mDivButton.isEnabled());

    }

    @Test
    public void testBehavior() {
        mInputFirstOp.setText("the first number");
        assertTrue(!mAddButton.isEnabled());
        assertTrue(!mSubButton.isEnabled());
        assertTrue(!mMulButton.isEnabled());
        assertTrue(!mDivButton.isEnabled());

        mInputSecondOp.setText("the second number");
        assertTrue(mAddButton.isEnabled());
        assertTrue(mSubButton.isEnabled());
        assertTrue(mMulButton.isEnabled());
        assertTrue(mDivButton.isEnabled());

        mInputSecondOp.setText("");
        assertTrue(mInputSecondOp.isEnabled());
        assertTrue(!mAddButton.isEnabled());
        assertTrue(!mSubButton.isEnabled());
        assertTrue(!mMulButton.isEnabled());
        assertTrue(!mDivButton.isEnabled());
    }

    @Test
    public void testMockCalculator() {
        final TextView answer = (TextView) mMainActivity.findViewById(R.id.output__text_view);
        mCalculator = mock(ICalculator.class);
        when(mCalculator.add(1.0, 2.0)).thenReturn(3.0);
        when(mCalculator.sub(1.0, 2.0)).thenReturn(-1.0);
        when(mCalculator.mul(1.0, 2.0)).thenReturn(2.0);
        when(mCalculator.div(1.0, 2.0)).thenReturn(0.5);
        mMainActivity.setCalculator(mCalculator);
        mInputFirstOp.setText("1");
        mInputSecondOp.setText("2");

        mAddButton.performClick();
        assertEquals("3.0", answer.getText());
        mSubButton.performClick();
        assertEquals("-1.0", answer.getText());
        mMulButton.performClick();
        assertEquals("2.0", answer.getText());
        mDivButton.performClick();
        assertEquals("0.5", answer.getText());
    }
    @Test
    public void testSpyCalculator() {
        final TextView answer = (TextView) mMainActivity.findViewById(R.id.output__text_view);
        mCalculator = spy(Calculator.class);

        mMainActivity.setCalculator(mCalculator);
        mInputFirstOp.setText("10");
        mInputSecondOp.setText("2");

        mAddButton.performClick();
        assertEquals("12.0", answer.getText());
        mSubButton.performClick();
        assertEquals("8.0", answer.getText());
        mMulButton.performClick();
        assertEquals("20.0", answer.getText());
        mDivButton.performClick();
        assertEquals("5.0", answer.getText());

    }
    @After
    public void destroy(){
        mMainActivityController.pause().stop().destroy();
    }
}