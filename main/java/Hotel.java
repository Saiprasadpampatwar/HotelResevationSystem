public class Hotel {

    private String hotelName;
    private int rateRegularWeekdays;
    private int rateRegularWeekend;
    public static int ratings;

    public Hotel(String hotelName, int rateRegularWeekdays,int rateRegularWeekend) {
        this.hotelName = hotelName;
        this.rateRegularWeekdays = rateRegularWeekdays;
        this.rateRegularWeekend = rateRegularWeekend;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRateRegularCustomer() {
        return rateRegularWeekdays;
    }

    public void setRateRegularCustomer(int rateRegularCustomer) {
        this.rateRegularWeekdays = rateRegularCustomer;
    }

    public int getRateRegularWeekend() {
        return rateRegularWeekend;
    }

    public void setRateRegularWeekend(int rateRegularWeekend) {
        this.rateRegularWeekend = rateRegularWeekend;
    }


}
