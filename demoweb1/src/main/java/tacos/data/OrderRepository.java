package tacos.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tacos.Ingredient;
import tacos.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
	Iterable<Order> findAll();
	Optional<Order> findById(Long id);
	Order save(Order Order);
}
