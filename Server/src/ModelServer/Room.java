package ModelServer;

public class Room {
    private String announcement;
    private String price;
    private String address;
    private String size;
    private String bedrooms;
    private boolean isReserved;

    public Room(String announcement,String price, String address, String size, String bedrooms) {
        this.announcement = announcement;
        this.price = price;
        this.address = address;
        this.size = size;
        this.bedrooms = bedrooms;
        isReserved = false;
    }
    public String getAnnouncement(){
        return announcement;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public boolean isReserved()
    {
        return isReserved;
    }

    public void setReserved(boolean reserved)
    {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Room{" +
                "price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", size='" + size + '\'' +
                ", bedrooms='" + bedrooms + '\'' +
                '}';
    }
}

