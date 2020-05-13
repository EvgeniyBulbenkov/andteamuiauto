package com.andersenlab.team.autotests.pageobjects.andtm.teammainpage;

import com.andersenlab.team.autotests.pageobjects.BasePage;

public class TeamMainPage extends BasePage {
    private String pageTitle = "Andersen Team";

    @Override
    public String getPageTitle() {
        return pageTitle;
    }
}
