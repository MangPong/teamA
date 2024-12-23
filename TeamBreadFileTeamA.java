import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeamBreadFileTeamA {
    public static void main(String[] args) {
        String filePath = "C:/Output/Textfile.txt";

        try {
            // อ่านข้อมูลจากไฟล์
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // ดึงข้อมูลแต่ละบรรทัด
            String name = scanner.nextLine().split(": ")[1];
            int age = Integer.parseInt(scanner.nextLine().split(": ")[1]);
            String grade = scanner.nextLine().split(": ")[1];

            // แปลงอายุเป็นปีพุทธศักราช
            int buddhistEra =  age + 543 ;

            // แปลงเกรดเป็นอันดับ
            String rank = getRank(grade);

            // แสดงผลลัพธ์บน CMD
            System.out.println("Name : " + name);
            System.out.println("Buddhist Era : " + buddhistEra);
            System.out.println("Software Testing Rank : " + rank);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    // ฟังก์ชันแปลงเกรดเป็นอันดับ
    private static String getRank(String grade) {
        if (grade.equals("A")) {
            return "High Distinction";
        } else if (grade.equals("B+")) {
            return "Distinction";
        } else if (grade.equals("B")) {
            return "Distinction";
        } else if (grade.equals("C+")) {
            return "Good";
        } else if (grade.equals("C")) {
            return "Good";
        } else if (grade.equals("D+")) {
            return "Normal";
        } else if (grade.equals("D")) {
            return "Normal";
        } else {
            return "Failed";
        }
    }
}
