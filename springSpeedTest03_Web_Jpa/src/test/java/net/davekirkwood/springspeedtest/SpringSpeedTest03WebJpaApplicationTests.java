package net.davekirkwood.springspeedtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.davekirkwood.springspeedtest.database.ModelDatabase;
import net.davekirkwood.springspeedtest.model.Model;

@SpringBootTest
class SpringSpeedTest03WebJpaApplicationTests {


	@Autowired
	ModelDatabase modelDatabase;
	
	@Test
	void contextLoads() {
	}

	@Test
	void addModel() {
		modelDatabase.addModel(new Model(1, "name", 2));
	}
}
