import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HotelReservation {

    public static HashMap<String,Hotel> listOfHotels = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");


    }

    public void add(String hotelName, int rateRegular, int regularWeekend) {
        Hotel hotel = new Hotel(hotelName,rateRegular,regularWeekend);
        listOfHotels.put(hotelName,hotel);
    }

    public String findCheapestHotel(String startDate, String endDate) throws ParseException {
        Date date1=new SimpleDateFormat("ddMMMyyyy").parse(startDate);
        Date date2=new SimpleDateFormat("ddMMMyyyy").parse(endDate);
        long diff = TimeUnit.MILLISECONDS.toDays(date2.getTime()-date1.getTime())+1;
        
        int minimumPrice = listOfHotels.get("BridgeWood").getRateRegularCustomer();
        String hotelName = "BridgeWood";
        for(Hotel p: listOfHotels.values()){
            if(minimumPrice>p.getRateRegularCustomer() ){
                minimumPrice = p.getRateRegularCustomer();
                hotelName = p.getHotelName();
            }
        }
        long totalRates = diff*minimumPrice;
        System.out.println(hotelName+", Total Rates: "+totalRates);
        return hotelName;
    }
}


