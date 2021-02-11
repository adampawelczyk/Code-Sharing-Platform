package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CodeSnippetService {
    @Autowired
    CodeSnippetRepository codeSnippetRepository;

    public void save(CodeSnippet codeSnippet) {
        codeSnippetRepository.save(codeSnippet);
    }

    public CodeSnippet findById(Integer id) {
        return codeSnippetRepository.findById(id).get();
    }

    public long count() {
        return codeSnippetRepository.count();
    }

    public ArrayList<CodeSnippet> getLatest() {
        ArrayList<CodeSnippet> snippets = new ArrayList<>();
        long start = codeSnippetRepository.count();
        long stop = Math.max(start - 10, 0);
        for (int i = (int) start; i > stop; i--) {
            snippets.add(codeSnippetRepository.findById(i).get());
        }
        return snippets;
    }
}