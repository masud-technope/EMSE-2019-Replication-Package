import java.io.Serializable;
import java.io.IOException;

public class AppleCrate implements Serializable {

    Apple[] crateContents = null;

    /**
	 * Default constructor.
	 * 
	 * @param	newCrateContents	an array of <CODE>Apple</CODE> objects
	 */
    public  AppleCrate(Apple[] newCrateContents) {
        crateContents = newCrateContents;
    }

    /**
	 * A crate is sellable if the apples are bruised 50% or less on average.
	 * 
	 * @return	<CODE>true</CODE> if the the apples can be sold
	 */
    public boolean isSellable() {
        int bruising = 0;
        for (int i = 0; i < crateContents.length; i++) {
            bruising = bruising + crateContents[i].getBruising();
        }
        if ((bruising / crateContents.length) > 50) {
            return false;
        } else {
            return true;
        }
    }
}
