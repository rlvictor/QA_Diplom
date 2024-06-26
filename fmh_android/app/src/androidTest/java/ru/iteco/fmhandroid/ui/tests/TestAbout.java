package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.utills.MainHelper.goToMainPage;

import androidx.test.espresso.Espresso;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationSteps;
import ru.iteco.fmhandroid.ui.utills.TestHelper;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Переход на страницу О приложении")

public class TestAbout extends TestHelper {
    AboutSteps aboutSteps = new AboutSteps();
    NavigationSteps navigationSteps = new NavigationSteps();

    @Description("Загрузка главной страницы")
    @Before
    public void login() {
        goToMainPage();
    }

    @Story(value = "Переход с Главной  на страницу О приложении")
    @Test

    public void goToAboutFromMain() {
        navigationSteps.goToAboutPage();
        aboutSteps.waitPageAboutLoad();
        aboutSteps.versionTitleDisplayed();
        aboutSteps.privacyTitleDisplayed();
        aboutSteps.termsTitleDisplayed();
        Espresso.pressBack();
    }

    @Story(value = "Переход на страницу О приложении со страницы Новости")
    @Test

    public void goToAboutFromNews() {
        navigationSteps.goToNewsPage();
        navigationSteps.goToAboutPage();
        aboutSteps.waitPageAboutLoad();
        aboutSteps.versionTitleDisplayed();
        aboutSteps.privacyTitleDisplayed();
        aboutSteps.termsTitleDisplayed();
        Espresso.pressBack();
    }

    @Story("Переход по ссылке Политика конфиденциальности")
    @Test

    public void clickToLinkPrivatePolicy() {
        navigationSteps.goToAboutPage();
        aboutSteps.waitPageAboutLoad();
        aboutSteps.versionTitleDisplayed();
        aboutSteps.privacyTitleDisplayed();
        aboutSteps.termsTitleDisplayed();
        aboutSteps.privacyPolicyLinkClick();
        aboutSteps.checkPolicyText();
        Espresso.pressBack();

    }

    @Story("Переход по ссылке Пользовательское соглашение")
    @Test

    public void clickToLinkTermsOfUse() {
        navigationSteps.goToAboutPage();
        aboutSteps.waitPageAboutLoad();
        aboutSteps.versionTitleDisplayed();
        aboutSteps.privacyTitleDisplayed();
        aboutSteps.termsTitleDisplayed();
        aboutSteps.termsOfUseLinkClick();
        aboutSteps.checkTermsText();
        Espresso.pressBack();
    }
}