package at.ac.tuwien.inso.sepm.ticketline.server.entity.mapper.news;

import org.mapstruct.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

@Component
public class NewsSummaryMapper {

    private static final int NUMBER_OF_ALLOWED_CHARACTERS = 50;
    private static final Pattern PATTERN = Pattern.compile("^(.{0," + NUMBER_OF_ALLOWED_CHARACTERS + "})(\\s|$)|.*$");

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface NewsSummary {
    }

    /**
     * Intelligent trim of text to summary.
     * <p>
     * A summary can contain NUMBER_OF_ALLOWED_CHARACTERS characters.
     * If it is longer it will be stripped down to the last whitespace character or if there is not at exactly the maximum length.
     *
     * @param text which should be trimmed
     * @return timmed text
     */
    @NewsSummary
    public String trimTextToSummary(String text) {
        /*Matcher matcher = PATTERN.matcher(text);
        if (!matcher.find()) {
            return "";
        }
        if (matcher.groupCount() >= 1) {
            return matcher.group(1);
        } else {
            return text.substring(0, (Math.min(text.length(), NUMBER_OF_ALLOWED_CHARACTERS)));
        }*/
        if(text.isEmpty()){
            return "";
        }else if(text.length() <= 50){
            return text;
        }else{
            return text.substring(0, Math.min(text.length(), NUMBER_OF_ALLOWED_CHARACTERS)) + "...";
        }

    }

}