package ru.iteco.fmhandroid.ui.utills;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utills.TestHelper.waitDisplayed;

import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AuthorizationHelper {

    ViewInteraction getLoginText =
            onView(allOf(isDescendantOfA(withId(R.id.login_text_input_layout)),
                    isAssignableFrom(EditText.class)));

    ViewInteraction getPasswordText =
            onView(allOf(isDescendantOfA(withId(R.id.password_text_input_layout)),
                            isAssignableFrom(EditText.class)));

    ViewInteraction enterButton = onView(withId(R.id.enter_button));

    public ViewInteraction button = onView(withId(R.id.authorization_image_button));

    public ViewInteraction logOutButton = onView(withText("Log out"));


    public void pageLoad() {
        Allure.step("Страница Авторизации на экране");
        getLoginText.check(matches(isDisplayed()));
        getPasswordText.check(matches(isDisplayed()));
        enterButton.check(matches(isDisplayed()));
    }

    public void pageNotLoad(String text) {
        Allure.step("Страница авторизации снова на экране");
        onView(allOf(withContentDescription(text), isDisplayed()));
    }


    public void enterLogin(String login) {
        Allure.step("Ввод логина");
        getLoginText.perform(replaceText(login), closeSoftKeyboard());
    }

    public void enterPassword(String password) {
        Allure.step("Ввод пароля");
        getPasswordText.perform(replaceText(password), closeSoftKeyboard());
    }

    public void clicked() {
        Allure.step("Клик по кнопке Авторизация");
        enterButton.perform(click());
    }

    public void waitingLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 8000));
    }

    public void authEx(){
        button.check(matches(isDisplayed()));
        button.perform(click());
        logOutButton.check(matches(isDisplayed()));
        logOutButton.perform(click());
    }
}
