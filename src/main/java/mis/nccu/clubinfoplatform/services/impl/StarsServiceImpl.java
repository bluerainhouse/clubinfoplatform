package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.Stars;
import mis.nccu.clubinfoplatform.payload.request.StarRequest;
import mis.nccu.clubinfoplatform.repository.StarsRepository;
import mis.nccu.clubinfoplatform.services.StarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StarsServiceImpl implements StarsService {

    @Autowired
    StarsRepository starsRepository;

    @Override
    public List<Stars> getByUserIdAndAnoId(Long userId, Long anoId) {
        return starsRepository.findByUserIdAndAnoId(userId, anoId);
    }

    @Override
    public void save(StarRequest starRequest) {
        starsRepository.save(new Stars(starRequest.getUserId(), starRequest.getAnoId()));
    }

    @Override
    public void delete(Long id) {
        starsRepository.deleteById(id);
    }
}

