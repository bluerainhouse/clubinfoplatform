package mis.nccu.clubinfoplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mis.nccu.clubinfoplatform.models.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer>{
	public List<Record> findByLogin(String login);
	
}
