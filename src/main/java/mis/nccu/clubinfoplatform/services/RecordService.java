package mis.nccu.clubinfoplatform.services;

import java.util.List;

import mis.nccu.clubinfoplatform.models.Record;
public interface RecordService {
	public List<Record> getAll();
	
	public Record getById(int id);
	
	public void saveOrUpdate(Record record);
	
	public void delete(int id);
	
	public List<Record> getAllByLogin(String login);
}

