package org.aspectj.apache.bcel.verifier;

/**
 * A VerificationResult is what a PassVerifier returns
 * after verifying.
 *
 * @version $Id: VerificationResult.java,v 1.2 2004/11/19 16:45:19 aclement Exp $
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 *
 */
public class VerificationResult {

    /**
	 * Constant to indicate verification has not been tried yet.
	 * This happens if some earlier verification pass did not return VERIFIED_OK.
	 */
    public static final int VERIFIED_NOTYET = 0;

    /** Constant to indicate verification was passed. */
    public static final int VERIFIED_OK = 1;

    /** Constant to indicate verfication failed. */
    public static final int VERIFIED_REJECTED = 2;

    /**
	 * This string is the canonical message for verifications that have not been tried yet.
	 * This happens if some earlier verification pass did not return VERIFIED_OK.
	 */
    private static final String VERIFIED_NOTYET_MSG = "Not yet verified.";

    /** This string is the canonical message for passed verification passes. */
    private static final String VERIFIED_OK_MSG = "Passed verification.";

    /**
	 * Canonical VerificationResult for not-yet-tried verifications.
	 * This happens if some earlier verification pass did not return VERIFIED_OK.
	 */
    public static final VerificationResult VR_NOTYET = new VerificationResult(VERIFIED_NOTYET, VERIFIED_NOTYET_MSG);

    /** Canonical VerificationResult for passed verifications. */
    public static final VerificationResult VR_OK = new VerificationResult(VERIFIED_OK, VERIFIED_OK_MSG);

    /** The numeric status. */
    private int numeric;

    /** The detailed message. */
    private String detailMessage;

    /** The usual constructor. */
    public  VerificationResult(int status, String message) {
        numeric = status;
        detailMessage = message;
    }

    /** Returns one one the VERIFIED_OK, VERIFIED_NOTYET, VERIFIED_REJECTED constants. */
    public int getStatus() {
        return numeric;
    }

    /** Returns a detailed message. */
    public String getMessage() {
        return detailMessage;
    }

    /**
	 * Returns if two VerificationResult instances are equal.
	 */
    public boolean equals(Object o) {
        if (!(o instanceof VerificationResult))
            return false;
        VerificationResult other = (VerificationResult) o;
        return ((other.numeric == this.numeric) && (other.detailMessage.equals(this.detailMessage)));
    }

    /**
	 * Returns a String representation of the VerificationResult.
	 */
    public String toString() {
        String ret = "";
        if (numeric == VERIFIED_NOTYET)
            ret = "VERIFIED_NOTYET";
        if (numeric == VERIFIED_OK)
            ret = "VERIFIED_OK";
        if (numeric == VERIFIED_REJECTED)
            ret = "VERIFIED_REJECTED";
        ret += "\n" + detailMessage + "\n";
        return ret;
    }
}
