package hello.kssoftware.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board) {
        board.setCreatedDate(now());
        board.setUpdatedDate(now());

        //임시 (로그인 서비스로부터 작성자 추출해야함)
        if (board.getWriter() == null) {
            board.setWriter("testWriter");
        }

        log.info(board.toString());
        return boardRepository.save(board);
    }

    @Override
    public boolean updateBoard(Long boardId, Board updateParam) {
        log.info(updateParam.toString());
        Board findBoard = findById(boardId);

        findBoard.setTitle(updateParam.getTitle());
        findBoard.setContent(updateParam.getContent());
        findBoard.setUpdatedDate(now());

        return boardRepository.update(boardId, findBoard);
    }

    @Override
    public Board deleteBoard(Long boardId) {
        return boardRepository.delete(boardId);
    }

    @Override
    public Board findById(Long boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    public List<Board> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Board> findByWriter(String writer) {
        return null;
    }

    private Date now() {
        java.util.Date utilDate = new java.util.Date();
        long currentMilliseconds = utilDate.getTime();

        return new java.sql.Date(currentMilliseconds);
    }
}
