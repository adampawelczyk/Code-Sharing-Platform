package platform;

import java.util.HashMap;
import java.util.Map;

public class CodeSnippet {
    private final static String code = "public static void main(String[] args) {" +
            "SpringApplication.run(CodeSharingPlatform.class, args);}";

    public static String getHTMLCode() {
        return "<html>\n" +
                "   <head>\n" +
                "       <title>Code</title>\n" +
                "   </head>\n" +
                "   <body>\n" +
                "       <pre>\n" +
                "           " + code +"\n" +
                "       </pre>\n" +
                "   </body>\n" +
                "</html>";
    }

    public static Map<String, String> getJsonCode() {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        return map;
    }
}
