public class MathUtilTest {
    MathUtil util = new MathUtil();

    public void testSquare() {
        assertEquals(25, util.square(5));
    }

    private void assertEquals(int i, int square) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
    public void testIsEvenTrue() {
        assertTrue(util.isEven(4));
    }

    private void assertTrue(boolean even) {
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
    public void testIsEvenFalse() {
        assertTrue(util.isEven(5));
    }
    public void testMax() {
        assertEquals(10, util.max(10, 7));
    }
}

