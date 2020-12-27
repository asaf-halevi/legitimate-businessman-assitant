package model;

public class Payment {

    private long id;
    private long businessId;
    private long amount;

    public Payment(long id, long businessId, long amount) {
        this.id = id;
        this.businessId = businessId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", businessId=" + businessId +
                ", amount=" + amount +
                '}';
    }
}
