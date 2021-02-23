package util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.revature.res.util.HibernateSessionFactory;

class TestHibernate {

	@Test
	void test() {
		Session s = HibernateSessionFactory.getSession();
		assertNotNull(s);
		System.out.println(s.toString());
	}

}
