package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HTMLController {
    @Autowired
    CodeSnippetService codeSnippetService;

    @GetMapping(path = "/code/{id}")
    public String getCode(Model model, @PathVariable int id) {
        model.addAttribute("codeSnippet", codeSnippetService.findById(id));
        return "code";
    }

    @GetMapping(path = "/code/new")
    public String newCode() {
        return "new";
    }

    @GetMapping(path = "code/latest")
    public String latest(Model model) {
        model.addAttribute("codeSnippets", codeSnippetService.getLatest());
        return "latest";
    }
}
