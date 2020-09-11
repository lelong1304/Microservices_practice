package longware.app.data.repository;

import longware.app.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Integer> {
    public List<AccountEntity> findAllByStatus(String status);
}
