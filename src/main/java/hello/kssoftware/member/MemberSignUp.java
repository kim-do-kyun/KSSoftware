package hello.kssoftware.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
//@CrossOrigin(origins = "http://52.64.204.202")
@CrossOrigin(origins = "*")
@RequestMapping("/signup")
public class MemberSignUp {
    private final DataSource dataSource;

    public MemberSignUp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostMapping
    public ResponseEntity<Object> signup(@RequestBody Member newmember) {
        JdbcMemberRepository jdbcMemberRepository = new JdbcMemberRepository(dataSource);
        jdbcMemberRepository.save(newmember);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
    }
}
