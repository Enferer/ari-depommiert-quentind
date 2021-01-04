package fr.univ.lille.aribiblio.dao;

import fr.univ.lille.aribiblio.model.Rented;
import fr.univ.lille.aribiblio.model.RentedId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentedDao extends CrudRepository<Rented, RentedId> {
    public List<Rented> findAll();
}
