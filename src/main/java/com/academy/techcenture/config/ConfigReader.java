package com.academy.techcenture.config;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

public class ConfigReader {

    private static Properties properties;

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    private ConfigReader(){}

    static{
        try {
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

        }catch (Exception e) {
            System.out.println("something happend!!!!");
                e.printStackTrace();

        }
    }

    public static String getProperty(String keyName){
        return properties.getProperty(keyName);
    }

    public static void setProperty(String key, String value) throws IOException {
        properties.store(new FileOutputStream(CONFIG_FILE_PATH), null);
        properties.setProperty(key, value);
    }




}
