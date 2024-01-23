package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private String text ;

    public ReversedSequence(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public String toString() {
        String result = "";
        int i = text.length() - 1;
        while (i > 0) {
            result = result + text.charAt(i);
        }
        return result;
    }

    @Override
    public char charAt(int index) {
        return text.charAt(text.charAt(text.length() - 1 - index));
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
// END
