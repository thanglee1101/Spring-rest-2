package tacos.data;
import java.util.Optional;

import
org.springframework.data.repository.CrudRepository;

import tacos.Taco;
public interface TacoRepository extends CrudRepository<Taco, Long>{
	Iterable<Taco> findAll();
	Optional<Taco> findById(Long id);
	Taco save(Taco Taco);
}
