package Project.application.test;/*
package test;

import function.FileWrite;
import Item.Item;
import Item.ItemWithDueDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadableTest {


    FileWrite fileWrite = new FileWrite();
    Item item1 = new ItemWithDueDate("210", "assignment","181010", "yes");
    Item item2 = new ItemWithDueDate("121", "midterm study", "181015", "no");
    List<String> lines = Files.readAllLines(Paths.get("outputItems.txt"));


    public LoadableTest() throws IOException {
    }


    @BeforeEach
    public void setUP() throws IOException {
        fileWrite.saveItem(item1.getItemStr(),"outputItems.txt");
        fileWrite.saveItem(item2.getItemStr(),"outputItems.txt");
    }

    @Test
    public void testLoad() throws IOException {
        fileWrite.load("outputItems.txt");
        assertEquals(item1.getItemStr(),lines.get(lines.size()-2));
        assertEquals(item2.getItemStr(),lines.get(lines.size()-1));

        assertTrue(lines.contains(item1.getItemStr()));
        assertTrue(lines.contains(item2.getItemStr()));
    }

    */
/*@Test
    public void printItemByCourse(String index) throws IOException{
        fileWrite.printItemByCourse(index);
        assertEquals(fileWrite.printItemByCourse(index).;

    }

    @Test
    public void browseImportantItem() throws IOException{

    }*//*

}

*/
