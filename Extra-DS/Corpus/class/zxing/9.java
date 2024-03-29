/*
 * Copyright (C) 2010 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.zxing.oned.rss.expanded;

import java.util.Vector;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.DataCharacter;
import junit.framework.TestCase;

/**
 * @author Pablo Orduña, University of Deusto (pablo.orduna@deusto.es)
 * @author Eduardo Castillejo, University of Deusto (eduardo.castillejo@deusto.es)
 */
public final class BitArrayBuilderTest extends TestCase {

    public void testBuildBitArray1() {
        int[][] pairValues = { { 19 }, { 673, 16 } };
        String expected = " .......X ..XX..X. X.X....X .......X ....";
        checkBinary(pairValues, expected);
    }

    private void checkBinary(int[][] pairValues, String expected) {
        BitArray binary = buildBitArray(pairValues);
        assertEquals(expected, binary.toString());
    }

    private static BitArray buildBitArray(int[][] pairValues) {
        Vector pairs = new Vector();
        for (int i = 0; i < pairValues.length; ++i) {
            int[] pair = pairValues[i];
            DataCharacter leftChar;
            if (i == 0) {
                leftChar = null;
            } else {
                leftChar = new DataCharacter(pair[0], 0);
            }
            DataCharacter rightChar;
            if (i == 0) {
                rightChar = new DataCharacter(pair[0], 0);
            } else if (pair.length == 2) {
                rightChar = new DataCharacter(pair[1], 0);
            } else {
                rightChar = null;
            }
            ExpandedPair expandedPair = new ExpandedPair(leftChar, rightChar, null, true);
            pairs.add(expandedPair);
        }
        BitArray binary = BitArrayBuilder.buildBitArray(pairs);
        return binary;
    }
}
