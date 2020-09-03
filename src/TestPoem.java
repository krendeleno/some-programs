public class TestPoem {
    public static void main(String[] args) {
        Poem a = new Poem (new String[] {"Hello", "Sprinter", "Sr", "Autumter"});
        Poem b = new Poem (new String[] {"Hello", "Sprinter,", "Sr", "Autumter,"});
        a.findRhymesSimple();
        b.findRhymesHard();
    }
}
