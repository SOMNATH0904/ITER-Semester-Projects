package SOMNATH_SHAW_2241019426;

public class Address {
    String Street;
    String City;
    String State;
    int PinCode;

    Address(String Street, String City, String State, int PinCode) {
        this.Street = Street;
        this.City = City;
        this.State = State;
        this.PinCode = PinCode;
    }

    //Setter
    public void setStreet(String Street) {
        this.Street = Street;
    }
    public void setCity(String City) {
        this.City = City;
    }
    public void setState(String State) {
        this.State = State;
    }
    public void setPinCode(int PinCode) {
        this.PinCode = PinCode;
    }

    //getter
    public String getStreet() {
        return Street;
    }
    public String getCity() {
        return City;
    }
    public String getState() {
        return State;
    }
    public int pincode() {
        return PinCode;
    }

    public String getAddress() {
        return (Street + " , " + City + " , " + State + " , " + PinCode);
    }
}
