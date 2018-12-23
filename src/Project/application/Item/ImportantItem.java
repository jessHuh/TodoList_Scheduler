package Project.application.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ImportantItem {
    private Map<String, ArrayList<Item>> importantItemsMap;
    private ListOfItems listOfItems;

    public ImportantItem(){
     importantItemsMap = new HashMap<>();
        addKey("210");
        addKey("121");
        addKey("302");
        addKey("200");
    }

    // our tittle is our key in the map
    private  void addKey(String course){
        importantItemsMap.put(course, new ArrayList<>());
    }

    public void setListOfItems(ListOfItems listOfItems){
        if(this.listOfItems == null){
            this.listOfItems = listOfItems;
        }
    }

    public void addItem(Item item){
        ArrayList<Item> items = importantItemsMap.get(item.getTittle());
        items.add(item);

        if(listOfItems != null && ! listOfItems.getValue(item.getTittle()).contains(item)){
            listOfItems.addItem(item);
        }
    }

    public void deleteItem(Item item){
        String key = item.getTittle();
        if( listOfItems.getValue(item.getTittle()).contains(item)){
            listOfItems.deleteImportantItem(item);
            importantItemsMap.get(key).remove(item);
        }
    }

    public ArrayList<Item> getValue(String index){
        return importantItemsMap.get(index);
    }

    public Set<String> getKey(){
        return importantItemsMap.keySet();
    }

    public void printImportantItem() throws IOException {
        for(String key : importantItemsMap.keySet()){
            for(Item item : importantItemsMap.get(key)){
                    System.out.print("Course: " + item.getTittle()+ " ");
                    System.out.print("Detail: " + item.getDetail()+ " ");
                    /*SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    String formatted = format1.format(item.getDueDate());*/
                    System.out.print("Deadline: " + item.getDueDate() + " ");
                    System.out.println("Important?: " + item.getImportance());
            }
        }
    }

}
