package board.api.service;

import board.api.dto.request.BoardUpdateRequest;
import board.api.dto.request.BoardWriteRequest;
import board.api.dto.response.BoardGetResponse;
import board.api.dto.response.BoardInfoResponse;
import board.api.entity.Board;
import board.api.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
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
        List<Board> boardLists = boardRepository.findAll();
        List<BoardGetResponse> boardGetList = new ArrayList<BoardGetResponse>();

        for(Board board : boardLists) {
            boardGetList.add(new BoardGetResponse(
                    board.getId(),
                    board.getTitle(),
                    board.getLikes()
            ));
        }
        return boardGetList;
    }

    public BoardInfoResponse info(Long id) {
        Board boardInfo = boardRepository.findById(id)
                .orElseThrow(IllegalStateException::new);
        return new BoardInfoResponse(
                boardInfo.getId(),
                boardInfo.getTitle(),
                boardInfo.getContent(),
                boardInfo.getLikes());
    }

    public void delete(Long id) {
        Board boardDelete = boardRepository.findById(id)
                .orElseThrow(IllegalStateException::new);

        boardRepository.delete(boardDelete);
    }

    public void update(Long id,BoardUpdateRequest boardUpdateRequest) {
        Board boardUpdate = boardRepository.findById(id)
                .orElseThrow(IllegalStateException::new);
        boardUpdate.update(boardUpdateRequest.getTitle(), boardUpdateRequest.getContent());
        boardRepository.save(boardUpdate);
    }

    public void likes(Long id) {
        Board boardLikes = boardRepository.findById(id)
                .orElseThrow(IllegalStateException::new);
        boardLikes.addLikes();
        boardRepository.save(boardLikes);
    }
}
