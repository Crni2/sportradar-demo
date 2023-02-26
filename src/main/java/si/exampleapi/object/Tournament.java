package si.exampleapi.object;

public class Tournament {
    private Integer id;
    private Integer sportId;
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSportId() {
        return this.sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", sportId='" + getSportId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

}
