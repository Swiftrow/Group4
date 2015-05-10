package modelLayer;

import java.util.*;
/**
 * ItemContainer is a class that contain all the Item objects
 * @author group 6 - Robert Ivan, Cosmin Stan, Cristian Moldovan, Tamasan Dacian, Andrei Razvan.  
 */
public class ItemContainer
{
    private static ItemContainer instance = null;
    private ArrayList<Item> items;
    
    /**
     * Constructor af an ArrayList of type Item.
     * @param items The  array list that holds all the Item objects.
     */
    public ItemContainer(){
        items = new ArrayList<>();
    }
    
     /**
     * Singleton pattern which ensure that only one instance of a class is created.
     * @param instance The instance of the PersonContainer class.
     */
    public static ItemContainer getInstance(){
        if(instance == null){
            instance = new ItemContainer();
        }
        return instance;
    }
    
    /**
     * Add a given ITem object in the items ArrayList.
     * @param i The new Item object.
     */
    public void addItem(Item i){
        items.add(i);
    }
    
    
      /**
     * Get a Item object by a given barcode.
     * @param barcode The barcode of an item.
     */
    public Item findItem(int barcode){
        for(Item i: items){
            if(i.getBarcode() == barcode){
                return i;
            }
        }
        return null;
    }
    

    /**
     * Update the Item object information such as name, number in stock, description.
     * @param barcode the barcode of the soon to be updated Item object.
     * @param name The name of the item.
     * @param noInStock The number in stock items.
     * @param description The description fo the item.
     */ 
    public void updateItem(int barcode, int noInStock,String name,String description, String type, int minimumNo, int maximumNo, int price){

        for(Item i: items){
            if(i.getBarcode() == barcode){
                i.setName(name);
                i.setDescription(description);
                i.setNoInStock(noInStock);
                i.setType(type);
                i.setPrice(price);
                i.setMinimumNo(minimumNo);
                i.setMaximumNo(maximumNo);
            }
        }
    }
    
    
    /**
     * Delete a Item object from the items ArryList.
     * @param barcode The barcode of the Item object to be deleted.
     */
    public void deleteItem(int barcode){
        for (Iterator<Item> i = items.iterator(); i.hasNext();) {
            Item item = i.next();
            if (item.getBarcode() == barcode) {
                i.remove();
            }
        }
    }
}