package ru.iteco.fmhandroid.ui.steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.utills.TestHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class QuotesSteps {
    ViewInteraction quotesItemList = onView(withId(R.id.our_mission_item_list_recycler_view));

    public void quotesPageLoad() {
        Allure.step("Проверка что Цитаты отображаются на экране");
        quotesItemList.check(matches(isDisplayed()));
    }

    public void waitQuotesPageLoad() {
        Allure.step("Ожидание загрузки страницы с Цитатами");
        onView(isRoot()).perform(waitDisplayed(R.id.our_mission_item_list_recycler_view, 8000));
    }

}
