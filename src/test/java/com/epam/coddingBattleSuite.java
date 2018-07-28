package com.epam;

import com.epam.client.coddingBattleTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class coddingBattleSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for CoddingBattle");
    suite.addTestSuite(coddingBattleTest.class);
    return suite;
  }
}
