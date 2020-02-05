package com.company.app;

import java.util.Arrays;
import org.aspectj.lang.SoftException;

public class Main implements Runnable {

    public static void main(String[] argList) {
        new Main().runMain(argList);
    }

    String[] input;

    void spawn() {
        // KEEP CE 15 declares-factory
        new Thread(this, toString()).start();
    }

    public void runMain(String[] argList) {
        this.input = argList;
        run();
    }

    public void run() {
        String[] input = this.input;
        String s = ((null == input) || (0 == input.length)) ? "[]" : Arrays.asList(input).toString();
        System.out.println("input: " + s);
        try {
            // KEEP CW 30 declares-exceptionSpelunking
            doDangerousThings();
        } catch (AppException // KEEP CW 31 declares-exceptionSpelunking
        e) {
            e.printStackTrace(System.err);
        }
    }

    private void doDangerousThings() throws AppException {
    // KEEP CW 38
    }
}
