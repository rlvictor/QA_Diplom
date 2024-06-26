package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import junit.framework.AssertionFailedError;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class NavigationSteps {
    ViewInteraction burgerButton = onView(withId(R.id.main_menu_image_button));
    ViewInteraction newsPageButton = onView(withText("News"));
    ViewInteraction mainPageButton = onView(withText("Main"));
    ViewInteraction aboutPageButton = onView(withText("About"));

    public void goToNewsPage() {
        Allure.step("Переход на страницу Новости");
        burgerButton.check(matches(isDisplayed()));
        burgerButton.perform(click());

        newsPageButton.check(matches(isDisplayed()));
        newsPageButton.perform(click());
    }

    public void goToAboutPage() {
        Allure.step("Переход на страницу О приложении");
        burgerButton.check(matches(isDisplayed()));
        burgerButton.perform(click());

        aboutPageButton.check(matches(isDisplayed()));
        aboutPageButton.perform(click());
    }

    public void goToMainPage() {
        Allure.step("Переход на Главную страницу");
        burgerButton.check(matches(isDisplayed()));
        burgerButton.perform(click());

        mainPageButton.check(matches(isDisplayed()));
        mainPageButton.perform(click());
    }

    @Step(value = "Проверка видимости меню Бургер")
    public boolean burgerButtonVisible(){
        Allure.step("Проверка видимости меню Бургер");
        try {
            burgerButton.check(matches(isDisplayed()));
            return true;
        } catch (AssertionFailedError e) {
            return false;
        }
    }
}
