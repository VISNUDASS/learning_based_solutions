public class AssertionsTest {
    public void testAssertions() {
        assertEquals(5, 2 + 3);              
        assertTrue(5 > 3);                   
        assertTrue(5 < 3);                  
        assertNull(null);            
        assertNull(new Object());        
    }
    private void assertNull(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'assertNull'");
    }
    private void assertTrue(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
    private void assertEquals(int i, int j) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}
