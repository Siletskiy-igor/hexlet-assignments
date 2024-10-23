package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String title;
    private Map<String, String> attributes;
    String tagBody;
    List<Tag> child;

    public PairedTag (String title,
                      Map<String, String> attributes,
                      String tagBody,
                      List<Tag> child) {
        super(title, attributes);
        this.tagBody = tagBody;
        this.child = child;
    }

    @Override
    public String toString() {
        String str = super.toString();
        for (Tag tag: child) {
            str += tag.toString();
        }
        return str + tagBody + "</" + super.getTitle() + ">";
    }
}
// END
