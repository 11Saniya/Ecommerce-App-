package com.project.ecommerce;

/*   import static org.junit.jupiter.api.Assertions.assertEquals; */

// import static org.mockito.Mockito.when;

// import java.util.stream.Collectors;
// import java.util.stream.Stream;

/*import org.junit.jupiter.api .Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean; */

// import com.project.ecommerce.Model.Euser;
/*import com.project.ecommerce.Repository.Erepository;
import com.project.ecommerce.Service.Eservice;

@SpringBootTest
class EcommerceApplicationTests {

	@Autowired
	Eservice service;
	@MockBean//say compiler that it is only for mock
	Erepository repo;

	@Test
	void contextLoads() {//when method is called
		// when(repo.findAll()).thenReturn(Stream.of(new Euser(1,"abc","abc123"),new Euser(1,"abc","abc123")).collect(Collectors.toList()));
	      assertEquals(2,service.findAll().size());//2 is no.of rows
	}

}
*/