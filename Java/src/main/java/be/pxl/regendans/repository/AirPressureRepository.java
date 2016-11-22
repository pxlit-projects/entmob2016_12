package be.pxl.regendans.repository;

import be.pxl.regendans.entity.AirPressure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Frank on 28-10-2016.
 */
@Repository
public interface AirPressureRepository extends CrudRepository<AirPressure,Integer> {
    List<AirPressure> findAirpressureByUserid(int id);

    void deleteAirpressureByUserid(int id);
}
