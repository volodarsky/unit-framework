package org.units;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author vladimir.romanov
 * @version 1.0
 * @since UP...
 */
public class PositionTest extends TestCase {

    @Test
    public void testComparable(){

        assert  Position.of(0,0).compareTo(Position.of(0, 0)) == 0;
        assert  Position.of(0,0).compareTo(Position.of(1, 0)) < 0;
        assert  Position.of(0,0).compareTo(Position.of(0, 1)) > 0;
        assert  Position.of(2,3).compareTo(Position.of(1, 4)) > 0;
        assert  Position.of(2,3).compareTo(Position.of(2, 4)) > 0;

    }

}