package ru.iteco.fmhandroid.ui.utills;

import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.logIn;

import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationSteps;

public class MainHelper {
    public static void goToMainPage() {
        MainSteps mainSteps = new MainSteps();
        try {
            mainSteps.waitMainPageLoad();
            mainSteps.mainPageLoad();
        } catch (Exception e) {
            NavigationSteps navigationSteps = new NavigationSteps();
            if (navigationSteps.burgerButtonVisible()) {
                navigationSteps.goToMainPage();
            } else {
                logIn();
            }
        }
    }
}
