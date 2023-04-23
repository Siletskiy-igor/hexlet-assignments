package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag{
    String tagName;
    Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String attrToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry: tagAttributes.entrySet()) {
            stringBuilder.append(" " + entry.getKey())
                    .append("=")
                    .append("\"")
                    .append(entry.getValue())
                    .append("\"");
        }
        return stringBuilder.toString();
    }

}
// END
