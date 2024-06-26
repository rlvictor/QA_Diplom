package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utills.Data.newTittle;
import static ru.iteco.fmhandroid.ui.utills.Data.tittle;
import static ru.iteco.fmhandroid.ui.utills.TestHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import java.util.Random;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ControlSteps {
    ViewInteraction addNews = onView(withId(R.id.add_news_image_view));
    ViewInteraction changeNews = onView(withId(R.id.edit_news_item_image_view));
    ViewInteraction deleteNews = onView(withId(R.id.delete_news_item_image_view));


    public void addNews() {
        Allure.step("Клик по кнопке добавить новость");
        addNews.perform(click());
    }

    public void editNews() {
        Allure.step("Клик по кнопке редактировать новость");
        changeNews.perform(click());
    }

    public void deleteNews() {
        Allure.step("Клик по кнопке удалить новость");
        deleteNews.perform(click());
    }

    public void pageLoad() {
        Allure.step("Проверка видна ли кнопка Добавить новость на экране");
        addNews.check(matches(isDisplayed()));
    }

    public void waitPageLoad() {
        Allure.step("Ожидание загрузки страницы редактрора новости");
        onView(isRoot()).perform(waitDisplayed(R.id.add_news_image_view, 12000));
    }

    public ViewInteraction findNewsByTitle(String title){
        return onView(withText(title));
    }

    int random = new Random().nextInt(1000) + 1;
    public String randomTittle = tittle + random;
    public String newRandomTittle = newTittle + random;

    public void checkNewTittle(){
        Allure.step("Поиск новой новости по заголовку в списке новостей");
        ViewInteraction findNews = findNewsByTitle(randomTittle);
        findNews.check(matches(isDisplayed()));
    }

    public void checkChangeTittle(){
        Allure.step("Поиск отредактированной новости по заголовку в списке новостей");
        ViewInteraction findChangeNews = findNewsByTitle(newRandomTittle);
        findChangeNews.check(matches(isDisplayed()));
    }
}
