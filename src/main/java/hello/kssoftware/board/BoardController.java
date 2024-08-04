package hello.kssoftware.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @GetMapping
    public String boards(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    @GetMapping("/{id}")
    public String board(@PathVariable(value = "id") long id, Model model) {
        Board findBoard = boardService.findById(id);
        model.addAttribute("board", findBoard);
        return "board/board";
    }

    @GetMapping("/post")
    public String postForm() {
        return "board/post";
    }

    @PostMapping("/post")
    public String createBoard(Board board, RedirectAttributes redirectAttributes) {
        Board createdBoard = boardService.createBoard(board);
        redirectAttributes.addAttribute("boardId", createdBoard.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/board";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable(value = "id") long id, Model model) {
        Board findBoard = boardService.findById(id);
//        model.addAttribute("id")
        model.addAttribute("board", findBoard);
        return "board/edit";
    }

    @PostMapping("/{id}/edit")
    public String editBoard(@PathVariable(value = "id") Long id, Board board) {
        boardService.updateBoard(id, board);
        return "redirect:/board/{id}";
    }

    @RequestMapping("/{id}/delete")
    public String deleteBoard(@PathVariable(value = "id") Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board";
    }
}
