import com.dmdev.database.pool.ConnectionPool;
import com.dmdev.database.repository.CompanyRepository;
import com.dmdev.database.repository.UserRepository;
import com.dmdev.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var pool1 = context.getBean("pool1", ConnectionPool.class);
            System.out.println(pool1);

            var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }
    }
}
