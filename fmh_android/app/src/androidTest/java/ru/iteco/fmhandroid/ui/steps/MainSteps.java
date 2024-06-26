package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.utills.TestHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class MainSteps {
    ViewInteraction newsTitle = onView(withId(R.id.container_list_news_include_on_fragment_main));
    ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
    ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));

    public void mainPageLoad() {
        Allure.step("Главная страница на экране");
        newsTitle.check(matches(isDisplayed()));
        quotesButton.check(matches(isDisplayed()));
        allNewsButton.check(matches(isDisplayed()));
    }

    public void waitMainPageLoad() {
        Allure.step("Ожидание загрузки Главной страницы");
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 8000));
    }

    public void goToQuotesPage() {
        Allure.step("Клик по кнопке Цитаты");
        quotesButton.perform(click());
    }

    public void goToAllNewsButton() {
        Allure.step("Клик по кнопке Все новости");
        allNewsButton.perform(click());
    }
}
