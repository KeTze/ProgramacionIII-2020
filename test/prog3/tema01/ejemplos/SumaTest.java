package prog3.tema01.ejemplos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prog3.tema01.ejemplos.junit.Suma;

public class SumaTest {
	
	private Suma suma;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		suma = new Suma();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void aVerSiSumaBien() {
		assertEquals("Test suma", 2, suma.getSuma(1, 1));
	}

	@Test
	public void testIncrementa() {
		assertEquals(2, suma.incrementa(1));
	}

}
