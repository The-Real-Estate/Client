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
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MapsTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashScreenActivity::class.java)

    @Test
    fun mapsTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.etUsername),
                childAtPosition(
                    allOf(
                        withId(R.id.linearlayout),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
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
                withId(R.id.etPassword),
                childAtPosition(
                    allOf(
                        withId(R.id.linearlayout),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        appCompatEditText2.perform(replaceText("bishal"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.btnLogin), withText("Log In"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.linearlayout),
                        3
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        materialButton.perform(click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.navigation_aboutus), withContentDescription("Aboutus"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttomNav),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        bottomNavigationItemView.perform(click())

        val view = onView(
            allOf(
                withContentDescription("ArtistChaiyo. "),
                withParent(
                    allOf(
                        withContentDescription("Google Map"),
                        withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        Thread.sleep(5000)
        view.check(matches(isDisplayed()))
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
