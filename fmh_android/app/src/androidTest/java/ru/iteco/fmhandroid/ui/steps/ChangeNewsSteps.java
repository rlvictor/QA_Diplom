package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utills.TestHelper.waitDisplayed;

import android.view.View;
import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utills.TestHelper;

public class ChangeNewsSteps {
    ViewInteraction addNewsTitle = onView(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news));
    ViewInteraction categoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    ViewInteraction titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
    ViewInteraction dateText = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    ViewInteraction timeText = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    ViewInteraction descriptionText = onView(
            allOf(isDescendantOfA(withId(R.id.news_item_description_text_input_layout)),
                    isAssignableFrom(EditText.class)));
    ViewInteraction addNewsButton = onView(withId(R.id.save_button));

    ViewInteraction okDeleteNews = onView(withId(android.R.id.button1));

    static ViewInteraction newsRecyclerList = onView(withId(R.id.news_list_recycler_view));


    public void pageLoad() {
        Allure.step("Проверка что страница редактора новости видна на экране");
        addNewsTitle.check(matches(isDisplayed()));
        categoryText.check(matches(isDisplayed()));
        titleText.check(matches(isDisplayed()));
        dateText.check(matches(isDisplayed()));
        timeText.check(matches(isDisplayed()));
        descriptionText.check(matches(isDisplayed()));
        addNewsButton.check(matches(isDisplayed()));
    }

    public void waitPageLoad() {
        Allure.step("Ожидание загрузки страницы редактора");
        onView(isRoot()).perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_create_edit_news, 8000));
    }

    public void getCategory(String category) {
        Allure.step("Ввод категории новости");
        categoryText.perform(replaceText(category), closeSoftKeyboard());
    }

    public void getTitle(String title) {
        Allure.step("Ввод Заголовка новости");
        titleText.perform(replaceText(title), closeSoftKeyboard());
    }

    public void getDate() {
        Allure.step("Ввод даты новости");
        dateText.perform(click());
        pressOK();
    }

    public void getTime() {
        Allure.step("Ввод времени новости");
        timeText.perform(click());
        pressOK();
    }

    public void getDescription(String description) {
        Allure.step("Ввод описания новости");
        descriptionText.perform(replaceText(description), closeSoftKeyboard());
    }

    public void addNews() {
        Allure.step("Клик по кнопке добавить новость");
        addNewsButton.perform(click());
    }

    private void pressOK() {

        onView(isRoot()).perform(waitDisplayed(android.R.id.button1, 8000));
        onView(withId(android.R.id.button1))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_publish_time_text_input_edit_text, 8000));
    }

    public void okDelNews() {
        Allure.step("Клик по кнопке OK удалить новость. Новость удаляется.");
        okDeleteNews.perform(click());
    }

    public static Matcher<View> ButtonAgreement() {
        return allOf(withId(android.R.id.button1));
    }

    public void clickDeleteNewsButton(int id) {
        Allure.step("Нажатие кнопки удалить Новость");
        ChangeNewsSteps.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        id, TestHelper.clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(ChangeNewsSteps.ButtonAgreement()).perform(click());
    }

    public void clickEditNewsButton(int id) {
        Allure.step("Нажатие кнопки редактировать новость");
        ChangeNewsSteps.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        id, TestHelper.clickChildViewWithId(R.id.edit_news_item_image_view)));
    }
}
