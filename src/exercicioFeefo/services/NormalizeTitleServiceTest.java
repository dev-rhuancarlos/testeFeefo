package exercicioFeefo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NormalizeTitleServiceTest {
	
    private NormalizerService n = new NormalizerService();
	
	@Test
	public void shouldMatchJavaEngineerWithSoftwareEngineer() {		
		Assertions.assertEquals(n.matchStrings("Java engineer"), "Software engineer");
	}
	
	@Test
	public void shouldMatchCEngineerWithSoftwareEngineer() {
		Assertions.assertEquals(n.matchStrings("C# engineer"), "Software engineer");
	}
	
	@Test
	public void shouldMatchAccountantWithAccountant() {
		Assertions.assertEquals(n.matchStrings("Accountant"), "Accountant");
	}

	@Test
	public void shouldMatchChiefAccountantWithAccountant() {
		Assertions.assertEquals(n.matchStrings("Chief Accountant"), "Accountant");
	}

}
