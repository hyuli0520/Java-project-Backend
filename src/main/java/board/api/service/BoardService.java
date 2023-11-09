package board.api.service;

import board.api.dto.request.BoardWriteRequest;
import board.api.dto.response.BoardGetResponse;
import board.api.entity.Board;
import board.api.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void write(BoardWriteRequest boardWriteRequest) {
        Board board = Board.builder()
                .title(boardWriteRequest.getTitle())
                .content(boardWriteRequest.getContent())
                .build();
        board = boardRepository.save(board);
    }

    public List<BoardGetResponse> get() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardGetResponse> boardGetList = new ArrayList<BoardGetResponse>();

        for(Board board : boardList) {
            boardGetList.add(new BoardGetResponse(
                    board.getId(),
                    board.getTitle(),
                    board.getLikes()
            ));
        }
        return boardGetList;
    }
}
