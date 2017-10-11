package com.github.rakickayakaterina.mycalculator;

import android.content.Intent;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initialize() {
        mActivityTestRule.launchActivity(new Intent());
    }

    @Test
    public void testCalculator() {
        final ViewInteraction inputFirstOp = onView(withId(R.id.inputFirstOp_edit_text));
        final ViewInteraction inputSecondOp = onView(withId(R.id.inputSecondOp_edit_text));
        final ViewInteraction addButton = onView(withId(R.id.add_button));
        final ViewInteraction subButton = onView(withId(R.id.sub_button));
        final ViewInteraction mulButton = onView(withId(R.id.mul_button));
        final ViewInteraction divButton = onView(withId(R.id.div_button));
        final ViewInteraction outputTextView = onView(withId(R.id.output__text_view));

        inputFirstOp.perform(typeText("3"));
        inputSecondOp.perform(typeText("1"));

        addButton.perform(click());
        outputTextView.check(matches(withText("4.0")));
        subButton.perform(click());
        outputTextView.check(matches(withText("2.0")));
        mulButton.perform(click());
        outputTextView.check(matches(withText("3.0")));
        divButton.perform(click());
        outputTextView.check(matches(withText("3.0")));

    }
}
