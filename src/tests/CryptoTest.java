package tests;

import static junit.framework.TestCase.*;
import org.junit.Test;
import com.velocity.jwakfu.crypto.RSACertificateManager;

public class CryptoTest {

	@Test
	public void test() {
		assertEquals(RSACertificateManager.INSTANCE.getPublicKey().length, 162);
	}

}
