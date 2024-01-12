import dev.katsute.onemta.DataResource;
import dev.katsute.onemta.DataResourceType;
import dev.katsute.onemta.MTA;

import java.util.Scanner;
import java.io.File;



public class Main {
    public static void main(String[] args) {

        // Handling of MTA stuff
        String busToken = "";
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
        System.out.println("1 - SUBWAY, 2 - LIRR, 3 - METRO-NORTH");
        int input = scan.nextInt();

        switch (input) {
            case 1:
                System.out.println("Enter subway line (IDs to be provided"); //Intent is to look through OneMTA to parse in appropriate IDs

        }

    }
}