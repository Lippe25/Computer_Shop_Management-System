package computer.classes;

import java.util.Objects;

public class Article {
    private int id;

    private Manufactury manufactury;
    private Procurement procurement;
    private Bill bill;
    private Category category;
    private float discount;

    private String serialNumber;
    private String modelName;
    private int sellingPrice;
    private int realSellingPrice;
    private float TVA = (float) 19.6;
    private String articlePicture;
    private String articleDescription;

    public Article() {
    }

    public Article(int id, Manufactury manufactury, Procurement procurement, Bill bill, Category category,
                   float discount, String serialNumber, String modelName, int sellingPrice, int realSellingPrice,
                   float tva, String articlePicture, String articleDescription) {
        this.id = id;
        this.manufactury = manufactury;
        this.procurement = procurement;
        this.bill = bill;
        this.category = category;
        this.discount = discount;
        this.serialNumber = serialNumber;
        this.modelName = modelName;
        this.sellingPrice = sellingPrice;
        this.realSellingPrice = realSellingPrice;
        this.TVA = tva;
        this.articlePicture = articlePicture;
        this.articleDescription = articleDescription;
    }

    public Article(Article article){
        this.id = article.id;
        this.manufactury = article.manufactury;
        this.procurement = article.procurement;
        this.bill = article.bill;
        this.category = article.category;
        this.discount = article.discount;
        this.serialNumber = article.serialNumber;
        this.modelName = article.modelName;
        this.sellingPrice = article.sellingPrice;
        this.realSellingPrice = article.realSellingPrice;
        this.TVA = article.TVA;
        this.articlePicture = article.articlePicture;
        this.articleDescription = article.articleDescription;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public Manufactury getManufactury() {
        return manufactury;
    }

    public void setManufactury(Manufactury manufactury) {
        this.manufactury = manufactury;
    }

    public Procurement getProcurement() {
        return procurement;
    }

    public Bill getBill() {
        return bill;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getRealSellingPrice() {
        return realSellingPrice;
    }

    public void setRealSellingPrice(int realSellingPrice) {
        this.realSellingPrice = realSellingPrice;
    }

    public float getTVA() {
        return TVA;
    }

    public void setTVA(float TVA) {
        this.TVA = TVA;
    }

    public String getArticlePicture() {
        return articlePicture;
    }

    public void setArticlePicture(String articlePicture) {
        this.articlePicture = articlePicture;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getSerialNumber(), article.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNumber());
    }

    @Override
    public String toString() {
        return "\nArticle{ \n" +
                "\t " + manufactury.getName().toUpperCase() + " " + modelName +
                "\n}";
    }
}
