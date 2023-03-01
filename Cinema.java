                                   
package Cinema;

import java.util.*;

public class Cinema {
    static Scanner sc = new Scanner(System.in);

    public static int askForRow() {
        System.out.println("Enter the number of rows:");
        int rows = sc.nextByte();
        if (rows == 0) {
            System.out.println("Wrong number");
            return 1;
        }
            return rows;
    }

    public static int askForSeats() {
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextByte();
        if (seats == 0) {
            System.out.println("Wrong number");
            return 1;
        }
        return seats;
    }

    public static void fillArray(char[][] screenRoom) {
        for (char[] row : screenRoom) {
            Arrays.fill(row, 'S');
        }
    }

    public static int getRowNumber(int rows) {
        int rowNumber;
        do {
            System.out.println("Enter a row number:");
            rowNumber = sc.nextInt();
            if (rowNumber > rows || rowNumber <= 0) {
                System.out.println("Wrong input!");
            }
        } while (rowNumber > rows || rowNumber <= 0);
        return rowNumber;
    }

    public static int getSeatNumber(int seats) {
        int seatNumber; //= sc.nextInt();
        do {
            System.out.println("Enter a seat number in that row:");
            seatNumber = sc.nextInt();
            if (seatNumber > seats || seatNumber <= 0) {
                System.out.println("Wrong input!");
            }
        } while (seatNumber > seats || seatNumber <= 0);
        return seatNumber;
    }

    public static void printScreenRoom(int rows, int seats, char[][] screenRoom) {
        char s = 'S';
        char b = 'B';
        System.out.print("Cinema:\n ");

        for (int i = 1; i <= seats; ++i) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; ++i) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; ++j) {
                System.out.print(" " + screenRoom[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int buyATicket(int rows, int seats, int ticketPrice, int rowNumber, int seatNumber, char[][] screenRoom) {
        int totalSeats = rows * seats;
        int front = rows / 2;
        int back = rows - front;
        ticketPrice = totalSeats < 60 ? 10 :
                rowNumber > front ? 8 : 10;
        if (screenRoom[rowNumber - 1][seatNumber - 1] ==  'B') {
            do {
                System.out.println("That ticket has already been purchased!");
                rowNumber = getRowNumber(rows);
                seatNumber = getSeatNumber(seats);
            } while (screenRoom[rowNumber - 1][seatNumber - 1] != 'S');
            ticketPrice = totalSeats < 60 ? 10 :
                    rowNumber > front ? 8 : 10;
            System.out.println("Ticket price: $" + ticketPrice);
            return screenRoom[rowNumber - 1][seatNumber - 1] = 'B';

        }
        System.out.println("Ticket price: $" + ticketPrice);
        return ticketPrice;
    }

    public static void getPercentage(int inNumber, int rows, int seats) {
        float percentage = (float)inNumber / (((float)rows * (float)seats) / 100);
        if (((float)rows * (float)seats) / 100 == 0) {
            System.out.println("0.00%");
        } else {
            System.out.printf("Percentage: %.2f%%%n", percentage);
        }
    }

    public static void totalIncome(int rows, int seats) {
        int totalSeats = rows * seats;
        int totalIncome;
        int front;
        int back;
        if (totalSeats < 60) {
            totalIncome = totalSeats * 10;
        } else if (totalSeats >= 60 && rows % 2 != 0) {
            front = (rows / 2) * seats;
            back = ((rows + 1) / 2) * seats;
            totalIncome = (front * 10) + (back * 8);
        } else {
            front = (rows / 2) * seats;
            back = front;
            totalIncome = (front * 8) + (back * 10);
        }
        System.out.printf("Total income: $%s%n%n", totalIncome);
    }

    public static void mainMenu() {
        int choose = 1;
        int rows = askForRow();
        int seats = askForSeats();
        int currentIncome = 0;
        int ticketPrice = 0;
        int numberOfPurchasedTickets = 0;
        char[][] screenRoom = new char[rows][seats];
        fillArray(screenRoom);
        while (choose != 0) {
            System.out.println("""
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistic
                    0. Exit
                    """);
            switch (choose = sc.nextInt()) {
                case 1:
                    printScreenRoom(rows, seats, screenRoom);
                    break;
                case 2:
                    int rowNumber = getRowNumber(rows);
                    int seatNumber = getSeatNumber(seats);
                    currentIncome += buyATicket(rows,seats,ticketPrice, rowNumber, seatNumber, screenRoom);
                    screenRoom[rowNumber - 1][seatNumber - 1] = 'B';
                    numberOfPurchasedTickets ++;
                    break;
                case 3:
                    System.out.printf("Number of purchased tickets: %d%n", numberOfPurchasedTickets);
                    getPercentage(numberOfPurchasedTickets, rows, seats);
                    System.out.printf("Current Income $%s%n", currentIncome);
                    totalIncome(rows, seats);
                case 0:
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
