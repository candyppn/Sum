public class SeparatedWord {
    private final String first;
    private final String second;

    public SeparatedWord (String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public SeparatedWord switchHalves() {
        return new SeparatedWord(second, first);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SeparatedWord) {
            SeparatedWord word = (SeparatedWord) o;
            return word.getFirst().equals(first) && word.getSecond().equals(second);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    @Override
    public String toString() {
        return "( " + first + " + " + second + " )";
    }

}
