import dev.katsute.onemta.MTA;
import dev.katsute.onemta.bus.Bus;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class BusData {

    /** Represents an instance of the MTA Class
     *
     */
    private MTA mtaClass;
    /** Represents an instance of the Bus.Route class
     *
     */
    private Bus.Route busRoute;
    /** Represents an instance of the Bus.Stop class
     *
     */
    private Bus.Stop busStop;
    public BusData(MTA mta) {
        mtaClass = mta;
    }

    /** Prints the bus route information and vehicles based on the route given.
     *
     * @param b
     * PRECONDITION: The bus route provided is an actual bus route.
     */
    public void busRouteInformation(String b) throws InterruptedException {
        busRoute = mtaClass.getBusRoute(b);
        assert busRoute != null;
        System.out.println("Bus route: " + busRoute.getRouteShortName() + " " + busRoute.getRouteDescription());

        System.out.print("Bus route alerts: ");
        displayAlerts(busRoute);

        UpcomingVehicles.displayUpcomingVehicles(busRoute);
    }

    /** Prints the information and upcoming buses for a bus stop.
     *
     * @param stopID
     * PRECONDITION: The stop ID given is a valid bus stop, and NOT the name of a bus stop. Visit bt.mta.info and type in a six-digit code for an example.
     */
    public void busStopInformation(String stopID) throws InterruptedException {
        busStop = mtaClass.getBusStop(parseInt(stopID));
        System.out.println(busStop.getStopID() + " " + busStop.getStopName());

        System.out.print("Bus route alerts: ");
        displayAlerts(busStop);

        UpcomingVehicles.displayUpcomingVehicles(busStop);
    }

    /** Helper method to display the alerts in a Bus.Route object.
     *
     * @param r
     * PRECONDITION: The object is not null.
     */
    private void displayAlerts(Bus.Route r) {
        for (int i = 0; i < r.getAlerts().length; i++) {
            System.out.println("Alert " + (i + 1));
            System.out.println(r.getAlerts()[i].getDescription());
            System.out.println();
        }
    }

    /** Helper method to display the alerts in a Bus.Stop object.
     *
     * @param s
     * PRECONDITION: The object is not null.
     */
    private void displayAlerts(Bus.Stop s) {
        for (int i = 0; i < s.getAlerts().length; i++) {
            System.out.println("Alert " + (i + 1));
            System.out.println(s.getAlerts()[i].getDescription());
            System.out.println();
        }
    }


}
