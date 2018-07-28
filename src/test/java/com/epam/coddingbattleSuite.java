package com.epam;

import com.epam.client.coddingbattleTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class coddingbattleSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for coddingbattle");
    suite.addTestSuite(coddingbattleTest.class);
    return suite;
  }
}
