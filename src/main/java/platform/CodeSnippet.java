package platform;

import java.util.HashMap;
import java.util.Map;

public class CodeSnippet {
    private static String code = "public static void main(String[] args) {" +
            "SpringApplication.run(CodeSharingPlatform.class, args);}";
    private static String dateTime = "2021-02-03 14:44:37";

    public static String getHTMLCode() {
        return "<html>\n" +
                "   <head>\n" +
                "       <title>Code</title>\n" +
                "       <style>" +
                "           pre {" +
                "               background-color: lightgray;" +
                "               margin: 10px 10px 10px 10px;" +
                "               border: 2px solid gray;" +
                "               padding: 5px 5px 5px 5px;" +
                "           }" +
                "           span {" +
                "               color: green;" +
                "           }" +
                "       </style>" +
                "   </head>\n" +
                "   <body>\n" +
                "       <span id=\"load_date\">" + dateTime + "</span>\n" +
                "       <pre id=\"code_snippet\">\n" +
                "           " + code +"\n" +
                "       </pre>\n" +
                "   </body>\n" +
                "</html>";
    }

    public static Map<String, String> getJsonCode() {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("date", dateTime);
        return map;
    }

    public static void setCode(String code) {
        CodeSnippet.code = code;
    }

    public static void setDateTime(String dateTime) {
        CodeSnippet.dateTime = dateTime;
    }
}
