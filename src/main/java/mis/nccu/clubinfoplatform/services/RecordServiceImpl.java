package mis.nccu.clubinfoplatform.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mis.nccu.clubinfoplatform.models.Record;
import mis.nccu.clubinfoplatform.repository.RecordRepository;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;
	@Override
	public List<Record> getAll() {
		return recordRepository.findAll();
	}

	@Override
	public Record getById(int id) {
		return recordRepository.getReferenceById(id);
	}

	@Override
	public void saveOrUpdate(Record record) {
		//判斷是否為新物件
		if (record.getId() == 0) {
			record.setRecordDate(new Date());
		}
		recordRepository.save(record);

	}

	@Override
	public void delete(int id) {
		recordRepository.deleteById(id);
	}

	@Override
	public List<Record> getAllByLogin(String login) {
		return recordRepository.findByLogin(login);
	}

}

