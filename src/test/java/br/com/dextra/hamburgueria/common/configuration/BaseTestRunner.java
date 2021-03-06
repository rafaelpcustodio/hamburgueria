package br.com.dextra.hamburgueria.common.configuration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Class used as basis for the unit tests.
 *
 * @author rafaelcustodio
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestRootConfig.class)
public abstract class BaseTestRunner {
}