package co.edu.unbosque.antinarcoticos_finalproject_20231.repository;

import co.edu.unbosque.antinarcoticos_finalproject_20231.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    public Optional<Officer> findById(Integer id);
    public List<Officer> findAll();
    public void deleteById(Integer id);
}
