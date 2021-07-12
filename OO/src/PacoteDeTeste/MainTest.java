package PacoteDeTeste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controller.Main;

/**
 * Classe de teste Junit
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
class MainTest {
	Main r = new Main();

	@SuppressWarnings("static-access")
	@Test
	void testCarteira() {
		assertFalse(r.carteira(12331));
		assertFalse(r.carteira(12224));

	}

	@SuppressWarnings("static-access")
	@Test
	void testServico_vazio() {
		assertTrue(r.servico_vazio());
		assertEquals(true, r.servico_vazio());
	}

	@SuppressWarnings("static-access")
	@Test
	void testData() {
		assertFalse(r.data("22/12/1999"));
		assertTrue(r.data("34/12/1999"));
	}

	@SuppressWarnings("static-access")
	@Test
	void testData_menor() {
		assertTrue(r.data_menor("22/12/1999", "23/12/1999"));
		assertFalse(r.data_menor("24/12/1999", "23/12/1999"));

	}

}
