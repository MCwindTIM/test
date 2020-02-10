import java.util.Arrays;


public class Main {
    static String[] moduleCode = {"ITD2322", "ITD2422", "ITD2321", "ICT2669"};
    static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    static int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
                            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
                            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
                            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

        public static void main(String[] args) {
            if(args.length != 2) {
                System.out.println("-  Usage: java Main {average | median | beststudent} <module code>");
            }
            if(args[0] != "median" && args[0] != "average" && args[0] != "beststudent") {
                System.out.println("-  Usage: java Main {average | median | beststudent} <module code>");
            }

            if("average".equals(args[0])) {
                double checkcalc = calcModuleAverageMark(args[1]);
                if(checkcalc == 999999) {
                    System.out.println("Can't find module from data : " + args[1]);
                }else {
                System.out.println("The average mark of " + args[1] + " = " + checkcalc);
                }
            }

            if("median".equals(args[0])) {
                double checkmedian = calcModuleMedianMark(args[1]);
                if(checkmedian == 999999.99) {
                    System.out.println("Can't find module from data : " + args[1]);
                }else {
                    System.out.println("The Median of module " + args[1] + " = " + checkmedian);
                }
            }

            if("beststudent".equals(args[0])) {
                int checkbs = getModuleBeststudent(args[1]);
                if(checkbs == 999999 || checkbs == -1) {
                    System.out.println("Can't find module from data : " + args[1]);
                }else {
                    System.out.println("In module " + args[1] + ", the following students perform the best:");
                    System.out.println("Student " + studentID[checkbs]);
                }

            }

        }

        public static int getIndexOfLargest(int[] array) {
            if(array == null || array.length == 0) return -1;

            int largest = 0;
            for(int i = 1; i < array.length; i++) {
                if(array[i] > array[largest]) largest = i;
            }

            return largest;

        }

        private static int getModuleBeststudent(String mCode) {
            for(int i = 0; i < moduleCode.length; i++) {
                if(moduleCode[i].equals(mCode)) {
                 return getIndexOfLargest(marks[i]);
                }
            }
            return 999999;
        }

        private static double calcModuleAverageMark(String mCode) {
            double calc = 0.0;
            int q = 0;
            for(int i = 0; i < moduleCode.length; i++) {
                if(moduleCode[i].equals(mCode)) {
                    for(q = 0; q < marks[i].length; q++) {
                        calc += marks[i][q];
                    }
                    return calc = calc/q;
                }
            }
            return 999999.99;
        }

        private static double calcModuleMedianMark(String mCode) {
            for(int i = 0; i < moduleCode.length; i++) {
                if(moduleCode[i].equals(mCode)) {
                    if(marks[i].length%2 == 1) {
                        Arrays.sort(marks[i]);
                        return marks[i][(marks[i].length-1)/2];
                    }else {
                        Arrays.sort(marks[i]);
                        return ((double)marks[i][marks[i].length/2] + (double)marks[i][(marks[i].length/2)-1]) / 2;
                    }
                }
            }
            return 999999.99;
        }
}
