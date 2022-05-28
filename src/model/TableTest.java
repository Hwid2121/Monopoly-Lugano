package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * The test class TableTest.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 9/05/2022
 */
public class TableTest {

  static private final int SIZETABLE = 40;
  Square[] cell = new Square[SIZETABLE];

  @Test
  public void newtabletest() {
    Table table = new Table();
  }
}
