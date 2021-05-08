package com.company;

import lab4.test.TestByConsol;
import lab4.test.TestFile;
import lab4.test.TestStoreObject;
import lab4.test.testApp;

public class Main {
    public static void main(String[] args) throws Exception {
        testApp app = new testApp();
        app.startApp();
        TestByConsol testConsole = new TestByConsol();
        testConsole.startAppConsole();
        TestFile.main();
        TestStoreObject storeObject = new TestStoreObject();
        storeObject.main();
    }
}
