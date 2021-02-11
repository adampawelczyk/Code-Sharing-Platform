package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Controller
public class JSONController {
    @Autowired
    CodeSnippetService codeSnippetService;

    @GetMapping(path = "/api/code/{id}")
    public ResponseEntity<CodeSnippet> getCode(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok().headers(httpHeaders).body(codeSnippetService.findById(id));
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    public ResponseEntity<String> newCode(@RequestBody CodeSnippet codeSnippet) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        codeSnippetService.save(codeSnippet);
        String response = String.format("{\"id\": \"%s\"}", codeSnippetService.count());
        return ResponseEntity.ok().headers(httpHeaders).body(response);
    }

    @GetMapping(value = "/api/code/latest")
    public ResponseEntity<ArrayList<CodeSnippet>> getLatest() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok().headers(responseHeaders).body(codeSnippetService.getLatest());
    }
}