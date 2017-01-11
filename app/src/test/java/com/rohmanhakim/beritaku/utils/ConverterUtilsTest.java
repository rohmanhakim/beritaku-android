package com.rohmanhakim.beritaku.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/8/17 11:54.
 */
public class ConverterUtilsTest {

    @Test
    public void shouldConvertDetikCoverImageTo480() throws Exception {
        String testInput = "https://akcdn.detik.net.id/community/media/visual/2017/01/08/eda5e4e3-48ae-4d51-a2fc-c2bbf828ae73_11.jpg?w=240";
        String expected = "https://akcdn.detik.net.id/community/media/visual/2017/01/08/eda5e4e3-48ae-4d51-a2fc-c2bbf828ae73_11.jpg?w=480";
        assertEquals("should convert " + testInput + " to " + expected,expected,ConverterUtils.getDetikLargeCoverImage(testInput));
    }

    @Test
    public void testGetQueryMap() throws Exception {

    }
}