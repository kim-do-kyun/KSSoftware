package hello.kssoftware.login;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Member {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "CHAR(64)")
    private String password;

    @Column(columnDefinition = "CHAR(32)")
    private String salt;

    @Column(nullable = false)
    private Integer number;

    protected Member() {
    }

    public static Member createMember(String id, String name, String password, String salt, Integer number) {
        Member member = new Member();
        member.id = id;
        member.name = name;
        member.password = password;
        member.salt = salt;
        member.number = number;
        return member;
    }

}

