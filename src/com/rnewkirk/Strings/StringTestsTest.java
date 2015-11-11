package com.rnewkirk.Strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringTestsTest {

    @Test
    public void testIsUniqueIterate() throws Exception {
        assertEquals(StringTests.isUniqueIterate("SuperDuper"), false);
        assertEquals(StringTests.isUniqueIterate("Mike"), true);
    }

    @Test
    public void testIsUniqueSort() throws Exception {
        assertEquals(StringTests.isUniqueSort("SuperDuper"), false);
        assertEquals(StringTests.isUniqueSort("Mike"), true);
    }


    @Test
    public void testIsPermutationSort() throws Exception {
        assertTrue(StringTests.isPermutationSort("Hello", "olleH"));
        assertFalse(StringTests.isPermutationSort("Cow", "Work"));
    }

    @Test
    public void testIsPermutationBytes() throws Exception {
        assertTrue(StringTests.isPermutationBytes("Hello", "olleH"));
        assertFalse(StringTests.isPermutationBytes("Cow", "Work"));
    }

    @Test
    public void testEscapeSpaces() throws Exception {
        assertEquals(StringTests.escapeSpaces("Hello World"), "Hello%20World");
        assertEquals(StringTests.escapeSpaces("This is good "), "This%20is%20good%20");
    }

    @Test
    public void testCompress() throws Exception {
        assertEquals(StringTests.compress("tasdkjhtasdlkds"), "tasdkjhtasdlkds");
        assertEquals(StringTests.compress("aabcccccaaa"), "a2b1c5a3");
    }
}