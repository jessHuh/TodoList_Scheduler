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

public class testItem {

    Item item;
    List<String> lines = Files.readAllLines(Paths.get("outputItems.txt"));
    FileWrite fileWrite = new FileWrite();

    public testItem() throws IOException {
    }


    @BeforeEach
    public void setUp() throws IOException {
        item = new ItemWithDueDate("210","Project demo","181010","yes");

    }

    @Test
    public void testGetItemStr(){
        assertEquals(("210" + "," +  "Project demo" + "," + "181010" + "," + "yes"),item.getItemStr());
    }


}
*/
