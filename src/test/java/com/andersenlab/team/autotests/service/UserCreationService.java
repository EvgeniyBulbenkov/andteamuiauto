package com.andersenlab.team.autotests.service;

import com.andersenlab.team.autotests.model.TeamUser;

public class UserCreationService {
    public static final String TEST_USER_NAME = "";
    public static final String TEST_USER_PASSWORD = "";

    public static TeamUser userWithValidCredentials() {
        return new TeamUser(TEST_USER_NAME, TEST_USER_PASSWORD);
    }

    public static TeamUser userWithoutPassword() {
        return new TeamUser(TEST_USER_NAME, "");
    }

    public static TeamUser userWithoutName() {
        return new TeamUser("", "TEST_USER_PASSWORD");
    }
}
