package be.pxl.regendans.repository;

import be.pxl.regendans.entity.AirPressure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Frank on 28-10-2016.
 */
public interface AirPressureRepository extends CrudRepository<AirPressure,Integer> {
    List<AirPressure> findAirPressureByUserid(int id);
}
