package platform;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {
    @GetMapping(path = "/code")
    public ResponseEntity<String> getHTML() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text/html");

        return ResponseEntity.ok().headers(responseHeaders).body(CodeSnippet.getHTMLCode());
    }
}
