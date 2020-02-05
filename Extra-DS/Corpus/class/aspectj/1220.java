package ca.ubc.cs.spl.aspectPatterns.examples.proxy.java;

public class Main {

    /**
     * Implements the driver for the proxy design pattern. <p>
     */
    public static void main(String[] args) {
        OutputSubject real = new OutputImplementation();
        OutputSubject countingProxy = new RequestCounter(real);
        OutputSubject blockingProxy = new RequestBlocker(countingProxy);
        System.out.println("\n===> Issuing SAFE request...");
        blockingProxy.safeRequest("Safe Reqeust");
        System.out.println("\n===> Issuing REGULAR request...");
        blockingProxy.regularRequest("Normal Request");
        System.out.println("\n===> Issuing UNSAFE request...");
        blockingProxy.unsafeRequest("Unsafe Request");
        System.out.println("\n===> Issuing SAFE request...");
        blockingProxy.safeRequest("Safe Reqeust");
        System.out.println("\n===> Issuing REGULAR request...");
        blockingProxy.regularRequest("Normal Request");
        System.out.println("\n===> Issuing UNSAFE request...");
        blockingProxy.unsafeRequest("Unsafe Request");
    }
}
