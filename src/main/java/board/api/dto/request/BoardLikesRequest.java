package board.api.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardLikesRequest {
    private Long boardId;
}
