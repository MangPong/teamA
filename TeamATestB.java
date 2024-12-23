import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TeamATestB {

    @Test
    public  void testCalculateAge() {
        int birthYear = 2000;
        int expectedAge = LocalDate.now().getYear() - 2000;

        assertEquals(expectedAge, TeamB.calculateAge(birthYear), 
            "The calculateAge method should return the correct age based on the current year.");
    }

    @Test
    void testCalculateGrade() {
        assertEquals("A", TeamB.calculateGrade(85), "Score >= 80 should return grade A");
        assertEquals("B+", TeamB.calculateGrade(75), "Score >= 75 and < 80 should return grade B+");
        assertEquals("C", TeamB.calculateGrade(60), "Score >= 60 and < 65 should return grade C");
        assertEquals("F", TeamB.calculateGrade(49), "Score < 50 should return grade F");
    }

    @Test
    void testSaveToFile() throws IOException {
        String testContent = "Name : John Doe\nAge : 23\nSoftware Testing Grade : A";
        String testFilePath = "C:/Output/TestFile.txt";

        // Call the method to save content to file
        TeamB.saveToFile(testFilePath, testContent);

        // Check if the file exists
        File testFile = new File(testFilePath);
        assertTrue(testFile.exists(), "The file should be created at the specified path.");

        // Check the file content
        String savedContent = Files.readString(Paths.get(testFilePath));
        assertEquals(testContent, savedContent, "The file content should match the input content.");

        // Clean up after test
        testFile.delete();
    }
}
