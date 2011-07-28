/**
 * 
 */
package teste.professordelphi.engine;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.professordelphi.engine.Vetor;

/**
 * @author edgard.leal
 *
 */
public class TestVetor extends TestCase{
	static Vetor a,b;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.professordelphi.engine.Vetor#setXY(double, double)}.
	 */
	@Test
	public void testSetXY() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.professordelphi.engine.Vetor#inverter()}.
	 */
	@Test
	public void testInverter() {
		a = new Vetor();
		b = new Vetor(0,2);
		System.out.println("Ângulo de b com 0,2 " + b.getDirecao());
		System.out.println("pi * 1.5 : " + Math.PI*1.5);
		a.setXY(2, 0);
		assertEquals(a.getDirecao(), 0d);
		b.setDirecao(Math.PI*1.5);
		b.inverter();
		assertEquals(Math.PI/2, b.getDirecao());
		
	}

}
