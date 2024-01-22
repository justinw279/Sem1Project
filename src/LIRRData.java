import dev.katsute.onemta.MTA;
import dev.katsute.onemta.railroad.LIRR;

public class LIRRData {

    /** Represents an instance of the MTA Class
     *
     */
    private static MTA mtaClass;
    /** Represents an instance of the LIRR.Route Class
     *
     */
    private LIRR.Route route;
    /** Represents an instance of the LIRR.Stop Class
     *
     */
    private LIRR.Stop stop;
    /** Represents an instance of the LIRR.Trip Class
     *
     */
    private LIRR.Trip trip;
    public LIRRData(MTA mta) {
        mtaClass = mta;
    }

    /** Prints the GTFS LIRR ID for a route with their corresponding name.
     *
     */
    public static void displayIDToLineConversion() {
        for (int i = 0; i < 12; i++) {
            System.out.println("ID " + (i + 1) + ": " + mtaClass.getLIRRRoute(i + 1).getRouteName());
        }
    }

    /** Prints the information of an LIRR route from an LIRR.Route object.
     *
     * @param input
     * PRECONDITION: The input is a valid LIRR route that can be obtained in a displayIDToLineConversion message.
     */
    public void getRouteInformation(int input) throws InterruptedException {
        String name = mtaClass.getLIRRRoute(input).getRouteName();
        LIRR.Alert[] alerts = mtaClass.getLIRRRoute(input).getAlerts();
        LIRR.Vehicle[] vehicles = mtaClass.getLIRRRoute(input).getVehicles();
        UpcomingVehicles.displayUpcomingVehicles(vehicles);
    }

    /** Prints the information of an LIRR station from an LIRR.Station object.
     *
     * @param input
     * PRECONDITION: The station is a valid GTFS station ID.
     */
    public void getStationInformation(int input) throws InterruptedException {
        LIRR.Stop lirrStop = mtaClass.getLIRRStop(input);
        System.out.println("Name: " + lirrStop.getStopName());
        System.out.println("Stop code: " + lirrStop.getStopCode());
        System.out.println("UPCOMING VEHICLES:");
        LIRR.Vehicle[] lirrStopVehicles = lirrStop.getVehicles();
        UpcomingVehicles.displayUpcomingVehicles(lirrStopVehicles);
    }

    /** Prints the information of an LIRR train from an LIRR.Vehicle object.
     *
     * @param input
     * PRECONDITION: The input is a valid LIRR train.
     */
    public void getTrainInformation(int input) {
        LIRR.Vehicle lirrTrain = mtaClass.getLIRRTrain(String.valueOf(input));
        System.out.println("Route: " + lirrTrain.getRoute().getRouteName());
        System.out.println("Train ID: " + lirrTrain.getVehicleID());
        System.out.println("Next stop: " + lirrTrain.getStop().getStopName());
        System.out.println("Status: " + lirrTrain.getStatus());
        System.out.println();
    }

    /** Helper that displays alerts from an LIRR.Stop or LIRR.Route.
     *
     * @param alert
     * PRECONDITION: The input is not null.
     */
    private void displayAlerts(LIRR.Alert[] alert) {
        for (int i = 0; i < alert.length; i++) {
            System.out.println("Alert " + (i + 1));
            System.out.println(alert[i].getDescription());
            System.out.println();
        }
    }


}
