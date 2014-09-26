package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ModelsTest {
	
	@Before
	public void setUp(){

	}

	@Test
	public void createAndRetrieveUser() {
		new Users("Bob", "secret","bob@gmail.com").save();
		Users bob = Users.find.where().eq("email", "bob@gmail.com").findUnique();
		assertNotNull(bob);
		assertEquals("Bob", bob.userName);
	}
}
