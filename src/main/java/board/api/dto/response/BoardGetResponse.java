package board.api.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardGetResponse {
    private final Long id;
    private final String title;
    private final int likes;
}
