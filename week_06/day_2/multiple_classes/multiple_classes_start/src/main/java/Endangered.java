public enum Endangered {
    LEAST_CONMCERN(0, "GREEN"),
    THREATENED(1, "YELLOW"),
    ENDAGERED(2, "ORANGE"),
    EXTINCT(3, "RED");

    int rank;
    String color;

    Endangered(int rank, String color){
        this.rank = rank;
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

}
