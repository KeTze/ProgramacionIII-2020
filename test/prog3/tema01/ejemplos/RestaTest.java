package prog3.tema01.ejemplos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prog3.tema01.ejemplos.junit.Resta;

public class RestaTest {
	
	private Resta resta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		resta = new Resta ();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDecrementa() {
		//assertEquals("Test resta", 1, resta.decrementa(2));
		assertTrue("test decrementa", 1 == resta.decrementa(2));
	}

	@Test
	public void testGetDiferencia() {
		fail("Not yet implemented");
	}

}
