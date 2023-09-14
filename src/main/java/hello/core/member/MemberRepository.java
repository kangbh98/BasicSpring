package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
