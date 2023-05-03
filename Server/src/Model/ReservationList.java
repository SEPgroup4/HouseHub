package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable
{
    private ArrayList<Reservation> list;

    public ReservationList(){
        this.list= new ArrayList<>();
    }
    public void addReservation(Reservation reservation){
        for (Reservation reservation1 : list)
            if (reservation1.equals(reservation))
                throw new IllegalStateException();
        list.add(reservation);
        reservation.getRoom().setReserved(true);
    }
    public void removeReservation(Reservation reservation){
        if (list.size() == 0)
            throw  new IllegalStateException();


        reservation.getRoom().setReserved(false);
        list.remove(reservation);
    }
    public Reservation getReservationAtIndex(int index){
        return list.get(index);
    }

    public ArrayList<Reservation> getAllReservations(){
        return list;
    }

    @Override
    public String toString() {
        return "Reservations: {"+ list +
                '}';
    }
}
