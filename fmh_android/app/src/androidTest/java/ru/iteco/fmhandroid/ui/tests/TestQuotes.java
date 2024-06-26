package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.utills.MainHelper.goToMainPage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;
import ru.iteco.fmhandroid.ui.utills.TestHelper;


@Feature("Переход на страницу Цитаты")
@RunWith(AllureAndroidJUnit4.class)

public class TestQuotes extends TestHelper {
    MainSteps mainSteps = new MainSteps();
    QuotesSteps quotesSteps = new QuotesSteps();

    @Description("Загрузка главной страницы")
    @Before
    public void login() {
        goToMainPage();
    }

    @Story("Переход с Главной страницы на страницу Цитаты")
    @Test

    public void goToQuotesFromMain() {
        mainSteps.goToQuotesPage();
        quotesSteps.waitQuotesPageLoad();
        quotesSteps.quotesPageLoad();
    }
}