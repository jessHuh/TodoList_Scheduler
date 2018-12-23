package Project.application.Item;

import exception.outBoundException;
import function.FileWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListOfItems {

    Map<String, ArrayList<Item>> itemHashMap = new HashMap<>();
    FileWrite fileWrite = new FileWrite();
    private ImportantItem listOfImportantItems;
    // may a bit red
    public ListOfItems() throws IOException {
        addIndex("210");
        addIndex("121");
        addIndex("302");
        addIndex("200");
    }

    private    void addIndex(String key){
        itemHashMap.put(key, new ArrayList<>());
    }
    public void addItem(Item item) {
            ArrayList<Item> items = itemHashMap.get(item.getTittle());
            items.add(item);

            if(item.getImportance().equals("yes")) {
                if (listOfImportantItems == null) {
                    listOfImportantItems = new ImportantItem();
                    listOfImportantItems.setListOfItems(this);
                }

                if (listOfImportantItems != null && !listOfImportantItems.getValue(item.getTittle()).contains(item)) {
                    listOfImportantItems.addItem(item);
                }
            }
    }

    /*public void addImportantItem(Item item) {
        if (!listOfImportantItems.getValue(item.getImportance()).contains(item)) {
            listOfImportantItems.addItem(item);
            ArrayList<Item> items = itemHashMap.get(item.getTittle());
            items.add(item);
        }
    }*/


    /*public void addDate(Date d){
        if(! dates.contains(d)){
            dates.add(d);
            ArrayList<Item> items = itemHashMap.get(d.);
            items.add(item);
        }
    }*/

    public Integer getSize(String key){
        return itemHashMap.get(key).size();
    }

    // TODO: handle item does not exist exception
    // TODO: a check that the integer is not null before casting
    public Item getItem(String course, Integer i){
        return itemHashMap.get(course).get(i);
    }

    public Set<String> getKey(){
       return itemHashMap.keySet();
    }

    public ArrayList<Item> getValue(String index){
        return itemHashMap.get(index);
    }

    //public void saveLisOfItems(ListOfItems listOfItems, String file) throws IOException{
    //    fileWrite.saveItemMap(listOfItems,file);

    //}



    /*public void loadListOfItems(String file) throws IOException{
        itemHashMap = Files.readAllLines(Paths.get(file));
        fileWrite.load(file);
    }*/

    public void printAllItems(){
        for (String key: itemHashMap.keySet()) {
            System.out.println("Index : " + key);
            for(Item item  : itemHashMap.get(key)){
                    System.out.print(itemHashMap.get(key).indexOf(item) + " ");
                    System.out.print("Course: " + item.getTittle() + " ");
                    System.out.print("Detail: " + item.getDetail() + " ");

                    System.out.print("Deadline: " + item.getDueDate() + " ");

                    System.out.println("Important?: " + item.getImportance());
                }
            }
        }

        /*for(Item item : itemHashMap){
            System.out.print(itemHashMap.indexOf(item) + " ");
            System.out.print("Course: " + item.getTittle() + " ");
            System.out.print("Detail: " + item.getDetail() + " ");
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(item.getDueDate().getTime());
            System.out.print("Deadline: " + formatted + " ");
            System.out.println("Important?: " + item.getImportance());
        }*/


    public void printItemByCourse(String course) throws IOException{
        for(Item item  : itemHashMap.get(course)){
            if(item.getTittle().equals(course)){
                System.out.print(itemHashMap.get(course).indexOf(item) + " ");
                System.out.print("Course: " + item.getTittle() + " ");
                System.out.print("Detail: " + item.getDetail() + " ");
                System.out.print("Deadline: " + item.getDueDate() + " ");
                System.out.println("Important?: " + item.getImportance());
            }
        }
    }

    public void loadItemsByImportance() throws IOException{
        listOfImportantItems.printImportantItem();
        /*for(String key : itemHashMap.keySet()){
            for(Item item : itemHashMap.get(key)){
                if(item.getImportance().equals("yes")){
                    System.out.print("Course: " + item.getTittle()+ " ");
                    System.out.print("Detail: " + item.getDetail()+ " ");
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    String formatted = format1.format(item.getDueDate());
                    System.out.print("Deadline: " + formatted + " ");
                    System.out.println("Important?: " + item.getImportance());
                }
            }
        }*/
    }

    //  TODO: maybe use an exception if the item does not exist
    public void deleteItem(String course, Integer i) throws outBoundException {
        /*if (i == null) {
            return;
        } else {
            int j = i;
            itemHashMap.remove(j);
        }*/
        if(i >= itemHashMap.get(course).size()){
            throw new outBoundException();
        }

        itemHashMap.get(course).remove(i);

        //deleteImportantItem(itemHashMap.get(tittle).get(i));
        // what's the difference between those two
        //itemHashMap.remove(i);
        System.out.println("Okay, deleted it");
    }

    public void deleteImportantItem(Item item) {
        String key = item.getTittle();
        if (listOfImportantItems.getValue(key).contains(item)) {
            listOfImportantItems.deleteItem(item);
            itemHashMap.get(key).remove(item);
        }
    }
}
