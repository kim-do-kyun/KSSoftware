package hello.kssoftware.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
//@CrossOrigin(origins = "http://52.64.204.202")
@CrossOrigin(origins = "*")
@RequestMapping("/signin")
public class MemberSignIn {
    private final DataSource dataSource;

    public MemberSignIn(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostMapping
    public ResponseEntity<String> signin(@RequestBody Member member) {

        JdbcMemberRepository jdbcMemberRepository = new JdbcMemberRepository(dataSource);
        if (jdbcMemberRepository.signin(member)){
            return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("비밀번호 틀림", HttpStatus.BAD_REQUEST);
        }
    }
}
