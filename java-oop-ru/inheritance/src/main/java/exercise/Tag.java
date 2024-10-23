package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {

    private String title;
    private Map<String, String> attributes;

    public Tag(String title, Map<String, String> attributes) {
        this.title = title;
        this.attributes = attributes;
    }

    public String toString() {
        String res = "<" + title + " ";
        for (var entry : attributes.entrySet()) {
            String loop = entry.getKey() + "=" + "\"" + entry.getValue() + "\" ";
            res += loop;
        }
        return res.trim() + ">";
    }

    public String getTitle() {
        return title;
    }
}
// END
