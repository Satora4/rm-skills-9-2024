package ch.ergon.lernende.backend.resources.dto;

import ch.ergon.lernende.backend.db.enums.AnalysisLookAndFeel;
import ch.ergon.lernende.backend.db.enums.AnalysisManufacture;
import ch.ergon.lernende.backend.db.enums.AnalysisOs;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnalysisDto {

    private String phoneName;
    private int price;
    private AnalysisManufacture manufacture;
    private AnalysisLookAndFeel lookAndFeel;
    private int ram;
    private AnalysisOs os;
    private int osVersion;
    private int storage;
    private int cam;
}
