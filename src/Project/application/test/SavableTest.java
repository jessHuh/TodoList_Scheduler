package Project.application.test;/*
package test;

import function.FileWrite;
import Item.Item;
import Item.ItemWithDueDate;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavableTest {

    FileWrite savable = new FileWrite();
    Item item1 = new ItemWithDueDate("210", "assignment","181010", "yes");
    Item item2 = new ItemWithDueDate("121", "midterm study", "181015", "no");

    public SavableTest() throws IOException {
    }

    */
/*@Test
    public void testSave() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputItems.txt"));
        Integer linesSize = lines.size();
        savable.saveItem(item1.getItemStr(),"outputItems.txt");
        savable.saveItem(item2.getItemStr(),"outputItems.txt");
        List<String> lines2 = Files.readAllLines(Paths.get("outputItems.txt"));

        assertEquals(lines2.get(lines2.size()-2),item1.getItemStr());
        assertEquals(lines2.get(lines2.size()-1),item2.getItemStr());

        assertEquals(lines2.size(),linesSize+2);
    }*//*


}
*/
