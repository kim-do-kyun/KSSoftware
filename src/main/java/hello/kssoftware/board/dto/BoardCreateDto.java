package hello.kssoftware.board.dto;

import hello.kssoftware.login.Member;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateDto {
    
    private Member writer;

    @NotEmpty(message = "제목을 입력하세요.")
    private String title;

    @NotEmpty(message = "내용을 입력하세요.")
    private String content;
}
