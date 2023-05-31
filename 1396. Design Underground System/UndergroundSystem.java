import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    // id -> Passenger
    Map<Integer,Passenger> passengers;

    // checkIn_station + "to" + checkOut_station -> list of duration (checkOut - checkIn)
    Map<String,List<Integer>> trips;

    public UndergroundSystem() {
        passengers = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        passengers.put(id,new Passenger(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // System.out.println("Passenger: "+id+ " station: "+stationName+" found? "+passengers.containsKey(id));

        Passenger p = passengers.get(id);
        String trip = p.checkInStation+" to "+stationName;

        int duration = t - p.checkInTime;

        if(!trips.containsKey(trip)) trips.put(trip,new ArrayList<>());

        trips.get(trip).add(duration);
    }

    public double getAverageTime(String startStation, String endStation) {
        String trip = startStation+" to "+endStation;

        List<Integer> durations = trips.get(trip);
        int size = durations.size();

        //System.out.println("trip : "+trip+" size: "+size+" found? "+ trips.containsKey(trip));

        int ans = 0;

        for(int duration : durations){
            ans += duration;
        }

        return (1.0 * ans) / size;
    }

    private class Passenger{
        public final int id;
        public final String checkInStation;
        public final int checkInTime;

        public Passenger(int id,String station,int time){
            this.id = id;
            checkInStation = station;
            checkInTime = time;
        }
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */