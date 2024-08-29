package co.com.orange.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CandidateModel {

    private String contactNumber;
    private String email;
    private String firstName;
    private String keywords;
    private String lastName;
    private String vacancy;
}
