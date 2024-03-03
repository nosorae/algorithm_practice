package godofjava.a;

public class ManageHeight {
    int[][] gradeHeights;

    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();
//        for (int i = 0; i < 5; i++) {
//            manageHeight.printHeight(i);
//        }

        int i = 0;
        while (i < 5) {
            manageHeight.printAverage(i);
            i++;
        }
    }

    public void setData() {
        gradeHeights = new int[][]{
                {170, 180, 173, 175, 177},
                {160, 165, 167, 186},
                {158, 177, 187, 176},
                {173, 182, 181},
                {170, 180, 165, 177, 172}
        };
    }

    public void printHeight(int classNo) {
        if (classNo >= gradeHeights.length) return;

        System.out.println("Class No.:" + (classNo + 1));

        for (int height : gradeHeights[classNo]) {
            System.out.println(height);
        }
    }

    public void printAverage(int classNo) {
        if (classNo >= gradeHeights.length) return;

        System.out.println("Class No.:" + (classNo + 1));

        double sum = 0.0;
        for (int height: gradeHeights[classNo]) {
            sum += (double)height;
        }

        System.out.println("Height average:" + (sum / gradeHeights[classNo].length));
    }
}
