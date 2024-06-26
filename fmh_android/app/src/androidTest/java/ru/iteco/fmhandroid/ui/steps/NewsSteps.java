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

public class NewsSteps {
    ViewInteraction news = onView(withId(R.id.container_list_news_include));
    ViewInteraction button = onView(withId(R.id.edit_news_material_button));

    public void pageNewsLoad() {
        Allure.step("Проверка видна ли панель Новости на экране");
        news.check(matches(isDisplayed()));
        button.check(matches(isDisplayed()));
    }

    public void waitPageNewsLoad() {
        Allure.step("Ожидание загрузки страницы Новости");
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include, 8000));
    }

    public void controlPanel() {
        Allure.step("Нажатие кнопки редактора новостей");
        button.perform(click());
    }
}
