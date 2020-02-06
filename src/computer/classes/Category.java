package computer.classes;

import java.util.Objects;

public class Category {
    private int id;
    private String name;
    private float surplus = 0;
    private int surplusCount = 0;
    private int qtyAlert = 0;
    private String description;

    public Category(int id, String name, float surplus, int surplusCount,int qtyAlert, String description) {
        this.id = id;
        this.name = name;
        this.surplus = surplus;
        this.surplusCount = surplusCount;
        this.qtyAlert = qtyAlert;
        this.description = description;
    }

    public Category(String name, float surplus, int surplusCount,int qtyAlert, String description) {
        this.name = name;
        this.surplus = surplus;
        this.surplusCount = surplusCount;
        this.qtyAlert = qtyAlert;
        this.description = description;
    }

    public Category() {
    }

    public int getQtyAlert() {
        return qtyAlert;
    }

    public void setQtyAlert(int qtyAlert) {
        this.qtyAlert = qtyAlert;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSurplus() {
        return surplus;
    }

    public void setSurplus(float surplus) {
        this.surplus = surplus;
    }

    public int getSurplusCount() {
        return surplusCount;
    }

    public void setSurplusCount(int surplusCount) {
        this.surplusCount = surplusCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return getId() == category.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
