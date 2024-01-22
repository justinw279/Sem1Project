import dev.katsute.onemta.MTA;
import dev.katsute.onemta.subway.Subway;

import static java.lang.Integer.parseInt;
import java.util.Date;

public class SubwayData {

    /** Represents an instance of the MTA Class
     *
     */
    private MTA mtaClass;
    /** Represents an instance of the Subway.Vehicle class
     *
     */
    private Subway.Vehicle[] subwayVehicles;
    /** Represents an instance of the Subway.Route class
     *
     */
    private Subway.Route subwayRoute;
    /** Represents an instance of the Subway.Stop class
     *
     */
    private Subway.Stop subwayStop;


    public SubwayData(MTA mta) {
        mtaClass = mta;
    }

    /** Prints the subway vehicles in a subway line by getting every Subway.Vehicle object.
     *
     * @param input
     * PRECONDITION: The input represents a valid subway line.
     */
    public void displaySubwayVehicles(String input) throws InterruptedException {
        subwayRoute = mtaClass.getSubwayRoute(input);
        subwayVehicles = subwayRoute.getVehicles();
        System.out.println("All subway vehicles on route " + subwayRoute.getRouteShortName());
        System.out.println("DISCLAIMER: North = railroad north (Bronx, Queens) and South = railroad south (Brooklyn, Manhattan)");
        System.out.println();
        UpcomingVehicles.displayUpcomingVehicles(subwayVehicles);
    }

    /** Prints information from a Subway.Stop object.
     *
     * @param input
     * PRECONDITION: The input represents a valid station ID without the direction indicator (631N is not valid, for example)
     */
    public void subwayStopInformation(String input) throws InterruptedException {
        subwayStop = mtaClass.getSubwayStop(parseInt(input));
        String subwayStopName = subwayStop.getStopName();
        System.out.println("Subway stop: " + subwayStopName);
        System.out.println("Upcoming trains to " + subwayStopName);
        UpcomingVehicles.displayUpcomingVehicles(subwayStop);

    }


}
