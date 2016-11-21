package be.pxl.regendans.repository;

import be.pxl.regendans.entity.Humidity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Frank on 28-10-2016.
 */
public interface HumidityRepository extends CrudRepository<Humidity,Integer> {
    List<Humidity> findHumidityByUserId(int id);
}
