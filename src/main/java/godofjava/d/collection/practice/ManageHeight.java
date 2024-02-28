package godofjava.d.collection.practice;

import java.util.ArrayList;

// GodOfJava Vol2. 4장 연습문제
public class ManageHeight {
    ArrayList<ArrayList<Integer>> gradeHeights;

    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();
//        for (int i = 1; i <= 5; i++) {
//            manageHeight.printHeight(i);
//        }

        int i = 1;
        while (i <= 5) {
            manageHeight.printAverage(i);
            i++;
        }
    }

    public void setData() {
        gradeHeights = new ArrayList<>();
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(170);
        listA.add(180);
        listA.add(173);
        listA.add(175);
        listA.add(177);
        ArrayList<Integer> listB = new ArrayList<>();
        listB.add(160);
        listB.add(165);
        listB.add(167);
        listB.add(186);
        ArrayList<Integer> listC = new ArrayList<>();
        listC.add(158);
        listC.add(177);
        listC.add(187);
        listC.add(176);
        ArrayList<Integer> listD = new ArrayList<>();
        listD.add(173);
        listD.add(182);
        listD.add(181);
        ArrayList<Integer> listE = new ArrayList<>();
        listE.add(170);
        listE.add(180);
        listE.add(165);
        listE.add(177);
        listE.add(172);
        gradeHeights.add(listA);
        gradeHeights.add(listB);
        gradeHeights.add(listC);
        gradeHeights.add(listD);
        gradeHeights.add(listE);
    }

    public void printHeight(int classNo) {
        if (classNo > gradeHeights.size()) return;

        System.out.println("Class No.:" + classNo);

        for (Integer height : gradeHeights.get(classNo - 1)) {
            System.out.println(height);
        }
    }

    public void printAverage(int classNo) {
        if (classNo > gradeHeights.size()) return;

        System.out.println("Class No.:" + classNo);

        double sum = 0.0;
        for (int height: gradeHeights.get(classNo - 1)) {
            sum += height;
        }

        System.out.println("Height average:" + (sum / gradeHeights.get(classNo - 1).size()));
    }
}
