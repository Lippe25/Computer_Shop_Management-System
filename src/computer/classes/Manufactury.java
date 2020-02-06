package computer.classes;

import java.util.Objects;

public class Manufactury {
    private int id;
    private String name;
    private int qtyStock = 0;
    private int qtyAlert;
    private int sellingCount = 0;

    public Manufactury(String name, int qtyAlert) {
        this.name = name;
        this.qtyAlert = qtyAlert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(int qtyStock) {
        this.qtyStock = qtyStock;
    }

    public int getQtyAlert() {
        return qtyAlert;
    }

    public void setQtyAlert(int qtyAlert) {
        this.qtyAlert = qtyAlert;
    }

    public int getSellingCount() {
        return sellingCount;
    }

    public void setSellingCount(int sellingCount) {
        this.sellingCount = sellingCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufactury)) return false;
        Manufactury that = (Manufactury) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Manufactury{" +
                "name='" + name + '\'' +
                '}';
    }
}
