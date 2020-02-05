public class TryNoCatchCE {

    /* @testcase PR#643 PUREJAVA try without catch or finally */
    public void notRun() {
        // expect CE here
        try {
        }
    }
}
