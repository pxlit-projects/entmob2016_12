package be.pxl.regendans.repository;

import be.pxl.regendans.entity.Temperature;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Frank on 28-10-2016.
 */
public interface TemperatureRepository extends CrudRepository<Temperature,Integer> {
    List<Temperature> findTemperatureByUserid(int id);
}
