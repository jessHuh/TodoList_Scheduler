package Project.application.Item;

import java.io.IOException;

public class ItemWithDueDate extends Item{
    public ItemWithDueDate(String index, String detail, String dueDate, String importance) throws IOException {
        super(index, detail, dueDate, importance);
    }
}
