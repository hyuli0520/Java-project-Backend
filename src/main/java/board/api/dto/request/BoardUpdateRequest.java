package board.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateRequest {
    private Long id;
    private String title;
    private String content;
}
