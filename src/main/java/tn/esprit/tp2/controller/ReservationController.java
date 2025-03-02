package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Reservation;
import tn.esprit.tp2.services.IReservationServices;

import java.util.List;

@RequestMapping("/reservation")
@RestController
@AllArgsConstructor
public class ReservationController {
 IReservationServices reservationServices;
    @GetMapping("/etrievealreservations")
    public List<Reservation> getReservations() {
        return reservationServices.retrieveAllReservation();
    }


    @GetMapping("/retrievereservation/{reservationid}")
    public Reservation retrieveReservation(@PathVariable String idReservation){
        return reservationServices.retrieveReservation(idReservation);
    }
    @PutMapping("/update")
    public  Reservation updateReservation(Reservation res)  {
        return  reservationServices.updateReservation(res);
    }

}