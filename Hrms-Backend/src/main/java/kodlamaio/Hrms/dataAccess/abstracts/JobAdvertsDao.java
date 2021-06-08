package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertsDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByIsActiveTrue();

    List<JobAdvertisement> getJobAdvertByIsActiveTrueAndEmployer_CompanyName(String companyName);

    List<JobAdvertisement> findAllByIsActiveTrue(Sort sort);

    @Transactional
    @Modifying
    @Query("Update JobAdvertisement set isActive = false where id =:jobAdvertId")
    void deactiveJobAdvert(int jobAdvertId);
}

