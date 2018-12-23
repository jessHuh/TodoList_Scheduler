package Project.application.Item;

import java.io.IOException;

public class ItemWithoutDueDate extends Item {


    public ItemWithoutDueDate(String index, String detail, String dueDate, String importance) throws IOException {


        super(index, detail, dueDate, importance);
        this.dueDate = null;
        itemStr = index + ","
                + detail + ","
                + "NO DUE DATE" + ","
                + importance ;
    }
}
