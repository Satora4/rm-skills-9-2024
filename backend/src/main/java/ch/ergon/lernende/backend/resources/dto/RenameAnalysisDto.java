package ch.ergon.lernende.backend.resources.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RenameAnalysisDto {
    private String oldName;
    private String newName;
}
