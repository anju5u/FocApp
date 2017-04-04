package admin.ats.com.focaloidproject;

/**
 * Created by user on 4/3/2017.
 */

public class Collections {
    private String name;
    private String price;
    private int imageurl;

    public Collections(String name, String price, int imageurl) {
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
