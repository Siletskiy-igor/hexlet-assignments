package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String tagBody;
    List<Tag> childList;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> children) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childList = children;
    }

    public String childToString() {
        String result = "";
        for(Tag child: childList) {
            result += child;
        }
        return result;
    }


    @Override
    public String toString() {
        return "<" + tagName  + attrToString() + ">" + tagBody + childToString() + "</" + tagName + ">";
    }
}
// END
