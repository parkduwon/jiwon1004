package kr.co.jiwon1004.domain.signIn.repository;


import kr.co.jiwon1004.domain.signIn.entity.SignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignInRepository extends JpaRepository<SignIn, Long> {
}
