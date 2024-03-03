package godofjava.e.io.practice;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// GodOfJava Vol2. 8장 연습문제
public class FileSizeSummary {
    public static void main(String[] args) {
        FileSizeSummary sample = new FileSizeSummary();
        String path = "/Users/yessorae/IdeaProjects/algorithm_practice/src/main/java/godofjava";
        long sum = sample.printDirectorySize(path);
        System.out.println(path + "'s total size=" + convertFileLength(sum));
    }

    public long printDirectorySize(String dirName) {
        File dir = new File(dirName);
        long sum = 0;
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file: files) {
                if (file.isDirectory()) {
                    sum += printDirectorySize(file.getPath());
                    System.out.println(dirName + " 디렉토리 사이즈: " + convertFileLength(sum));
                } else {
                    sum += file.length();
//                    System.out.println(dirName + " 파일 사이즈: " + convertFileLength(sum));
                }
            }
        }
        return sum;
    }

    private static String convertFileLength(long fileLength) {
        double unit = 1024;
        NumberFormat format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(2);

        if (fileLength <= unit) {
            return fileLength + " b";
        }

        if (fileLength <= unit * unit) {
            return format.format(fileLength / unit) + " kb";
        }

        if (fileLength <= unit * unit * unit) {
            return fileLength / unit / unit + " mb";
        }

        return fileLength / unit / unit / unit + " gb";
    }
}