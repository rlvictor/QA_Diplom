package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utills.TestHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AboutSteps {
    NavigationSteps navigationSteps = new NavigationSteps();
    ViewInteraction versionTitle = onView(withId(R.id.about_version_title_text_view));
    ViewInteraction privacyTitle = onView(withId(R.id.about_privacy_policy_label_text_view));
    ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    ViewInteraction termsOfUseTitle = onView(withId(R.id.about_terms_of_use_label_text_view));
    ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
    ViewInteraction policyText = onView(withText("Политика конфидециальности"));
    ViewInteraction termsText = onView(withText("Пользовательское соглашение"));

//    public void goToPageAbout(){
//        Allure.step("Переход на страницу О приложении");
//        navigationSteps.goToAboutPage();
//    }

    public void waitPageAboutLoad() {
        Allure.step("Ожидание загрузки страницы О приложении");
        onView(isRoot()).perform(waitDisplayed(R.id.about_version_title_text_view, 8000));
    }

    public void versionTitleDisplayed() {
        Allure.step("Проверка что версия отображается на экране");
        versionTitle.check(matches(isDisplayed()));
    }

    public void privacyTitleDisplayed() {
        Allure.step("Проверка что заголовок Политики конфиднциальности отображается на экране");
        privacyTitle.check(matches(isDisplayed()));
    }

    public void termsTitleDisplayed() {
        Allure.step("Проверка что заголовок Пользовательского соглашения отображается на экране");
        termsOfUseTitle.check(matches(isDisplayed()));
    }

    public void privacyPolicyLinkClick(){
        Allure.step("Клик по ссылке Политики конфиденциальности");
        privacyPolicyLink.perform(click());
    }

    public void checkPolicyText(){
        Allure.step("Проверка что Политика конфиденциальности отображается на экране");
        policyText.check(matches(isDisplayed()));
    }

    public void termsOfUseLinkClick(){
        Allure.step("Клик по ссылке Пользовательского соглашения");
        termsOfUseLink.perform(click());
    }

    public void checkTermsText(){
        Allure.step("Проверка что Пользовательское соглашение отображается на экране");
        termsText.check(matches(isDisplayed()));
    }
}


