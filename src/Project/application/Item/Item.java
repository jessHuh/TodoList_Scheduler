package Project.application.Item;

import java.io.IOException;

public abstract class Item {

    protected String itemStr;
    protected boolean important;
    protected String tittle;
    protected String detail;
    protected String dueDate;
    protected String importance;

    public Item(String tittle, String detail, String dueDate, String importance) throws IOException {

        itemStr = tittle + ","
                + detail + ","
                + dueDate + ","
                + importance ;


        this.tittle = tittle;
        this.detail = detail;
        this.dueDate = dueDate;
        this.importance = importance;

    }


    public String getItemStr(){
        return this.itemStr;
    }

    public String getTittle(){ return this.tittle;}

    public String getDetail(){return this.detail;}

    public String getImportance(){ return this.importance;}

    public String getDueDate(){ return this.dueDate;}

    public void editDueDate(String newDueDate){ this.dueDate = newDueDate;}


    /*public void saveItem(Item item, String file) throws IOException {
        fileWrite.saveItem(item.itemStr,file);

    }*/

    /*public void addToInput() throws IOException {
        fw.saveItem(this.itemStr);
    }*/

}