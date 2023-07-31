import com.dmdev.database.pool.ConnectionPool;
import com.dmdev.database.repository.CompanyRepository;
import com.dmdev.database.repository.UserRepository;
import com.dmdev.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var pool1 = context.getBean("pool1", ConnectionPool.class);
    }
}
