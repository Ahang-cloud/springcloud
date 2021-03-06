import com.ah.springcloud.dao.PaymentDao;
import com.ah.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
@SpringBootTest
public class TestHH {
    @Autowired
    private PaymentDao paymentDao;

    @Test
    public void testAA(){
        Payment payment = paymentDao.findById(2L);
        System.out.println(payment.toString());
    }
}
