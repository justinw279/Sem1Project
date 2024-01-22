import dev.katsute.onemta.bus.Bus;
import dev.katsute.onemta.railroad.LIRR;
import dev.katsute.onemta.subway.Subway;
import java.lang.Thread;

public class UpcomingVehicles {

    private UpcomingVehicles() {}

    /** Displays the upcoming vehicles in an array of vehicle objects. All other classes are overloaded methods.
     *
     * @param s
     */
    public static void displayUpcomingVehicles(Subway.Stop s) throws InterruptedException {
        for (int i = 0; i < s.getVehicles().length; i++) {
            System.out.println("#" + (i + 1));
            System.out.println("Line: " + s.getVehicles()[i].getRoute().getRouteShortName());
            System.out.println("Status: " + s.getVehicles()[i].getStatus());
            System.out.println("Direction: " + s.getVehicles()[i].getStop().getDirection());
            System.out.println("Next stop: " + s.getVehicles()[i].getStop().getStopName());
            System.out.println("Stop ID: " + s.getVehicles()[i].getStopID());
            System.out.println();
            Thread.sleep(500);
        }
    }

    public static void displayUpcomingVehicles(Subway.Vehicle[] s) throws InterruptedException {
        for (int i = 0; i < s.length; i++) {
            System.out.println("#" + (i + 1));
            System.out.println("Line: " + s[i].getRoute().getRouteShortName());
            System.out.println("Status: " + s[i].getStatus());
            System.out.println("Direction: " + s[i].getStop().getDirection());
            System.out.println("Next stop: " + s[i].getStop().getStopName());
            System.out.println("Stop ID: " + s[i].getStopID());
            System.out.println();
            Thread.sleep(500);
        }
    }

    public static void displayUpcomingVehicles(Bus.Route r) throws InterruptedException {
        for (int i = 0; i < r.getVehicles().length; i++) {
            Bus.Vehicle vehicle = r.getVehicles()[i];
            System.out.println("#" + (i + 1));
            System.out.println("Route: " + vehicle.getRoute().getRouteShortName() + " " +  vehicle.getRoute().getRouteName());
            System.out.println("Vehicle Number: " + vehicle.getVehicleID());
            System.out.println("Next stop: " + vehicle.getTrip().getTripStops()[0].getStop().getStopName());
            System.out.println("Passengers: " + vehicle.getPassengers());
            System.out.println();
            Thread.sleep(500);
        }
    }

    public static void displayUpcomingVehicles(Bus.Stop s) throws InterruptedException {
        for (int i = 0; i < s.getVehicles().length; i++) {
            System.out.println("Vehicles approaching bus stop: ");
            System.out.println("#" + (i + 1));
            System.out.println("Route: " + s.getVehicles()[i].getRoute().getRouteShortName() + " " +  s.getVehicles()[i].getRoute().getRouteName());
            System.out.println("Vehicle Number: " + s.getVehicles()[i].getVehicleID());
            System.out.println("Next stop: " + s.getVehicles()[i].getStop().getStopName());
            System.out.println("Passengers: " + s.getVehicles()[i].getPassengers());
            System.out.println();
            Thread.sleep(500);

        }
    }

    public static void displayUpcomingVehicles(LIRR.Vehicle[] v) throws InterruptedException {
        for (int i = 0; i < v.length; i++) {
            LIRR.Vehicle vehicle = v[i];
            System.out.println("#" + (i + 1));
            System.out.println("Route: " + vehicle.getRoute().getRouteName());
            System.out.println("Train ID: " + vehicle.getVehicleID());
            System.out.println("Next stop: " + vehicle.getStop().getStopName());
            System.out.println("Status: " + vehicle.getStatus());
            System.out.println();
            Thread.sleep(500);
        }
    }



}
