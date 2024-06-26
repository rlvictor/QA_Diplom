package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.utills.Data.category;
import static ru.iteco.fmhandroid.ui.utills.Data.description;
import static ru.iteco.fmhandroid.ui.utills.Data.newTittle;
import static ru.iteco.fmhandroid.ui.utills.Data.tittle;
import static ru.iteco.fmhandroid.ui.utills.MainHelper.goToMainPage;

import androidx.test.espresso.ViewInteraction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.steps.ChangeNewsSteps;
import ru.iteco.fmhandroid.ui.steps.ControlSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.utills.TestHelper;

@RunWith(AllureAndroidJUnit4.class)
@Feature("Страница Новости")

public class TestNews extends TestHelper {
    NavigationSteps navigationSteps = new NavigationSteps();
    NewsSteps newsSteps = new NewsSteps();
    ControlSteps controlSteps = new ControlSteps();
    ChangeNewsSteps changeNewsSteps = new ChangeNewsSteps();
    MainSteps mainSteps = new MainSteps();


    @Description("Загрузка главной страницы")
    @Before
    public void login() {
        goToMainPage();
    }

    @Story("Переход с Главной страницы на страницу Новостей")
    @Test

    public void goToNewsPage() {
        navigationSteps.goToNewsPage();
        newsSteps.waitPageNewsLoad();
        newsSteps.pageNewsLoad();
    }

    @Story("Добавление новой новости")
    @Test

    public void addNewNews() {
        navigationSteps.goToNewsPage();
        newsSteps.waitPageNewsLoad();
        newsSteps.pageNewsLoad();
        newsSteps.controlPanel();
        controlSteps.waitPageLoad();
        controlSteps.pageLoad();
        controlSteps.addNews();
        changeNewsSteps.waitPageLoad();
        changeNewsSteps.pageLoad();
        changeNewsSteps.getCategory(category);
        changeNewsSteps.getTitle(controlSteps.randomTittle);
        changeNewsSteps.getDate();
        changeNewsSteps.getTime();
        changeNewsSteps.getDescription(description);
        changeNewsSteps.addNews();
        controlSteps.waitPageLoad();
        navigationSteps.goToNewsPage();
        controlSteps.checkNewTittle();
    }

    @Story("Редактирование новости")
    @Test

    public void changeNews(){
        navigationSteps.goToNewsPage();
        newsSteps.waitPageNewsLoad();
        newsSteps.pageNewsLoad();
        newsSteps.controlPanel();
        controlSteps.waitPageLoad();
        controlSteps.pageLoad();
        changeNewsSteps.clickEditNewsButton(0);
        changeNewsSteps.waitPageLoad();
        changeNewsSteps.pageLoad();
        changeNewsSteps.getTitle(controlSteps.newRandomTittle);
        changeNewsSteps.addNews();
        controlSteps.waitPageLoad();
        navigationSteps.goToNewsPage();
        controlSteps.checkChangeTittle();
    }

    @Story("Удаление новости")
    @Test

    public void deleteNews(){
        navigationSteps.goToNewsPage();
        newsSteps.waitPageNewsLoad();
        newsSteps.pageNewsLoad();
        newsSteps.controlPanel();
        controlSteps.waitPageLoad();
        controlSteps.pageLoad();
        changeNewsSteps.clickDeleteNewsButton(0);
        changeNewsSteps.okDelNews();
        controlSteps.waitPageLoad();
        navigationSteps.goToNewsPage();
    }

    @Story("Переход на страницу Новости по кнопке Все новости")
    @Test

    public void goToNewsPageByAllNews() {
        mainSteps.goToAllNewsButton();
        newsSteps.waitPageNewsLoad();
        newsSteps.pageNewsLoad();
    }

}