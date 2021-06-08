package kodlamaio.Hrms.core.concretes;

import kodlamaio.Hrms.core.abstracts.EmailCheckService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
public class FakeEmailCheckManager implements EmailCheckService {

    @Override
    public boolean emailCheck(String email) {
        return true;
    }

}
