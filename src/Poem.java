public class Poem {
    static char[] vowels = new char[]{'a', 'o', 'u', 'y', 'i', 'e'};
    static char[] commas = new char[]{';', ',', '?', '!', '.', ':'};

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

    public void findRhymesHard() {
        int iVowel = -1;
        int jVowel = -1;
        for (int i = 0; i < poemStrings.length - 1; i++) {
            for (char vowel : vowels)
                if (poemStrings[i].lastIndexOf(vowel) != -1 && poemStrings[i].lastIndexOf(vowel) > iVowel) {
                    iVowel = poemStrings[i].indexOf(vowel);
                }
            if (iVowel != -1) {
                String iString = poemStrings[i].replaceAll("[^a-zA-Z ]", "");
                for (int j = i + 1; j < poemStrings.length; j++) {
                    for (char vowel : vowels)
                        if (poemStrings[j].lastIndexOf(vowel) != -1 && poemStrings[j].lastIndexOf(vowel) > jVowel) {
                            jVowel = poemStrings[j].lastIndexOf(vowel);
                        }
                    if (jVowel != -1) {
                        String jString = poemStrings[j].replaceAll("[^a-zA-Z ]", "");
                        if (iString.substring(iVowel).equals(jString.substring(jVowel)))
                            System.out.println("Строка " + (i + 1) + " рифмуется со строкой " + (j + 1));
                    }
                    jVowel = -1;
                }
            }
            iVowel = -1;
        }
    }
}
