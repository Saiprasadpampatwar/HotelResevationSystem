import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HotelReservation {

    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
    public static Scanner sc = new Scanner(System.in);

    public static HashMap<String,Hotel> listOfHotels = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Hotel Reservation System");
        HotelReservation hotelReservation = new HotelReservation();
        System.out.println("Enter the customer type: 1.regular  2. reward");
        String customerType = sc.next();
        hotelReservation.validateCustomerType(customerType);
        System.out.println("Enter the Arrival Date: like 12sep2020");
        String dateArrival = sc.next();
        hotelReservation.validateDate(dateArrival);
        System.out.println("Enter the Checkout Date: like 12sep2020");
        String dateCheckout = sc.next();
        hotelReservation.validateDate(dateCheckout);

    }
    public boolean validateDate(String startDate){
        try {
            Date date1=new SimpleDateFormat("ddMMMyyyy").parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean validateCustomerType(String customerType) throws Exception {
            if(customerType.equalsIgnoreCase("regular") || customerType.equalsIgnoreCase("reward")){
                return true;
            }else {
                throw new Exception("Please Provide correct customerType");

            }
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

    public String findCheapestAndBestRatedHotelforRewardCustomers(String startDate, String endDate) throws ParseException {
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

        int finalWeekendDays = weekendDays;
        int finalWeekDays = weekDays;
        int minimumPriceofHotel = listOfHotels.values().stream().map(hotel -> hotel.getRateRewardWeekend()* finalWeekendDays +hotel.getRateRewardWeekDays()* finalWeekDays)
                .min((x, y) -> x - y).get();
        ArrayList<String> hotel = (ArrayList<String>) listOfHotels.values().stream().filter(hotel1 -> minimumPriceofHotel==hotel1.getRateRewardWeekend()* finalWeekendDays +hotel1.getRateRewardWeekDays()* finalWeekDays)
                .map(hotel1 -> hotel1.getHotelName()).collect(Collectors.toList());

        int ratingsGiven =listOfHotels.values().stream().filter(hotel2 -> minimumPriceofHotel==hotel2.getRateRewardWeekend()* finalWeekendDays +hotel2.getRateRewardWeekDays()* finalWeekDays)
                .map(hotel1 -> hotel1.getRatings()).min((x,y)->x-y).get();


        System.out.println(hotel.get(0)+" Ratings: "+ratingsGiven+" Total Rates: "+minimumPriceofHotel);
        return hotel.get(0);
    }

}


