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
    public Stars getByUserIdAndAnoId(Long userId, Long anoId) {
        return starsRepository.findFirstByUserIdAndAnoId(userId, anoId);
    }

    @Override
    public List<Stars> getByUserId(Long userId) {
        return starsRepository.findByUserId(userId);
    }

    @Override
    public Stars save(StarRequest starRequest) {
        return starsRepository.save(new Stars(starRequest.getUserId(), starRequest.getAnoId()));
    }

    @Override
    public void delete(Long id) {
        starsRepository.deleteById(id);
    }
}

