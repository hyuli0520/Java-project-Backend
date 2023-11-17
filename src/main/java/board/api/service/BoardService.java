package board.api.service;

import board.api.dto.request.BoardCommentRequest;
import board.api.dto.request.BoardUpdateRequest;
import board.api.dto.request.BoardWriteRequest;
import board.api.dto.response.BoardGetCommentResponse;
import board.api.dto.response.BoardGetResponse;
import board.api.dto.response.BoardInfoResponse;
import board.api.entity.Board;
import board.api.entity.BoardComment;
import board.api.repository.BoardCommentRepository;
import board.api.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardCommentRepository boardCommentRepository;

    public void write(BoardWriteRequest boardWriteRequest) {
        Board board = Board.builder()
                .title(boardWriteRequest.getTitle())
                .content(boardWriteRequest.getContent())
                .build();
        boardRepository.save(board);
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

    public void comment(Long id, BoardCommentRequest boardCommentRequest) {
        BoardComment boardComment = BoardComment.builder()
                .boardId(id)
                .content(boardCommentRequest.getContent())
                .author_name(boardCommentRequest.getAuthorName())
                .build();
        boardCommentRepository.save(boardComment);
    }

    public List<BoardGetCommentResponse> getComment(Long id) {
        BoardComment boardComment = new BoardComment(id);
        List<BoardComment> boardComments = boardCommentRepository.findByBoardId(boardComment.getBoardId());
        List<BoardGetCommentResponse> boardGetCommentResponses = new ArrayList<>();

        for(BoardComment b : boardComments) {
            boardGetCommentResponses.add(new BoardGetCommentResponse(
                    b.getId(),
                    b.getContent(),
                    b.getAuthor_name(),
                    b.getDate()
            ));
        }
        return boardGetCommentResponses;
    }
}
