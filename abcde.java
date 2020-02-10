import java.util.Arrays;


public class abcde {    
    static String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    static char[][] marks = { {'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
                                    {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
                                    {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
                                    {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'} }; // mark for ICT2669
    static String grade = "ABCDEF";
    static char A = grade.charAt(0);
    static char B = grade.charAt(1);
    static char C = grade.charAt(2);
    static char D = grade.charAt(3);
    static char E = grade.charAt(4);
    static char F = grade.charAt(5);

        public static void main(String[] args) {
            int q, w = 0;
            for (q = 0; q < marks.length; q++) {
                for(w = 0; w < marks[q].length; w++) {}
            }
            int[][] i_marks = new int[q][w];
            i_marks = itoch(q, w);

            if(args.length != 2) {
                System.out.println("-  Usage: java Main {average | median | beststudent} <module code>");
            }

            if(args[0] != "median" && args[0] != "average" && args[0] != "beststudent") {
                System.out.println("-  Usage: java Main {average | median | beststudent} <module code>");
            }

            if("beststudent".equals(args[0])) {
                    if(beststudent(args[1], i_marks).length == 0) {
                        System.out.println("Can't find module from data : " + args[1]);
                    }else {
                        System.out.println("In module " + args[1] + ", the following students perform the best:");
                        String[] bs = new String[beststudent(args[1], i_marks).length];
                        bs = beststudent(args[1], i_marks);
                        for(int p = 0; p < bs.length; p++) {
                            System.out.println("Student " + bs[p]);
                        }
                    }
            }

            if("average".equals(args[0])) {
                double checkcalc = calcAverage(args[1], i_marks);
                if(checkcalc == 999999.99) {
                    System.out.println("Can't find module from data : " + args[1]);
                }else {
                    System.out.println("The average mark of " + args[1] + " = " + checkcalc);
                }
            }

            if("median".equals(args[0])) {
                double checkcalc = calcMedian(args[1], i_marks);
                if(checkcalc == 999999.99) {
                    System.out.println("Can't find module from data : " + args[1]);
                }else {
                    System.out.println("The Median of module " + args[1] + " = " + checkcalc);
                }
            }

        }

        private static double calcMedian(String mCode, int[][] i_marks) {
            for(int i = 0; i < moduleCode.length; i++) {
                if(moduleCode[i].equals(mCode)) {
                    if(i_marks[i].length%2 ==1) {
                        Arrays.sort(i_marks[i]);
                        return i_marks[i][(i_marks[i].length-1)/2];
                    }else {
                        Arrays.sort(i_marks[i]);
                        return ((double)i_marks[i][i_marks[i].length/2] + (double)i_marks[i][(i_marks[i].length/2)-1]);
                    }
                }
            }
            return 999999.99;
        }

        private static double calcAverage(String mCode, int[][] i_marks) {
            double calc = 0.0;
            int q = 0;
            for(int i = 0; i < moduleCode.length; i++) {
                if(moduleCode[i].equals(mCode)) {
                    for(q = 0; q < i_marks[i].length; q++) {
                        calc += i_marks[i][q];
                    }
                    return calc = calc/q;
                }
            }
            return 999999.99;
        }

        private static String[] beststudent(String mCode, int[][] i_marks) {
            String[] bStrings = {};
            for(int i = 0; i < moduleCode.length; i++) {
                if(moduleCode[i].equals(mCode)) {
                    int k = getbestpos(i_marks[i]).length;
                    int[] bp = new int[k];
                    bp = getbestpos(i_marks[i]);
                    for(int o = 0; o < bp.length; o++) {
                        bStrings = S_addElement(bStrings, studentID[bp[o]]);
                    }
                    return bStrings;
                }
            }
            return bStrings;
        }

        public static boolean contains(int[] arr, int item) {
            for(int n : arr) {
                if(item == n) {
                    return true;
                }
            }
            return false;
        }

        static int[] addElement(int[] a, int e) {
            a = Arrays.copyOf(a, a.length +1);
            a[a.length -1] = e;
            return a;
        }
        static String[] S_addElement(String[] a, String e) {
            a = Arrays.copyOf(a, a.length +1);
            a[a.length -1] = e;
            return a;
        }

        private static int[] getbestpos(int[] i_module_marks) {
            int[] i = {};
            if(contains(i_module_marks, 5)) {
                for(int j = 0; j < i_module_marks.length; j++) {
                    if(i_module_marks[j] == 5) {
                        i = addElement(i, j);
                    }
                }
                return i;
            }
            if(contains(i_module_marks, 4)) {
                for(int j = 0; j < i_module_marks.length; j++) {
                    if(i_module_marks[j] == 4) {
                        i = addElement(i, j);
                    }
                }
                return i;
            }
            if(contains(i_module_marks, 3)) {
                for(int j = 0; j < i_module_marks.length; j++) {
                    if(i_module_marks[j] == 3) {
                        i = addElement(i, j);
                    }
                }
                return i;
            }
            if(contains(i_module_marks, 2)) {
                for(int j = 0; j < i_module_marks.length; j++) {
                    if(i_module_marks[j] == 2) {
                        i = addElement(i, j);
                    }
                }
                return i;
            }
            if(contains(i_module_marks, 1)) {
                for(int j = 0; j < i_module_marks.length; j++) {
                    if(i_module_marks[j] == 1) {
                        i = addElement(i, j);
                    }
                }
                return i;
            }
            if(contains(i_module_marks, 0)) {
                for(int j = 0; j < i_module_marks.length; j++) {
                    if(i_module_marks[j] == 0) {
                        i = addElement(i, j);
                    }
                }
                return i;
            }
            return i;
        }

        private static int[][] itoch(int q, int w) {
            int[][] f_marks = new int[q][w];
            for(int t = 0; t < marks.length; t++) {
                for(int y = 0; y < marks[t].length; y++) {
                    if(marks[t][y] == A) {
                        f_marks[t][y] = 5;
                    }
                    if(marks[t][y] == B) {
                        f_marks[t][y] = 4;
                    }
                    if(marks[t][y] == C) {
                        f_marks[t][y] = 3;
                    }
                    if(marks[t][y] == D) {
                        f_marks[t][y] = 2;
                    }
                    if(marks[t][y] == E) {
                        f_marks[t][y] = 1;
                    }
                    if(marks[t][y] == F) {
                        f_marks[t][y] = 0;
                    }
                }
            }
            return f_marks;
        }
}
