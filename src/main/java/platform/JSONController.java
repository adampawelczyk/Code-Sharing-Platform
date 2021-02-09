package platform;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class JSONController {
    @GetMapping(path = "/api/code")
    public ResponseEntity<Map<String, String>> getJSON() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");

        return ResponseEntity.ok().headers(responseHeaders).body(CodeSnippet.getJsonCode());
    }
}
