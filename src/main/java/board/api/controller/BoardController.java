package board.api.controller;

import board.api.dto.request.BoardWriteRequest;
import board.api.dto.response.BoardGetResponse;
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

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}