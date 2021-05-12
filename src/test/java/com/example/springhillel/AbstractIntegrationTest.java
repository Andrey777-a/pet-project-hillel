package com.example.springhillel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(initializers = {AbstractIntegrationTest.Initializer.class})
@SpringBootTest
@Slf4j
public class AbstractIntegrationTest {

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues.of(
					"spring.datasource.url=" + "jdbc:mysql://localhost:3306/homeDB?useSSL=false&serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true",
					"spring.datasource.username=" + "boss",
					"spring.datasource.password=" + "boss"
			).applyTo(configurableApplicationContext.getEnvironment());
		}
	}

}
