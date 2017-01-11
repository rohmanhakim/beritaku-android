package com.rohmanhakim.beritaku.main;

import com.rohmanhakim.beritaku.model.DataManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/8/17 11:53.
 */
public class MainPresenterTest {

    @Mock MainView mainView;
    @Mock DataManager dataManager;
    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(dataManager,mainView);
    }

    @Test
    public void testFetchNewsFromDetik() throws Exception {

    }
}