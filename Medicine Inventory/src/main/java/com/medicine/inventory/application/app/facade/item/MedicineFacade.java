package com.medicine.inventory.application.app.facade.item;

import com.medicine.inventory.application.model.item.Item;

import java.util.List;

public interface MedicineFacade {

    Item getItemByMedicine_Id(int Medicine_Id);

    List<Item> getAllItems();

    boolean addItem(Item item);

    boolean updateItem(Item item);

    boolean deleteItemByMedicine_Id(int medicine_id);
}
