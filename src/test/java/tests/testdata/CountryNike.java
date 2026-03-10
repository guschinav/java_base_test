package tests.testdata;

public enum CountryNike {
    Finland("AIR MAX 90"),
    México("AIR MAX 95");



    public final String description;

    CountryNike (String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
