package board.api.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BoardWriteRequest {
    private String title;
    private String content;
}
