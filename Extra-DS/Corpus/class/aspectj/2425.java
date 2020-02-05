package ca.ubc.cs.spl.aspectPatterns.examples.proxy.aspectj;

public class Main {

    public  Main() {
        /**
	     * The <i>RealSubject</i> that the client sends all requests to
	     */
        OutputImplementation real = new OutputImplementation();
        System.out.println("\n===> Issuing SAFE request...");
        real.safeRequest("Safe Reqeust");
        System.out.println("\n===> Issuing REGULAR request...");
        real.regularRequest("Normal Request");
        System.out.println("\n===> Issuing UNSAFE request...");
        real.unsafeRequest("Unsafe Request");
        System.out.println("\n===> Issuing SAFE request...");
        real.safeRequest("Safe Reqeust");
        System.out.println("\n===> Issuing REGULAR request...");
        real.regularRequest("Normal Request");
        System.out.println("\n===> Issuing UNSAFE request...");
        real.unsafeRequest("Unsafe Request");
    }

    /** 
     * Implements the driver for the proxy design pattern example.
	 */
    public static void main(String[] args) {
        Main main = new Main();
    }
}
