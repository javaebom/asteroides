package teste.professordelphi.engine;

import java.util.Calendar;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import com.professordelphi.engine.Vetor;

public class VetorTeste extends TestCase{
	Vetor v;

	@BeforeClass
	public void inicio(){
		v = new Vetor(2d,2d);
		System.out.println("Classe de teste iniciada " + Calendar.getInstance().toString());
	}
	/**execução 100.000 vezes 
	 * 
	 */
	@Test
	public void testVetorDoubleDouble() {
		v = new Vetor(2d,2d);
		double x,y;
		for (int i = 0; i < 100000; i++) {
			x = Math.random()*100;
			y = Math.random()*100; 
			v.setXY(x,y);
			assertEquals(Math.sqrt(Math.pow(x, 2d)+Math.pow(y, 2d)), v.getRaio());		
		}
	}

	@Test
	public void testProdutoInterno() {
		CPF cpf = new CPF();
		for (int i = 0; i < 10000; i++) {
			assertTrue(cpf.validar(CPF.getCPF()));
		}
	}

	@Test
	public void testProdutoExterno() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSomarDoubleDouble() {
		Vetor gravidade= new Vetor(0,0.05), aceleracao = new Vetor(0,0);
		
		for (int i = 0; i < 50; i++) {
			if (aceleracao.getRaio()+gravidade.getRaio()<2) 
				aceleracao.somar(gravidade);
			System.out.println(aceleracao.toString());
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	@Test(timeout=500)
	public void testSomarVetor() {
		v = new Vetor(0d,0d);
		double x=0,y=0,x2=0d,y2=0d;
		for (int i = 0; i < 10000; i++) {
			x = Math.random()*10;
			y = Math.random()*10;
			v.somar(x, y);
			x2+= x;y2+=y;
			assertEquals(Math.sqrt(Math.pow(x2, 2d)+Math.pow(y2, 2d)), v.getRaio());
		}
	}

	@Test
	public void testSubtrairDoubleDouble() {
		v = new Vetor(200d,200d);
		double x=0,y=0,x2=200d,y2=200d;
		for (int i = 0; i < 10000; i++) {
			x = Math.random()*10;
			y = Math.random()*10;
			v.subtrair(x, y);
			x2-= x;y2-=y;
			assertEquals(Math.sqrt(Math.pow(x2, 2d)+Math.pow(y2, 2d)), v.getRaio());
		}
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
