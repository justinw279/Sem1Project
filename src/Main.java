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
import java.lang.Thread;
import java.io.*;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Push ENTER when you're ready.");
        // API access keys
        final String BUS_TOKEN = "9505ac3a-8606-472c-b8d9-be440ee0b4bc";
        final String SUBWAY_TOKEN = "jqIP5yUzKL8kCHomCgdha7i3yjhnCU9882FvbMOG";
        // Required variables to connect to MTA API
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        // MTA class used to access the API
        MTA mta = MTA.create(
                BUS_TOKEN,
                SUBWAY_TOKEN,
                DataResource.create(DataResourceType.Bus_Bronx, new File("src\\google_transit_bronx.zip")),
                DataResource.create(DataResourceType.Bus_Brooklyn, new File("src\\google_transit_brooklyn.zip")),
                DataResource.create(DataResourceType.Bus_Manhattan, new File("src\\google_transit_manhattan.zip")),
                DataResource.create(DataResourceType.Bus_Queens, new File("src\\google_transit_queens.zip")),
                DataResource.create(DataResourceType.Bus_StatenIsland, new File("src\\google_transit_staten_island.zip")),
                DataResource.create(DataResourceType.Bus_Company, new File("src\\google_transit_bus_company.zip")),
                DataResource.create(DataResourceType.Subway, new File("src\\google_transit_subway.zip")),
                DataResource.create(DataResourceType.LongIslandRailroad, new File("src\\google_transit_lirr.zip")),
                DataResource.create(DataResourceType.MetroNorthRailroad, new File("src\\google_transit_mnr.zip")));

        clearScreen();
        System.out.println("TransitInfo:");
        System.out.println("1 - SUBWAY, 2 - BUS, 3 - LIRR");
        String input = scan.nextLine();


        // Class variables
        BusData busData = new BusData(mta);
        LIRRData lirrData = new LIRRData(mta);
        SubwayData subwayData = new SubwayData(mta);

        // UI input
        if (parseInt(input) == 1) {
            System.out.println("What would you like to do?\n1. Get all vehicles of a subway line\n2. Get upcoming trains for a stop");
            input = scan.nextLine();
            clearScreen();
            switch (input) {
                case "1":
                    System.out.println("Enter subway line to get vehicles (eg. 1, 2, 3, 7, E, F, M, R, SI): ");
                    String nextInput = scan.nextLine();
                    clearScreen();
                    subwayData.displaySubwayVehicles(nextInput);
                    break;
                case "2":
                    System.out.println("Enter subway stop ID (try 631 as an example for Grand Central (456)!): ");
                    nextInput = scan.nextLine();
                    clearScreen();
                    subwayData.subwayStopInformation(nextInput);
                    break;
            }
        } else if (parseInt(input) == 2) {
            System.out.println("What would you like to do?\n1. Get info for a bus route\n2. Get upcoming buses for a bus stop");
            input = scan.nextLine();
            clearScreen();
            switch (input) {
                case "1":
                    System.out.println("Which route? (eg. Q88, B6, M15-SBS, Bx12, S93)");
                    String busRouteInput = scan.nextLine();
                    clearScreen();
                    busData.busRouteInformation(busRouteInput);
                    break;
                case "2":
                    System.out.println("Enter bus stop ID to get vehicles information (try 504480 as an example!): ");
                    input = scan.nextLine();
                    clearScreen();
                    busData.busStopInformation(input);
                    break;
            }
        } else if (parseInt(input) == 3) {
            System.out.println("What would you like to do?\n1. Get route information and trains\n2. Get station information\n3. Get information about a running train");
            input = scan.nextLine();
            scan.reset();
            clearScreen();
            switch (input) {
                case "1":
                    LIRRData.displayIDToLineConversion();
                    System.out.println("Which route would you like to get information and vehicles from? Remember to use the route ID!");
                    int lirrInput = scan.nextInt();
                    clearScreen();
                    lirrData.getRouteInformation(lirrInput);
                    break;
                case "2":
                    System.out.println("Which station would you like to check? Use the internal station ID at https://github.com/errornil/mta/blob/main/lirr.md.");
                    System.out.println("Example: 1 for Albertson");
                    lirrInput = scan.nextInt();
                    clearScreen();
                    lirrData.getStationInformation(lirrInput);
                    break;
                case "3":
                    System.out.println("Enter a train number:");
                    lirrInput = scan.nextInt();
                    clearScreen();
                    try {
                        lirrData.getTrainInformation(lirrInput);
                    } catch (Exception e) {
                        System.out.println("No such train found.");
                    }
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}