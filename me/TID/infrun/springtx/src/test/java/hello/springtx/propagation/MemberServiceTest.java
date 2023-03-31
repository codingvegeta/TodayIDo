package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LogRepository logRepository;

    /**
     * memberService @Transactional:OFF
     * memberRepository @Transactional:ON
     * memberService @Transactional:ON
     */
    @Test
    void outerTxOff_success() {
        String username = "outerTxOff_success";

        memberService.joinV1(username);

        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService @Transactional:OFF
     * memberRepository @Transactional:ON
     * memberService @Transactional:ON Exception
     */
    @Test
    void outerTxOff_fail() {
        String username = "로그예외_outerTxOff_fail";

        assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService @Transactional:ON
     * memberRepository @Transactional:OFF
     * memberService @Transactional:OFF
     */

    @Test
    void singleTx() {
        String username = "singleTx";

        memberService.joinV1(username);

        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService @Transactional:ON
     * memberRepository @Transactional:ON
     * memberService @Transactional:ON
     */
    @Test
    void outerTxOn_success() {
        String username = "outerTxOn_success";

        memberService.joinV1(username);

        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService @Transactional:ON
     * memberRepository @Transactional:ON
     * memberService @Transactional:ON Exception
     */
    @Test
    void outerTxOn_fail() {
        String username = "로그예외_outerTxOn_fail";

        assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService @Transactional:ON
     * memberRepository @Transactional:ON
     * memberService @Transactional:ON Exception
     */
    @Test
    void recoverException_fail() {
        String username = "로그예외_recoverException_fail";

        assertThatThrownBy(() -> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService @Transactional:ON
     * memberRepository @Transactional:ON
     * memberService @Transactional:ON(REQUIRES_NEW) Exception
     */
    @Test
    void recoverException_success() {
        String username = "로그예외_recoverException_success";

        memberService.joinV2(username);

        //when: member 저장, log 롤백
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }
}
