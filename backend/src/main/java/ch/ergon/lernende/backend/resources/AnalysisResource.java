package ch.ergon.lernende.backend.resources;

import ch.ergon.lernende.backend.resources.dto.AnalysisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analysis")
public class AnalysisResource {

    private final AnalysisService analysisService;

    @Autowired
    public AnalysisResource(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping
    public List<AnalysisDto> getAllAnalysis() {
        return analysisService.getAllAnalysis();
    }

    @PostMapping
    public AnalysisDto createAnalysis(@RequestBody AnalysisDto analysisDto) {
        return analysisService.createAnalysis(analysisDto);
    }

    @PatchMapping
    public String renameAnalysis(@RequestBody String phoneName) {
        return analysisService.renameAnalysis(phoneName);
    }

    @DeleteMapping
    public HttpStatus deleteAnalysis(@RequestBody String phoneName) {
        return analysisService.deleteAnalysis(phoneName);
    }
}
