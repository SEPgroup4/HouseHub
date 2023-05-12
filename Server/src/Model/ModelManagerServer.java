package Model;

import Database.reservation.ReservationDAO;

import Database.reservation.ReservationDAOImpl;

import Database.room.RoomDAO;

import Database.room.RoomDAOImpl;
import Database.user.UserDAO;
import Database.user.UserDAOImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManagerServer implements ModelServer
{
    private RoomList rooms;
    private ReservationList reservations;
    private UserList users;
    private UserDAO userDB;

    private ReservationDAO reservationDAO;

    private RoomDAO roomDB;


    public ModelManagerServer()
    {
        try
        {
            this.reservationDAO = ReservationDAOImpl.getInstance();
            this.userDB = UserDAOImpl.getInstance();
            this.roomDB = RoomDAOImpl.getInstance();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        this.users = new UserList();
        this.rooms = new RoomList();
        this.reservations = new ReservationList();
        User user = new User("Nuri", "Hasan", "nuriSexyBoy", "nuriSexyBoy", "00000007");
        users.addUser(user);



    }

    @Override
    public void addRoom(Room room) {
        try {
            roomDB.addRoom(room);
        } catch (SQLException e) {
            e.getMessage();
        }
        rooms.addRoom(room);
    }

    @Override
    public void removeRoom(Room room) {
        try
        {
            roomDB.getAllRooms();
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public Room getRoomByAnnouncement(String announcement) {
        try
        {
            return roomDB.getRoomByAnnouncement(announcement);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        try
        {
            return roomDB.getAllRooms();
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return null;
    }
    @Override
    public void addReservation(Reservation reservation) {
        try {
            reservation.incrementID();
            reservationDAO.addReservation(reservation);
        } catch (SQLException e) {
            System.out.println("Model manager error in add reservation");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        return reservations.getAllReservations();
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservations.removeReservation(reservation);
    }

    @Override
    public void addUser(User user) {
        try
        {
            userDB.addUser(user);

        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try
        {
            return userDB.getUserByUsername(username);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserByUsername(String username) {
        users.removeUserByUsername(username);
    }

    @Override
    public void removeUserByPhoneNumber(String phoneNumber) {
        users.removeUserByPhoneNumber(phoneNumber);
    }

    @Override public Reservation getReservationById(String id)
    {
        return reservations.getReservationById(id);
    }

    @Override public boolean setRoomReserved(Room room) throws RemoteException
    {

        try
        {
            return roomDB.setRoomReserved(room);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return true;
    }

    @Override public boolean setRoomFree(Room room)
    {
        rooms.setRoomFree(room);
        return true;
    }

    @Override public void sendFile(String name, byte[] img)
    {
        File folder = new File("Server/src/Images/");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File outFile= new File(folder.getFreeSpace() + name );
        try
        {
            FileOutputStream fos = new FileOutputStream("Server/src/Images/" + outFile,false);
            byte [] reciveimg = new byte[img.length];
            for (int i = 0; i < img.length; i++)
            {
                reciveimg[i]=img[i];
            }
            fos.write(reciveimg);
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override public boolean setUserInfo(User user)
    {
        users.setUserInfo(user);
        return true;
    }

    public User getUser(String username, String password) {
        try
        {
            return userDB.getUser(username,password);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return  null;
    }
}
