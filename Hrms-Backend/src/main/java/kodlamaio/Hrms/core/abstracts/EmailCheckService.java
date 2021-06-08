package kodlamaio.Hrms.core.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface EmailCheckService {
    public boolean emailCheck(String email);
}
