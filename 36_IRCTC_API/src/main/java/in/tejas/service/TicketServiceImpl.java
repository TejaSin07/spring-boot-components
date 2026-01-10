package in.tejas.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tejas.binding.Passenger;
import in.tejas.binding.Ticket;
import in.tejas.repo.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repo;

	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t); // use to copy from one object to other
		//make sure you have same fields in both classes which we are going to copy
		t.setTicketStatus("CONFIRMED");
		Ticket savedTicket = repo.save(t);
		return savedTicket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		return repo.findById(ticketId).orElseThrow();
	}

	@Override
	public List<Ticket> getTickets() {
		return repo.findAll();
	}

}
