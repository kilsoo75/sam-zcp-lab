package io.noga.sample.Model;

/**
 * Product
 * {
    "id": 2,
    "title": "Cat Close Up",
    "thumb": "cat2.jpg",
    "price": 23.95,
    "tags": [ "cat", "face" ]
  },
 */
public class Product {

    String id;
    String title;
    String thumb;
    double price;
    String[] tags;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * @param thumb the thumb to set
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the tags
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString(){
        return String.format("ID: %s, title:%s, Price:%f", this.id,this.title,this.price);
    }
}