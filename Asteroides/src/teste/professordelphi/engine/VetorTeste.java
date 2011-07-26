package teste.professordelphi.engine;

import java.util.Calendar;

import junit.framework.TestCase;
import org.junit.*;

import com.professordelphi.engine.Vetor;

public class VetorTeste extends TestCase{
	Vetor v;
	
	@Test
	public void inicio(){
		v = new Vetor(2d,2d);
		System.out.println("Classe de teste iniciada " + Calendar.getInstance().toString());
	}
	
	@Test
	public void testVetorDoubleDouble() {
		v = new Vetor(2d,2d);
		v.setX(2d);
		v.setY(2d);
		assertEquals(Math.sqrt(8), v.getRaio());
	}

	@Test
	public void testProdutoInterno() {
		
	}

	@Test
	public void testProdutoExterno() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSomarDoubleDouble() {
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSomarVetor() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSubtrairDoubleDouble() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSubtrairVetor() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRaio() {
		fail("Not yet implemented"); // TODO
	}

}
