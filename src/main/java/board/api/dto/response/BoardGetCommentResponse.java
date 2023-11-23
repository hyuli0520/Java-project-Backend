package board.api.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardGetCommentResponse {
    private final Long id;
    private final String content;
    private final String author_name;
    private final Timestamp date;
}
