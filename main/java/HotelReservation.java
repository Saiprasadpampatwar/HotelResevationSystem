import java.util.HashMap;

public class HotelReservation {

    public static HashMap<String,Hotel> listOfHotels = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");

    }

    public void add(String hotelName, int rateRegular, int regularWeekend) {
        Hotel hotel = new Hotel(hotelName,rateRegular,regularWeekend);
        listOfHotels.put(hotelName,hotel);
    }
}


