package hello.kssoftware.board.comment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreate {
    private boolean anonymousYn;
    @NotEmpty(message = "내용을 입력하세요.")
    private String content;
}
