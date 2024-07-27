package ru.ct.alchemy.model.inventory;

public interface InventoryItem {
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    int getAmount();
    void setAmount(Integer amount);
    String getType();
    void setType(String type);
}
