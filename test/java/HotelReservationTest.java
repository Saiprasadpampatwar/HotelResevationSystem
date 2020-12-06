import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class HotelReservationTest {
    @Test
    public void givenHotelNameShouldReturnTrue() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",160,60);
        hotelReservation.add("LikeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        Assert.assertEquals("BridgeWood",HotelReservation.listOfHotels.get("BridgeWood").getHotelName());
        Assert.assertEquals("LikeWood",HotelReservation.listOfHotels.get("LikeWood").getHotelName());
        Assert.assertEquals("RidgeWood",HotelReservation.listOfHotels.get("RidgeWood").getHotelName());
    }

    @Test
    public void givenDatesShouldReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",160,60);
        hotelReservation.add("LikeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        String cheapestHotel = hotelReservation.findCheapestHotel("10sep2020", "11sep2020");
        Assert.assertEquals("LikeWood",cheapestHotel);

    }

    @Test
    public void givenWeekDaysAndWeekendRatesShouldReturnTrue() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",160,60);
        hotelReservation.add("LikeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        Assert.assertEquals(160,HotelReservation.listOfHotels.get("BridgeWood").getRateRegularCustomer());
        Assert.assertEquals(60,HotelReservation.listOfHotels.get("BridgeWood").getRateRegularWeekend());
        Assert.assertEquals(110,HotelReservation.listOfHotels.get("LikeWood").getRateRegularCustomer());
        Assert.assertEquals(90,HotelReservation.listOfHotels.get("LikeWood").getRateRegularWeekend());
        Assert.assertEquals(220,HotelReservation.listOfHotels.get("RidgeWood").getRateRegularCustomer());
        Assert.assertEquals(150,HotelReservation.listOfHotels.get("RidgeWood").getRateRegularWeekend());

    }

    @Test
    public void givenDatesRangeContainingWeekDaysAndWeekendShouldReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",150,50);
        hotelReservation.add("LikeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        String cheapestHotel = hotelReservation.findCheapestHotel("11sep2020", "12sep2020");
        Assert.assertEquals("BridgeWood",cheapestHotel);

    }

    @Test
    public void givenRatingsToHotelShouldRetuenTheSame() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",150,50);
        hotelReservation.add("LakeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        hotelReservation.addRatings("BridgeWood",4);
        hotelReservation.addRatings("LakeWood",3);
        hotelReservation.addRatings("RidgeWood",5);
        Assert.assertEquals(4,HotelReservation.listOfHotels.get("BridgeWood").getRatings());
        Assert.assertEquals(5,HotelReservation.listOfHotels.get("RidgeWood").getRatings());
        Assert.assertEquals(3,HotelReservation.listOfHotels.get("LakeWood").getRatings());

    }

    @Test
    public void givenDatesRangeContainingWeekDaysAndWeekendShouldReturnCheapestHotelWithBestRatings() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",150,50);
        hotelReservation.add("LakeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        hotelReservation.addRatings("BridgeWood",4);
        hotelReservation.addRatings("LakeWood",3);
        hotelReservation.addRatings("RidgeWood",5);
        String cheapestHotel = hotelReservation.findCheapestHotel("11sep2020", "12sep2020");
        Assert.assertEquals("BridgeWood",cheapestHotel);

    }

    @Test
    public void givenDatesRangeContainingWeekDaysAndWeekendShouldReturnTopRatedHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.add("BridgeWood",150,50);
        hotelReservation.add("LakeWood",110,90);
        hotelReservation.add("RidgeWood",220,150);
        hotelReservation.addRatings("BridgeWood",4);
        hotelReservation.addRatings("LakeWood",3);
        hotelReservation.addRatings("RidgeWood",5);
        String cheapestHotel = hotelReservation.topRatedHotel("11sep2020", "12sep2020");
        Assert.assertEquals("RidgeWood",cheapestHotel);

    }
}
