package computer.classes;

import java.util.Objects;

public class Feature {
    private int id;

    private Article article;

    private String name;
    private String value;
    private String description ;

    public Feature(Article article, String name, String value, String description) {
        this.article = article;
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public Feature() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return getId() == feature.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
