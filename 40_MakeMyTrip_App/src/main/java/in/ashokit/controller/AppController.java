package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.ashokit.binding.Passenger;
import in.ashokit.binding.Ticket;
import in.ashokit.service.MakeMyTripService;
import reactor.core.publisher.Mono;

@RestController
public class AppController {

    @Autowired
    private MakeMyTripService service;

    // ------------------- BOOK TICKET -------------------
    @PostMapping("/book")
    public ResponseEntity<Mono<Ticket>> bookTicket(@RequestBody Passenger passenger) {
        Mono<Ticket> ticketMono = service.bookTicket(passenger);
        return new ResponseEntity<>(ticketMono, HttpStatus.CREATED); // 201 Created
    }

    // ------------------- GET ALL TICKETS -------------------
    @GetMapping("/tickets")
    public ResponseEntity<Mono<Ticket[]>> getAllTickets() {
        Mono<Ticket[]> ticketsMono = service.getAllTickets();
        return new ResponseEntity<>(ticketsMono, HttpStatus.OK); // 200 OK
    }
}
