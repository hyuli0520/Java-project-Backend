package board.api.controller;

import board.api.dto.request.BoardLikesRequest;
import board.api.dto.request.BoardUpdateRequest;
import board.api.dto.request.BoardWriteRequest;
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

    // http://localhost:8082/api/post?id=
    @PostMapping("/post")
    public void post (@RequestBody BoardWriteRequest boardWriteRequest) {
        boardService.write(boardWriteRequest);
    }

    @GetMapping("/get")
    public List<BoardGetResponse> get () {
        return boardService.get();
    }

    @GetMapping("/info/{id}")
    public BoardInfoResponse info(@PathVariable("id") Long id) {
        return boardService.info(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        boardService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestParam Long id, @RequestBody BoardUpdateRequest boardUpdateRequest) {
        boardService.update(id, boardUpdateRequest);
    }

    @PostMapping("/likes")
    public void likes(@RequestBody BoardLikesRequest boardLikesRequest) {
        boardService.likes(boardLikesRequest.getBoardId());
    }

    @PostMapping("/post/commend")

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}