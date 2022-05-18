package tacos.web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tacos.Order;
import tacos.Taco;
import tacos.data.OrderRepository;
import tacos.data.TacoRepository;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
	private OrderRepository orderRepo;
	@Autowired
//	EntityLinks entityLinks;

	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@GetMapping("/recent")
	public Iterable<Order> recentTacos() {
		return orderRepo.findAll();
	}

	@GetMapping("/{id}")
	public Order tacoById(@PathVariable("id") Long id) {
		Optional<Order> optTaco = orderRepo.findById(id);
		if (optTaco.isPresent()) {
			return optTaco.get();
		}
		return null;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Order postTaco(@RequestBody Order order) {
		return orderRepo.save(order);
	}
}