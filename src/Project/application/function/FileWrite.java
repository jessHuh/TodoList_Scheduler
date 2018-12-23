package Project.application.function;

import Project.application.Item.ItemWithDueDate;
import Project.application.Item.ItemWithoutDueDate;
import Project.application.Item.Item;
import Project.application.Item.ItemManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWrite {

    public FileWrite() {
    }

   /* public void saveItem(String item, String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        PrintWriter pw = new PrintWriter(file, "UTF-8");
        lines.add(item);
        for (String line : lines) {
            pw.println(line);
        }
        pw.close();
    }*/

    public void saveItemMap(ItemManager itemManager, String file) throws IOException {
        //file = "outputItems.txt";
        List<String> lines = new ArrayList<>();
        PrintWriter pw = new PrintWriter(file, "UTF-8");
        for(String key : itemManager.getKey()) {
            for (int i = 0; i < itemManager.getSize(key); i++) {
                lines.add(itemManager.getItem(key, i).getItemStr());
            }
        }
            for (String line : lines) {
                pw.println(line);
            }
            pw.close();
        }



   /* public void delete(Integer number, String file) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(file));
        PrintWriter pw = new PrintWriter(file, "UTF-8");
        lines.remove(number-1);
        System.out.println("Okay, deleted it");
        for (String line : lines) {
            pw.println(line);
        }
        pw.close();
    }*/

    public void load(String file, ItemManager itemManager) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitsOnComma(line);
            String key = partsOfLine.get(0);
            if(! itemManager.containKey(key)){
                itemManager.addKey(key);}
            if (partsOfLine.get(2).substring(0, 1).equals("N")) {
                Item item1 = new ItemWithoutDueDate(partsOfLine.get(0), partsOfLine.get(1), partsOfLine.get(2), partsOfLine.get(3));
                itemManager.addItemFromLoad(key,item1);
            } else {
                Item item2 = new ItemWithDueDate(partsOfLine.get(0), partsOfLine.get(1), partsOfLine.get(2), partsOfLine.get(3));
                itemManager.addItemFromLoad(key,item2);
            }
            /*System.out.print(lines.indexOf(line)+k1 + ") ");
            System.out.print("Course: " + partsOfLine.get(0)+ " ");
            System.out.print("Detail: " + partsOfLine.get(1)+ " ");
            if(partsOfLine.get(2).substring(0,1).equals("N")){
                System.out.print("Deadline: " + partsOfLine.get(2) + " ");
            }
            else {
                System.out.print("Deadline: "
                        + partsOfLine.get(2).substring(0, 2) + "-"
                        + partsOfLine.get(2).substring(2, 4) + "-"
                        + partsOfLine.get(2).substring(4, 6) + " ");
            }
            System.out.println("Important?: " + partsOfLine.get(3));*/
        }
    }

    public static ArrayList<String> splitsOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}

    /*public void loadItemsByCourse(String index, String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitsOnComma(line);
            if (partsOfLine.get(0).equals(index)) {
                    System.out.print(lines.indexOf(line)+1 + ") ");
                    System.out.print("Course: " + partsOfLine.get(0) + " ");
                    System.out.print("Detail: " + partsOfLine.get(1) + " ");
                    if(partsOfLine.get(2).substring(0,1).equals("N")){
                        System.out.print("Deadline: " + partsOfLine.get(2) + " ");
                    }
                    else {
                        System.out.print("Deadline: "
                                + partsOfLine.get(2).substring(0, 2) + "-"
                                + partsOfLine.get(2).substring(2, 4) + "-"
                                + partsOfLine.get(2).substring(4, 6) + " ");
                    }
                    System.out.println("Important?: " + partsOfLine.get(3));

                    Item item = new ItemWithDueDate();
            }
        }*/
   // }

    /*public void browseImportantItem(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitsOnComma(line);
            if (partsOfLine.get(3).equals("yes")) {
                System.out.print(lines.indexOf(line)+1 + ") ");
                System.out.print("Course: " + partsOfLine.get(0)+ " ");
                System.out.print("Detail: " + partsOfLine.get(1)+ " ");
                if(partsOfLine.get(2).substring(0,1).equals("N")){
                    System.out.print("Deadline: " + partsOfLine.get(2) + " ");
                }
                else {
                    System.out.print("Deadline: "
                            + partsOfLine.get(2).substring(0, 2) + "-"
                            + partsOfLine.get(2).substring(2, 4) + "-"
                            + partsOfLine.get(2).substring(4, 6) + " ");
                }
                System.out.println("Important?: " + partsOfLine.get(3));
            }
        }
    }*/







