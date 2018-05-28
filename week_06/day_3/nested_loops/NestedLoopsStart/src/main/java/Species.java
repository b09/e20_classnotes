public enum Species {
    LION("Lion","Lions"),
    BEAR("Bear","Bears"),
    CROCODILE("Crocodile","Crocodiles"),
    PLATYPHUS("Platyphus", "Platyphuses"),
    DODO("Dodo", "Dodos");

    String name;
    String namePlural;

    Species(String name, String namePlural){
        this.name = name;
        this.namePlural = namePlural;
    }

    public String getName() {
        return name;
    }

    public String getNamePlural() {
        return namePlural;
    }
}
