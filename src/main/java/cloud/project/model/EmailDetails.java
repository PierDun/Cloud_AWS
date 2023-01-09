package cloud.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String body;
}