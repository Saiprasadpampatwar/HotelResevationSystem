import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HotelReservation {

    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

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

        int weekDays = 0;
        int weekendDays = 0;
        Calendar start = Calendar.getInstance();
        start.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(new Date(date2.getTime()+MILLIS_IN_A_DAY));

        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {

            if((date.toString()).substring(0,3).equals("Sat") || (date.toString()).substring(0,3).equals("Sun")){
                weekendDays+=1;
            }else {
                weekDays+=1;
            }
        }

        int minimumPrice = (listOfHotels.get("BridgeWood").getRateRegularCustomer()*weekDays)+(listOfHotels.get("BridgeWood").getRateRegularWeekend()*weekendDays);
        String hotelName = null;
        int ratingsofHotel = 3;
        for(Hotel p: listOfHotels.values()){
            int minimumPriceOfHotel = (p.getRateRegularCustomer()*weekDays)+(p.getRateRegularWeekend()*weekendDays);
            if(minimumPrice>=minimumPriceOfHotel){
                minimumPrice = minimumPriceOfHotel;
                if(p.getRatings()>ratingsofHotel){
                    ratingsofHotel = p.getRatings();
                    hotelName = p.getHotelName();
                }

            }
        }


        System.out.println(hotelName+"Ratings: "+ratingsofHotel+" Total Rates: "+minimumPrice);
        return hotelName;
    }

    public void addRatings(String hotelName, int ratings) {
      for(Hotel p: listOfHotels.values()){
          if(p.getHotelName().equals(hotelName)){
              p.setRatings(ratings);
          }
      }
    }

    public String topRatedHotel(String startDate, String endDate) throws ParseException {
        Date date1=new SimpleDateFormat("ddMMMyyyy").parse(startDate);
        Date date2=new SimpleDateFormat("ddMMMyyyy").parse(endDate);

        int weekDays = 0;
        int weekendDays = 0;
        Calendar start = Calendar.getInstance();
        start.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(new Date(date2.getTime()+MILLIS_IN_A_DAY));

        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {

            if((date.toString()).substring(0,3).equals("Sat") || (date.toString()).substring(0,3).equals("Sun")){
                weekendDays+=1;
            }else {
                weekDays+=1;
            }
        }
        String hotelName = null;
        int ratings = listOfHotels.get("BridgeWood").getRatings();
        for(Hotel h: listOfHotels.values()){
            if(h.getRatings()>ratings){
                ratings = h.getRatings();
                hotelName = h.getHotelName();
            }
        }
        int minimumPrice = (listOfHotels.get(hotelName).getRateRegularCustomer()*weekDays)+(listOfHotels.get(hotelName).getRateRegularWeekend()*weekendDays);
        System.out.println(hotelName+" & Total Rate : "+minimumPrice);
        return hotelName;

    }

    public void addRewardCustomersRates(String hotelName, int rateRewardWeekdays, int rateRewardWeekends) {
        for(Hotel p: listOfHotels.values()){
            if(p.getHotelName().equals(hotelName)){
                p.setRateRewardWeekDays(rateRewardWeekdays);
                p.setRateRewardWeekend(rateRewardWeekends);
            }
        }
    }
}


