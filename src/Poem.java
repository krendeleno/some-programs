public class Poem {
    String[] poemStrings;

    Poem(String[] poemStrings) {
        this.poemStrings = poemStrings;
    }

    public void findRhymesSimple() {
        for (int i = 0; i < poemStrings.length - 1; i++)
            if (poemStrings[i].length() >= 3)
                for (int j = i + 1; j < poemStrings.length; j++) {
                    if (poemStrings[j].length() >= 3)
                        if (poemStrings[i].substring(poemStrings[i].length() - 3).equals(poemStrings[j].substring(poemStrings[j].length() - 3)))
                            System.out.println("Строка " + (i + 1) + " рифмуется со строкой " + (j + 1));
                }

    }
}
