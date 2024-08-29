package co.com.orange.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CandidateStatusModel {
    private String candidate;
    private String status;
    private String vacancy;
}
