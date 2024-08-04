package hello.kssoftware.board;

import java.util.List;

public interface BoardService {
    List<Board> getAllBoards();
    Board createBoard(Board board);
    boolean updateBoard(Long boardId, Board updateParam);
    Board deleteBoard(Long boardId);
    Board findById(Long boardId);
    List<Board> findByTitle(String title);
    List<Board> findByWriter(String writer);
}
