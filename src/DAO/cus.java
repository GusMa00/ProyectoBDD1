package DAO;

public class cus {
    private int CustomerID;
    private int PersonID;
    private int StoreID;
    private int TerritoryID;
    private String AccountNumber;
    private String rowguid;
    private String ModifiedDate;


    public int getCustomerID() {
        return this.CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getPersonID() {
        return this.PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public int getStoreID() {
        return this.StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }

    public int getTerritoryID() {
        return this.TerritoryID;
    }

    public void setTerritoryID(int TerritoryID) {
        this.TerritoryID = TerritoryID;
    }

    public String getAccountNumber() {
        return this.AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getRowguid() {
        return this.rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getModifiedDate() {
        return this.ModifiedDate;
    }

    public void setModifiedDate(String ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }


}
