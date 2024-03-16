package ch.ergon.lernende.backend.resources;

import ch.ergon.lernende.backend.resources.dto.AnalysisDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static ch.ergon.lernende.backend.db.Tables.ANALYSIS;

@Service
public class AnalysisService {

    private final DSLContext dsl;

    @Autowired
    public AnalysisService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<AnalysisDto> getAllAnalysis() {
        return dsl.selectFrom(ANALYSIS).fetch().stream()
                .map(r -> new AnalysisDto(r.getPhoneName(), r.getPrice(), r.getManufacture(), r.getLookAndFeel(), r.getRam(), r.getOs(), r.getOsVersion(), r.getStorage(), r.getCam()))
                .toList();
    }

    public AnalysisDto createAnalysis(AnalysisDto analysisDto) {
        dsl.insertInto(ANALYSIS)
                .set(ANALYSIS.PHONE_NAME, analysisDto.getPhoneName())
                .set(ANALYSIS.PRICE, analysisDto.getPrice())
                .set(ANALYSIS.MANUFACTURE, analysisDto.getManufacture())
                .set(ANALYSIS.LOOK_AND_FEEL, analysisDto.getLookAndFeel())
                .set(ANALYSIS.RAM, analysisDto.getRam())
                .set(ANALYSIS.OS, analysisDto.getOs())
                .set(ANALYSIS.OS_VERSION, analysisDto.getOsVersion())
                .set(ANALYSIS.STORAGE, analysisDto.getStorage())
                .set(ANALYSIS.CAM, analysisDto.getCam())
                .execute();

        return analysisDto;
    }

    public String renameAnalysis(String phoneName) {
        if (!isNameUnique(phoneName)){
            return "phone Name is not unique";
        }

        dsl.update(ANALYSIS)
                .set(ANALYSIS.PHONE_NAME, phoneName)
                .execute();

        return phoneName;
    }

    public HttpStatus deleteAnalysis(String phoneName) {
        dsl.deleteFrom(ANALYSIS)
                .where(ANALYSIS.PHONE_NAME.eq(phoneName))
                .execute();

        return HttpStatus.OK;
    }

    private boolean isNameUnique(String phoneName) {
        List<AnalysisDto> analysisDtoList = getAllAnalysis();

        return analysisDtoList.stream().filter(a -> a.getPhoneName().equals(phoneName)).count() == 0L;
    }
}
