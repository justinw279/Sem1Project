import dev.katsute.onemta.MTA;
import dev.katsute.onemta.subway.Subway;

import static java.lang.Integer.parseInt;
import java.util.Date;

public class SubwayData {

    private MTA mtaClass;
    private Subway.Vehicle[] subwayVehicles;
    private Subway.Route subwayRoute;
    private Subway.Stop subwayStop;

    public SubwayData(MTA mta) {
        mtaClass = mta;
    }

    public void displaySubwayVehicles(String input) {
        subwayRoute = mtaClass.getSubwayRoute(input);
        subwayVehicles = subwayRoute.getVehicles();
        System.out.println("All subway vehicles on route " + subwayRoute.getRouteShortName());
        System.out.println("DISCLAIMER: North = railroad north (Bronx, Queens) and South = railroad south (Brooklyn, Manhattan)");
        System.out.println();
        displayUpcomingVehicles(subwayVehicles);
    }

    public void subwayStopInformation(String input) {
        subwayStop = mtaClass.getSubwayStop(parseInt(input));
        String subwayStopName = subwayStop.getStopName();
        System.out.println("Subway stop: " + subwayStopName);
        System.out.println("Upcoming trains to " + subwayStopName);
        displayUpcomingVehicles(subwayStop);

    }

    private void displayUpcomingVehicles(Subway.Stop s) {
        for (int i = 0; i < s.getVehicles().length; i++) {
            System.out.println("#" + (i + 1));
            System.out.println("Line: " + s.getVehicles()[i].getRoute().getRouteShortName());
            System.out.println("Status: " + s.getVehicles()[i].getStatus());
            System.out.println("Direction: " + s.getVehicles()[i].getStop().getDirection());
            System.out.println("Next stop: " + s.getVehicles()[i].getStop().getStopName());
            System.out.println("Stop ID: " + s.getVehicles()[i].getStopID());
            System.out.println();
        }
    }


    private void displayUpcomingVehicles(Subway.Vehicle[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println("#" + (i + 1));
            System.out.println("Line: " + s[i].getRoute().getRouteShortName());
            System.out.println("Status: " + s[i].getStatus());
            System.out.println("Direction: " + s[i].getStop().getDirection());
            System.out.println("Next stop: " + s[i].getStop().getStopName());
            System.out.println("Stop ID: " + s[i].getStopID());
            System.out.println();
        }
    }


}
