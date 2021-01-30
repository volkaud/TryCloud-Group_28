package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties1 = new Properties();

    //we've created a Properties class obj so we can use it to access  a ".properties" file
    static { // we only want it to run once, instantiate the properties1 obj one time

        try { //we are using this "try catch"  block in case the path is wrong java will catch it in runtime
            FileInputStream file = new FileInputStream("Configuration.properties"); // in the constructor we assigned a path
            properties1.load(file); //we call the Properties obj and use instance method "load" to attach that file to the obj
            file.close(); // close method for memory saving
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // we are creating a method that is returning a value of the given key using the ".getProperty()"
    public static String getKeyValue(String keyName) {

        return properties1.getProperty(keyName);

    }


}
