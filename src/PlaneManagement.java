import java.util.*;
public class PlaneManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Plane Management application");
        int[][] jaggedArray = new int[4][];

        jaggedArray[0] = new int[14];
        jaggedArray[1] = new int[12];
        jaggedArray[2] = new int[12];
        jaggedArray[3] = new int[14];

        int[][] ticketsSold = new int[4][];

        ticketsSold[0] = new int[14];
        ticketsSold[1] = new int[12];
        ticketsSold[2] = new int[12];
        ticketsSold[3] = new int[14];
        
        do {
        System.out.println("***************************************************");
        System.out.println("*                      MENU                       *");
        System.out.println("***************************************************");
        System.out.println("     1) Buy a seat");
        System.out.println("     2) Cancel a seat");
        System.out.println("     3) Find first available seat");
        System.out.println("     4) Show seating plan");
        System.out.println("     5) Print ticket information and total sales");
        System.out.println("     6) Search ticket");
        System.out.println("     0) Quit");
        System.out.println("***************************************************");

        int choice;

            choice = validity();
            switch (choice) {
                case 1:
                    int row_num = rowcheck();
                    int column = coloumncheck();
                    buy_seat(jaggedArray, row_num, column);
                    break;
                case 2:
                    row_num = rowcheck();
                    column = coloumncheck();
                    cancel_seat(jaggedArray, row_num,column);
                    break;
                case 3:
                    find_first_available(jaggedArray);
                    break;
                case 4:
                    show_seating_plan(jaggedArray);
                    break;
                case 5:
                    System.out.println("Empty");
                    break;
                case 0:
                    System.exit(0);
            }
            for (int[] row : jaggedArray) {
                for (int column : row) {
                    if (column == 1) {
                        System.out.print("x");
                    } else {
                        System.out.print("o");
                    }
                }
                System.out.println();
            }
        }while (true);
    }

    public static void buy_seat(int[][] jaggedArray, int row_num, int column) {
        if ((row_num >= 0 && row_num < jaggedArray.length) && (column >= 0 && column < jaggedArray[row_num].length)) {
            if (jaggedArray[row_num][column] == 0) {
                jaggedArray[row_num][column] = 1;
                System.out.println("Seat booked successfulley");
            } else {
                System.out.println("Seat already booked");
            }
        } else {
            System.out.println("Invalid row or column");
        }
    }
    public static int validity(){
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.print("Please select an option: ");
                choice = input.nextInt();
                if((choice>=0)&&(choice<=6)){
                    break;
                }else{
                    System.out.println("Invalid input, please select from the available options");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter proper data type");
                input.nextLine();
            }
        }
        return choice;
    }

    public static int rowcheck() {
        Scanner input = new Scanner(System.in);
        String row;
        while (true) {
            try {
                System.out.print("Enter seat row: ");
                row = input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a letter");
                input.next();
            }
        }
        int row_num = -1;
        if (row.equalsIgnoreCase("A")) {
            row_num = 0;
        } else if (row.equalsIgnoreCase("B")) {
            row_num = 1;
        } else if (row.equalsIgnoreCase("C")) {
            row_num = 2;
        } else if (row.equalsIgnoreCase("D")) {
            row_num = 3;
        } else {
            System.out.println("Invalid Input");
        }
        System.out.println(row_num);
        return row_num;
    }

    public static int coloumncheck(){
        Scanner input = new Scanner(System.in);
        int column;
        while (true){
            try {
                System.out.print("Enter seat coloumn ");
                column = input.nextInt() - 1;
                if (column >= 0 && column < 14){
                    break;
                } else {
                    System.out.println("Seat column is out of range");
                }

            }catch (InputMismatchException e){
                System.out.println("Please Enter a number");
                input.nextLine();
            }
        }
        return column;

    }
    public static void cancel_seat(int[][] jaggedArray,int row_num,int column) {
        if ((row_num >= 0 && row_num < jaggedArray.length) && (column >= 0 && column < jaggedArray[row_num].length)) {
            if (jaggedArray[row_num][column] == 1) {
                jaggedArray[row_num][column] = 0;
                System.out.println("Seat cancelled successfulley");
            } else {
                System.out.println("Seat is not booked");
            }
        } else {
            System.out.println("Invalid row or column");
        }
    }
    public static void find_first_available(int[][] jaggedArray) {
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                if (jaggedArray[i][j] == 0) {
                    jaggedArray[i][j] = 1;
                    System.out.println("Seat booked successfully");
                    return;
                }
            }
        }
        System.out.println("No available seats");
    }
        public static void show_seating_plan(int[][] jaggedArray){
            for (int[] row : jaggedArray) {
                for (int col : row) {
                    if (col == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
                System.out.println();
                System.out.println();
            }
        }

}


