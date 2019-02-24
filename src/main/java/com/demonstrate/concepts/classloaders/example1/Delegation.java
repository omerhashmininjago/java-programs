package com.demonstrate.concepts.classloaders.example1;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Demonstrating class loader hierarchy
 */
public class Delegation {

    public static void main(String[] args) {
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        do {
            System.out.println(urlClassLoader);
            for( URL url : urlClassLoader.getURLs()) {
                System.out.println(url.getPath());
            }
        } while((urlClassLoader = (URLClassLoader)urlClassLoader.getParent()) != null);
        System.out.println("Bootstarp Classloader");
    }

}
