package random.tests;

import static org.junit.jupiter.api.Assertions.*;

class RNGTesterTest {

    @org.junit.jupiter.api.Test
    void runFrequencyTest() {
        assertEquals(RNGTester.runFrequencyTest("1011010101"), 0.527089, 0.0001);
    }

    @org.junit.jupiter.api.Test
    void runFrequencyBlockTest() {
        assertEquals(0.801252, RNGTester.runFrequencyBlockTest("0110011010", 3) , 0.0001);
        assertEquals(0.706438, RNGTester.runFrequencyBlockTest("1100100100001111110110101010001000100001011010001100001000110100110001001100011001100010100010111000", 10) , 0.01);
    }

    @org.junit.jupiter.api.Test
    void runRunsTest() {
        assertEquals(0.147232, RNGTester.runRunsTest("1001101011") , 0.0001);
        assertEquals(0.500798, RNGTester.runRunsTest("1100100100001111110110101010001000100001011010001100001000110100110001001100011001100010100010111000") , 0.0001);
    }
}