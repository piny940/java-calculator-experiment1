import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class MyLecture2 {
    public void convert(String inputFilename, String outputFilename) {
        String[] courseNames = this.readLines(inputFilename);
        String[] data = this.toData(courseNames);
        this.outputLines(outputFilename, data);
    }

    private String[] toData(String[] courseNames) {
        String[] courseData = new String[courseNames.length];

        for (Integer i = 0; i < courseNames.length; i++) {
            String courseName = courseNames[i];
            String courseTime = this.getCourseTime(courseName);
            courseData[i] = courseTime + "\t" + courseName;
        }

        return courseData;
    }

    private String[] readLines(String inputFilename) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File inputFile = new File(inputFilename);
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNext()) {
                String line = scanner.next();
                lines.add(line);
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        
        return lines.toArray(new String[lines.size()]);
    }

    private void outputLines(String outputFilename, String[] lines) {
        try {
            File outputFile = new File(outputFilename);
            FileWriter writer = new FileWriter(outputFile);
            for (Integer i = 0; i < lines.length; i++) {
                writer.write(lines[i] + "\n");
            }

            writer.close();
        }
        catch (IOException ex) {
            System.out.println("Failed to write file");
            System.exit(0);
        }
    }

    private String getCourseTime(String courseName) {
        switch (courseName) {
            case "線形代数学続論":
                return "Mo2";
            case "データベース":
                return "Mo3";
            case "情報と社会":
                return "Mo5";
            case "情報符号理論":
                return "Tu1";
            case "微分積分学続論II":
                return "Tu2";
            case "西洋史":
                return "Tu5";
            case "電気電子回路入門":
                return "We1";
            case "論理システム":
                return "We2";
            case "計算機科学実験及演習":
                return "We3";
            case "確率論基礎":
                return "Th1";
            case "日本国憲法":
                return "Th2";
            case "微分積分学続論I":
                return "Th3";
            case "計算機科学のための数学演習":
                return "Th4";
            case "倫理学I":
                return "Fr4";
            case "社会学I":
                return "Fr5";
            default:
                System.out.println("Course name not registered");
                System.exit(0);
                return "";
        }
    }
}
