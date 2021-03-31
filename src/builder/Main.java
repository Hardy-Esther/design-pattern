package builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort()
                .buildWall()
                .buildMine()
                .build();

        Person p = new Person.PersonBuilder()
                .basicInfo(1,"张三",25)
                .score(80)
                .weight(120)
                .loc("bj","203")
                .build();

    }
}
