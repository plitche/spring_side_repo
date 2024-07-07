package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 빈 객체들을 컨테이너 쪽에 등록
@EnableJpaAuditing // JPA Auditing을 사용하겠다.
public class JpaAuditingConfiguration {

}
