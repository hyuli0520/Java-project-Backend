package board.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCommentRequest {
    private String content;
    private String authorName;
}
