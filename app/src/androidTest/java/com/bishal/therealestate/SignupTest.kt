package com.bishal.therealestate


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignupTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashScreenActivity::class.java)

    @Test
    fun signupTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.btnSignup), withText("SignUp"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.linearlayout),
                        3
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        materialButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.etName),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        appCompatEditText.perform(replaceText("bishal"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etAdress),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        appCompatEditText2.perform(replaceText("bishal"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.etPhone),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        appCompatEditText3.perform(replaceText("bishal"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.etUser),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        appCompatEditText4.perform(replaceText("bishal"), closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.etPass),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        appCompatEditText5.perform(replaceText("bishal"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnSubmit), withText("Submit"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        6
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        materialButton2.perform(click())

        val button = onView(
            allOf(
                withId(R.id.btnSignup), withText("SIGNUP"),
                withParent(withParent(withId(R.id.linearlayout))),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        button.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
