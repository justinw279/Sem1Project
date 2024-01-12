import dev.katsute.onemta.DataResource;
import dev.katsute.onemta.DataResourceType;
import dev.katsute.onemta.MTA;
import dev.katsute.onemta.bus.Bus;
import dev.katsute.onemta.railroad.LIRR;
import dev.katsute.onemta.railroad.MNR;
import dev.katsute.onemta.subway.Subway;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) {

        // Handling of MTA stuff
        String busToken = "";
        String subwayToken = "";

        // Parsing to be handled.
        Parser parse = new Parser();

        MTA mta = MTA.create(
                busToken,
                subwayToken,
                DataResource.create(DataResourceType.Bus_Bronx, new File("google_transit_bronx.zip")),
                DataResource.create(DataResourceType.Bus_Brooklyn, new File("google_transit_brooklyn.zip")),
                DataResource.create(DataResourceType.Bus_Manhattan, new File("google_transit_manhattan.zip")),
                DataResource.create(DataResourceType.Bus_Queens, new File("google_transit_queens.zip")),
                DataResource.create(DataResourceType.Bus_StatenIsland, new File("google_transit_staten_island.zip")),
                DataResource.create(DataResourceType.Bus_Company, new File("google_transit_bus_company.zip")),
                DataResource.create(DataResourceType.Subway, new File("google_transit_subway.zip")),
                DataResource.create(DataResourceType.LongIslandRailroad, new File("google_transit_lirr.zip")),
                DataResource.create(DataResourceType.MetroNorthRailroad, new File("google_transit_mnr.zip"))
        );



        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        System.out.println("MTA service status:");
        System.out.println("1 - SUBWAY, 2 - BUS, 3 - LIRR, 4 - METRO-NORTH");
        String input = scan.nextLine();

        Bus.Route busRoute = null;
        Subway.Route subwayRoute;
        LIRR.Route lirrRoute;
        MNR.Route mnrRoute;



        switch (parseInt(input)) {
            case 1:
                System.out.println("Enter subway line (IDs to be provided to get alerts: "); //Intent is to look through OneMTA to parse in appropriate IDs
                input = scan.nextLine();
                subwayRoute = mta.getSubwayRoute(input);
                System.out.println(subwayRoute);
            case 2:
                System.out.println("Enter borough (M for Manhattan, K for Brooklyn, Q for Queens, X for the Bronx, R for Staten Island)");
                input = scan.nextLine();
                System.out.println("What route?");
                String busRouteInput = scan.nextLine();
                switch (input) {
                    case "M":
                        busRoute = mta.getBusRoute(busRouteInput, DataResourceType.Bus_Manhattan);
                    case "K":
                        busRoute = mta.getBusRoute(busRouteInput, DataResourceType.Bus_Brooklyn);
                    case "Q":
                        busRoute = mta.getBusRoute(busRouteInput, DataResourceType.Bus_Queens);
                    case "X":
                        busRoute = mta.getBusRoute(busRouteInput, DataResourceType.Bus_Bronx);
                    case "R":
                        busRoute = mta.getBusRoute(busRouteInput, DataResourceType.Bus_StatenIsland);
                }
                System.out.println(busRoute);
            case 3:
                System.out.println("Enter LIRR route ID below.");
                input = scan.nextLine();
                lirrRoute = mta.getLIRRRoute(parseInt(input));
                System.out.println("Long Island Rail Road service alerts: " + Arrays.toString(mta.getLIRRAlerts()));
            case 4:
                System.out.println("Enter MNR route ID below.");
                input = scan.nextLine();
                mnrRoute = mta.getMNRRoute(parseInt(input));
                System.out.println("Metro North Railroad service alerts:" + Arrays.toString(mta.getMNRAlerts()));
        }

        /*
          _____   _   _ ______ ______ _____    _______ ____    _____        _____   _____ ______   _____       _______
         |_   _| | \ | |  ____|  ____|  __ \  |__   __/ __ \  |  __ \ /\   |  __ \ / ____|  ____| |  __ \   /\|__   __|/\
           | |   |  \| | |__  | |__  | |  | |    | | | |  | | | |__) /  \  | |__) | (___ | |__    | |  | | /  \  | |  /  \
           | |   | . ` |  __| |  __| | |  | |    | | | |  | | |  ___/ /\ \ |  _  / \___ \|  __|   | |  | |/ /\ \ | | / /\ \
          _| |_  | |\  | |____| |____| |__| |    | | | |__| | | |  / ____ \| | \ \ ____) | |____  | |__| / ____ \| |/ ____ \
         |_____| |_| \_|______|______|_____/     |_|  \____/  |_| /_/    \_\_|  \_\_____/|______| |_____/_/    \_\_/_/    \_\
         */



    }
}