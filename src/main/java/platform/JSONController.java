package platform;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class JSONController {
    @GetMapping(path = "/api/code")
    public ResponseEntity<Map<String, String>> getJSON() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");

        return ResponseEntity.ok().headers(responseHeaders).body(CodeSnippet.getJsonCode());
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    public ResponseEntity<String> apiCreate(@RequestBody Code code) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");

        CodeSnippet.setCode(code.getCode());
        CodeSnippet.setDateTime(code.getLocalDateTime());

        return ResponseEntity.ok().headers(responseHeaders).body("{}");
    }
}
