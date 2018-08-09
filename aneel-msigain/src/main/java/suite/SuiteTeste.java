package suite;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import core.DriverFactory;
import test.*;


@RunWith(Suite.class)
@SuiteClasses({
	Login.class,
	ClassificarDemandaDiretoria.class,
	GerarDemandaDiretoria.class
})

public class SuiteTeste {
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}