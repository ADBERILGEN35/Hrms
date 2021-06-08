package kodlamaio.Hrms.core.concretes;

import java.rmi.RemoteException;

import Mernis.GFCKPSPublicSoap;
import Mernis.GFCKPSPublicSoap12;
import kodlamaio.Hrms.core.abstracts.MernisCheckService;
import kodlamaio.Hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Component;

@Component
public class MernisCheckAdapter implements MernisCheckService {

    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        GFCKPSPublicSoap client = new GFCKPSPublicSoap();
        boolean result = false;
        try {
            result = client.TCKimlikNoDogrula(
                    Long.valueOf(jobSeeker.getIdentificationNumber()),
                    jobSeeker.getFirstName(),
                    jobSeeker.getLastName(),
                    jobSeeker.getBirthYear());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
