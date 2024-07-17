package com.bhanit.learnonex.splash;

public class Test { // this class is singleton
    static String c = null;
    private static Test objectText;
    final String a = "ab";
    String b = "ab";

    static Test methodName() {
        if (objectText == null) {
            objectText = new Test();
        }
        return objectText;
    }

    public static String getCValue() {
        return c;
    }

    // Singleton class is used to create an object only once;

}
