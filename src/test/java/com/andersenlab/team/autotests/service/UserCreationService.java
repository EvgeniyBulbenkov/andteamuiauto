package com.andersenlab.team.autotests.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class UserCreationService {
    static Logger log = LogManager.getRootLogger();
    private static final Properties props = new Properties();
    private static FileInputStream fis;
    private static String fileLocation = "src/test/resources/creds.properties";

    public static String userName;
    public static String userPassword;

    static {

        try (final FileInputStream fis = new FileInputStream(fileLocation)) {
            props.load(fis);
            log.info("File " + fileLocation + " successfully loaded");

        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        userName = props.getProperty("username");
        userPassword = props.getProperty("password");
    }

}
