package Project.application.Item;

import Project.application.function.FileWrite;
import Project.application.exception.outBoundException;

import java.io.IOException;
import java.util.*;

public class ItemManager extends Subject {
    private Map<String, ArrayList<Item>> itemMap;
    private List<Item> importantItemList;
    private Project.application.function.FileWrite fileWrite = new FileWrite();
    private String file = "outputItems.txt";
    //private static ItemManager instance;

    public ItemManager() {
        itemMap = new HashMap<>();
        importantItemList = new ArrayList<>();

    }

    public void addKey(String key){
        // TODO: have to change main method as well
        itemMap.put(key, new ArrayList<>());
    }

    public void browseKey(){
        Set<String> keyList = getKey();
        for(String key: keyList){
            System.out.println(key);
        }
    }

    public List<Item> getImportantItemList(){
        return importantItemList;
    }

    public boolean containKey(String key){
        return getKey().contains(key);
    }

    public void addItem(String key, Item item) throws IOException {
        // if key does not exist I should complain it and ask if I want to make a new key

        // TODO: throw exception or use if it's already exists then do nothing

        itemMap.get(key).add(item);

        if(item.getImportance().equals("yes")) importantItemList.add(item);

        notifyObservers(item);

        fileWrite.saveItemMap(this, file);

    }

    public void addItemFromLoad(String key, Item item) {
        // if key does not exist I should complain it and ask if I want to make a new key

        // TODO: throw exception or use if it's already exists then do nothing
        itemMap.get(key).add(item);

        if(item.getImportance().equals("yes")) importantItemList.add(item);

    }

    public Integer getSize(String key){
        return itemMap.get(key).size();
    }

    // TODO: handle item does not exist exception
    // TODO: a check that the integer is not null before casting
    public Item getItem(String course, Integer i){
        return itemMap.get(course).get(i);
    }

    public Set<String> getKey(){
        return itemMap.keySet();
    }

    public ArrayList<Item> getValue(String key){
        return itemMap.get(key);
    }

    public void broseAllItem(){
        for (String key: itemMap.keySet()) {
            System.out.println("Index : " + key);
            for(Item item  : itemMap.get(key)){
                System.out.print(itemMap.get(key).indexOf(item) + " ");
                printOut(item);
            }
        }
    }

    public Map<String, ArrayList<Item>> getItemMap(){
        return itemMap;

    }

    public void browseItembyKey(String key){
        for(Item item  : itemMap.get(key)){
            if(item.getTittle().equals(key)){
                System.out.print(itemMap.get(key).indexOf(item) + " ");
                printOut(item);
            }
        }
    }

    //TODO: sorted by tittle would be nice !
    public void browseImportantItem(){
            for(Item item : importantItemList){
                if(item.getImportance().equals("yes")){
                    printOut(item);
                }
            }
    }

    private void printOut(Item item) {
        System.out.print("Tittle: " + item.getTittle() + " ");
        System.out.print("Detail: " + item.getDetail() + " ");
        System.out.print("Deadline: " + item.getDueDate() + " ");
        System.out.println("Important?: " + item.getImportance());
    }

    public void deleteItem(String key, Integer i) throws outBoundException {
        if(i >= itemMap.get(key).size()){
            throw new outBoundException();
        }

        Item itemNeedToBeDeleted = getValue(key).get(i);
        itemMap.get(key).remove(itemNeedToBeDeleted);
        //Item itemNeedToBeDeleted = getValue(key).get(i);
        importantItemList.remove(itemNeedToBeDeleted);

        //deleteImportantItem(itemHashMap.get(tittle).get(i));
        // what's the difference between those two
        //itemHashMap.remove(i);
        System.out.println("Okay, deleted it");
    }


}
