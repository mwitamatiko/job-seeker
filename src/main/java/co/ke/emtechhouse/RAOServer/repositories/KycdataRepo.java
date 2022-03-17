package co.ke.emtechhouse.RAOServer.repositories;

import co.ke.emtechhouse.RAOServer.models.Kycdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycdataRepo extends JpaRepository<Kycdata, Long> {

}
