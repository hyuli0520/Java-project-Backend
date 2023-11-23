package board.api.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class BoardInfoResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final int likes;
}
