package board.api.controller;

import board.api.dto.request.BoardCommentRequest;
import board.api.dto.request.BoardLikesRequest;
import board.api.dto.request.BoardUpdateRequest;
import board.api.dto.request.BoardWriteRequest;
import board.api.dto.response.BoardGetCommentResponse;
import board.api.dto.response.BoardGetResponse;
import board.api.dto.response.BoardInfoResponse;
import board.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/post")
    public void post (@RequestBody BoardWriteRequest boardWriteRequest) {
        boardService.write(boardWriteRequest);
    }

    @GetMapping("/get")
    public List<BoardGetResponse> get () {
        return boardService.get();
    }

    @GetMapping("/info")
    public BoardInfoResponse info(@RequestParam Long id) {
        return boardService.info(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        boardService.delete(id);
    }

    // /update?id=
    @PutMapping("/update")
    public void update(@RequestParam Long id, @RequestBody BoardUpdateRequest boardUpdateRequest) {
        boardService.update(id, boardUpdateRequest);
    }

    @PostMapping("/likes")
    public void likes(@RequestBody BoardLikesRequest boardLikesRequest) {
        boardService.likes(boardLikesRequest.getBoardId());
    }

    @PostMapping("/post/comment")
    public void comment(@RequestParam Long id, @RequestBody BoardCommentRequest boardCommentRequest) {
        boardService.comment(id, boardCommentRequest);
    }


    @GetMapping("/get/comment")
    public List<BoardGetCommentResponse> getComment(@RequestParam Long id) {
        return boardService.getComment(id);
    }
}