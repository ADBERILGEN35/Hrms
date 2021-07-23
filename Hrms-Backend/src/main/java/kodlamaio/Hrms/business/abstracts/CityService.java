package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    public DataResult<List<City>> getAll();
}
