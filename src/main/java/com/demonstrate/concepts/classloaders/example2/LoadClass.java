package com.demonstrate.concepts.classloaders.example2;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Different ways to load a class
 *
 * This class will throw runtime exception as path to jar and entire package paths are garbage values
 */
public class LoadClass {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        URL url = new URL("path to jar file");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});

        // first way to load a class
        Class clazz = urlClassLoader.loadClass("full package path to class");
        //Other way of loading a class is as below
        // here to give two additional parameters
        // its an instantiation flag
        // You can tell which classloader should be used to load the class
        // in this example we have a single class loader defined, we can have many more
        Class clazz1 = Class.forName("full package path to class", true, urlClassLoader);
        //You cannot directly use reference of the Class
        //If you are using it, then in would be loaded from the application Class loader and not form the above classloader
        Object object = clazz.newInstance();
        System.out.println(object.toString());
    }

}
