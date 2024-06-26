package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.utills.AuthorizationHelper;
import ru.iteco.fmhandroid.ui.utills.Data;
import ru.iteco.fmhandroid.ui.utills.TestHelper;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Вход в личный кабинет. Авторизация.")

public class TestAuthorization extends TestHelper {
    AuthorizationHelper authorizationHelper = new AuthorizationHelper();


    @Story(value = "Ввод валидных значений и выход из приложения")
    @Test

    public void validLoginTest() {
        AuthorizationSteps.logIn();
        AuthorizationSteps.logOut();
    }

    @Story(value = "Вход с неверным паролем")
    @Test

    public void invalidPassword() {
        try {
            AuthorizationSteps.notValidLogin(Data.validLogin, Data.notValidPassword);
            authorizationHelper.waitingLoad();
            authorizationHelper.pageNotLoad("Something went wrong. Try again later.");
        }catch (Exception e){
            authorizationHelper.authEx();
        }
    }

    @Story(value = "Вход с неверным Логином и Паролем")
    @Test

    public void invalidLoginAndPassword() {
        try {
            AuthorizationSteps.notValidLogin(Data.notValidLogin, Data.notValidPassword);
            authorizationHelper.waitingLoad();
            authorizationHelper.pageNotLoad("Something went wrong. Try again later.");
        } catch (Exception e) {
            authorizationHelper.authEx();
        }
    }

    @Story(value = "Вход с пустым Логином и Паролем")
    @Test

    public void EmptyLoginAndPassword() {
        try {
            AuthorizationSteps.notValidLogin(Data.empty, Data.empty);
            authorizationHelper.waitingLoad();
            authorizationHelper.pageNotLoad("Login and password cannot be empty");
        } catch (Exception e) {
            authorizationHelper.authEx();
        }
    }
}



