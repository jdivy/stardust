package org.stardust.math;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: evadrone
 * Date: 8/17/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModularArithmeticTest {

    @Test
    public void testIsCongruent() {
        Assert.assertTrue(ModularArithmetic.isCongruent(-9, 14, 23));
        Assert.assertTrue(ModularArithmetic.isCongruent(14, -9, 23));
    }

    @Test
    public void testGcd() {
        Assert.assertEquals(12, ModularArithmetic.gcd(48, 180));
        Assert.assertEquals(12, ModularArithmetic.gcd(180, 48));
    }

    @Test
    public void testAdd() {
        int q = 7;
        for (int x = 0; x < q; ++x) {
            for (int y = 0; y < q; ++y) {
                int result = ModularArithmetic.add(x, y, q);
                if (x + y < q)
                    Assert.assertEquals(x + y, result);
                else
                    Assert.assertEquals(x + y - q, result);
            }
        }
    }

    @Test
    public void testSubtract() {
        int q = 7;
        for (int x = 0; x < q; ++x) {
            for (int y = 0; y < q; ++y) {
                int result = ModularArithmetic.subtract(x, y, q);
                if (x - y >= 0)
                    Assert.assertEquals(x - y, result);
                else
                    Assert.assertEquals(x - y + q, result);
            }
        }
    }

    @Test
    public void testMultiply() {
        int q = 7;
        for (int x = 0; x < q; ++x) {
            for (int y = 0; y < q; ++y) {
                int result = ModularArithmetic.multiply(x, y, q);
                Assert.assertEquals((x * y) % q, result);
            }
        }
    }

    @Test
    public void testInverse() {
        Assert.assertTrue(ModularArithmetic.isCongruent(47, ModularArithmetic.inverse(23, 120), 120));
        Assert.assertTrue(ModularArithmetic.isCongruent(-9, ModularArithmetic.inverse(5, 23), 23));
        Assert.assertTrue(ModularArithmetic.isCongruent(14, ModularArithmetic.inverse(5, 23), 23));
    }

    @Test
    public void testExtendedEuclidean() {
        Assert.assertEquals(-9, ModularArithmetic.extendedGcd(120, 23));
        Assert.assertEquals(47, ModularArithmetic.extendedGcd(23, 120));
    }
}
