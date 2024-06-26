package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utills.AuthorizationHelper;
import ru.iteco.fmhandroid.ui.utills.Data;

public class AuthorizationSteps {
    static AuthorizationHelper authorizationHelper = new AuthorizationHelper();

    @Description (value = "Вход в приложение")
    public static void logIn() {
            authorizationHelper.waitingLoad();
            authorizationHelper.pageLoad();
            authorizationHelper.enterLogin(Data.validLogin);
            authorizationHelper.enterPassword(Data.validPassword);
            authorizationHelper.clicked();
            MainSteps mainSteps = new MainSteps();
            mainSteps.waitMainPageLoad();
            mainSteps.mainPageLoad();
    }

    @Description (value = "Выход из приложения")
    public static void logOut() {
        try {
            authorizationHelper.waitingLoad();
            authorizationHelper.pageLoad();
        } catch (Exception e) {
            ViewInteraction button = onView(withId(R.id.authorization_image_button));
            Allure.step("Проверка что иконка Авторизации присутствует на экране");
            button.check(matches(isDisplayed()));
            Allure.step("Клик по иконке Авторизации");
            button.perform(click());
            ViewInteraction logOutButton = onView(withText("Log out"));
            Allure.step("Проверка что кнопка Выход присутствует на экране");
            logOutButton.check(matches(isDisplayed()));
            Allure.step("Клик по кнопке Выход");
            logOutButton.perform(click());
            authorizationHelper.pageLoad();
        }
    }


    public static void notValidLogin(String login, String password) {
        authorizationHelper.waitingLoad();
        authorizationHelper.pageLoad();
        authorizationHelper.enterLogin(login);
        authorizationHelper.enterPassword(password);
        authorizationHelper.clicked();
    }
}
