package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private long businessId;

    @Column
    private long amount;

    public Payment() {
    }

    public Payment(long businessId, long amount) {
        this.businessId = businessId;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
